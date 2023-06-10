
import socket


sock=socket.socket(family=AF_INET, type=SOCK_STREAM)
sick.bind('127.0.0.1', 8080)
sock.listen()
print(sock.accept())
