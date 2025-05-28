# JavaLearning
### ✅ Single-threaded Server
- Listens for one client at a time.
- Blocks new connections until the current client disconnects.
- Good for simple communication but not scalable.

### ✅ Multi-threaded Server
- Uses Java threads to handle multiple clients concurrently.
- Each client is managed by a separate `ClientHandler` thread.
- Enables simultaneous communication with multiple clients.
- More efficient and scalable for real-world applications.

