import socket
import threading

def thread_run(sock):
    while True:
        print(sock.recv(1024))

sock=socket.socket(family=socket.AF_INET, type=socket.SOCK_STREAM)
sock.connect(('127.0.0.1', 8080))
while True:
    sock.sendall(bytes(input(), "utf-8"))
#print(sock.recv(1024))

#https://realpython.com/python-sockets/#echo-client
#https://docs.python.org/3/library/threading.html
#https://docs.python.org/3/library/socket.html
#https://paulbutler.org/2022/what-does-it-mean-to-listen-on-a-port/
