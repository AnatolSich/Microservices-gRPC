# Guides
To test the User service:
1. Use the https://appimage.github.io/BloomRPC/  (GUI Client for GRPC Services)
2. Start UserServer
3. Add user.proto to BloomRPC and set localhost:50051
4. Fire userRequests to server

To test the Order service:
1. Use the https://appimage.github.io/BloomRPC/  (GUI Client for GRPC Services)
2. Start OrderServer
3. Add order.proto to BloomRPC and set localhost:50052
4. Fire orderRequests to server

To test the both services work:

![Alt text](screen/Both_services.jpg?raw=true "Optional Title")

1. Use the https://appimage.github.io/BloomRPC/  (GUI Client for GRPC Services)
2. Start OrderServer and UserServer
3. Update user.proto in BloomRPC
4. Fire userRequests to server
