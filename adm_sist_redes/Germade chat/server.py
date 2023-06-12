
import socket
import threading

# AF_INET = IPv4
# SOCK_STREAM = TCP
sock=socket.socket(family=socket.AF_INET, type=socket.SOCK_STREAM)
# 127.0.0.1 para que solo sea accesible localmente
sock.bind(('0.0.0.0', 8080))
sock.listen()
#sock.setblocking(False)
conn,addr=sock.accept()
print(sock.recv(1024))
