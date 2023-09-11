import socket
import time
from random import randint


vehicles = ["car"] * 5 + ["suv"] * 7 + ["truck"] * 3 + ["bus", "van", "semi"]

def start_server(host, port):
    try:
        server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        server_socket.bind((host, port))
        server_socket.listen(5)
        print(f"Listening on {host}:{port}...")

        while True:
            client_socket, client_address = server_socket.accept()
            print(f"Accepted connection from {client_address[0]}:{client_address[1]}")

            # while True:
            #     data = client_socket.recv(1024)
            #     if not data:
            #         break
            #     print(f"Received: {data.decode('utf-8')}")
            #     response = input("Enter your response: ")
            #     client_socket.send(response.encode('utf-8'))

            while True:
                # time.sleep(0.05)
                # s = "ABCD\n"
                s = f"{vehicles[randint(0, len(vehicles) - 1)]}\n"
                b = bytearray()
                b.extend(map(ord, s))
                # print(s)
                client_socket.send(b)
                # client_socket.detach()
                # server_socket.send(b)

            print(f"Connection from {client_address[0]}:{client_address[1]} closed")
            client_socket.close()

        # while True:
        #     time.sleep(1)
        #     client_socket, client_address = server_socket.accept()
        #     print(f"Accepted connection from {client_address[0]}:{client_address[1]}")
        #
        #     s = "car"
        #     b = bytearray()
        #     b.extend(map(ord, s))
        #     print(s)
        #     client_socket.send(b)
        #
        #     print(f"Connection from {client_address[0]}:{client_address[1]} closed")
        #     client_socket.close()

    except KeyboardInterrupt:
        print("Server terminated.")
    finally:
        server_socket.close()


if __name__ == "__main__":
    host = "0.0.0.0"  # Listen on all available network interfaces
    #host = "127.0.0.1"  # Listen on all available network interfaces
    port = 9990

    start_server(host, port)

