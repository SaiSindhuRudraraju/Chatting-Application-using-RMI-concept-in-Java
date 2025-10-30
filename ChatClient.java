import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

class chatClient extends UnicastRemoteObject implements IChatClient
{
    public chatClient() throws RemoteException
    {
        super();
    }

    public void deliverMessage(String message)
    {
        System.out.println("Message received: " + message);
    }

    public void newClientJoined(String clientName)
    {
        System.out.println("New client joined: " + clientName);
    }
}