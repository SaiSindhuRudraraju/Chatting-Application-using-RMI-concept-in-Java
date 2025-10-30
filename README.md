# Chat Application Using Java RMI

This is a simple console-based chat application built using **Java RMI (Remote Method Invocation)**.  
It allows multiple clients to connect to a central server and send messages to other connected clients.

---

## 📌 What is RMI?

**Java RMI** allows one Java program to invoke methods of an object running on another **JVM** (possibly on another machine). This helps in building **distributed applications**.

### How RMI Works:
1. A **Remote Interface** defines the methods that can be called remotely.
2. A **Server** creates and registers an implementation of that interface in the **RMI Registry**.
3. A **Client** looks up the remote object from the registry and invokes its methods as if it were local.

---

## 🏗️ Project Overview

### Remote Interfaces
| Interface | Purpose |
|----------|---------|
| `IChat` | Allows clients to connect and send messages. |
| `IChatClient` | Allows server to deliver messages and notify when a new client joins. |

### Main Classes
| Class | Role |
|------|------|
| `Chat` | Server-side implementation of `IChat`, stores client references and sends messages. |
| `chatClient` | Client-side implementation of `IChatClient`, displays received messages. |
| `Server` | Launches the RMI server and registers the `Chat` object. |
| `Client` | Connects to server, sends and receives chat messages. |

---

## 🛠️ How to Run

### 1 Start RMI Registry
Open a terminal in your project folder and run:
rmiregistry 4050
### 2 Compile All files
javac *.java
### 3 Start the Server
java Server
### 4 Start multiple clients and assign name
java Client

### 5 try sending messages like:
client name:message
Example: client1:Hello
