
import socket
import threading

def thread_run(conn):
    while True:
        print(conn.recv(1024))

def input_thread_run(socketlist):
    while True:
        sendtext=input()
        print(sendtext)
        for item in socketlist:
            print(item)
            item.sendall(bytes(sendtext, "utf-8"))





# AF_INET = IPv4
# SOCK_STREAM = TCP
sock=socket.socket(family=socket.AF_INET, type=socket.SOCK_STREAM)
# 127.0.0.1 para que solo sea accesible localmente
sock.bind(('0.0.0.0', 8080))
sock.listen()
#sock.setblocking(False)
connlist=[]
datalist_lock=threading.Lock()
datalist=[]
while True:
    conn,addr=sock.accept()
    connlist.append(conn)
    tthread=threading.Thread(target=thread_run, args=(conn,), daemon=True)
    tthread.start()

    inthread=threading.Thread(target=input_thread_run, args=(connlist,), daemon=True)
    inthread.start()
