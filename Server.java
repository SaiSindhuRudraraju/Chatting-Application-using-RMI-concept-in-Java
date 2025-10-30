import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;

class Server
{
    public static void main(String args[])
    {
        try
        {
            Chat chat = new Chat();
            IChat stub = (IChat)UnicastRemoteObject.exportObject(chat,0);
            Naming.rebind("rmi://localhost:4050/ChatApp", stub);
            System.out.println("Chat Server is ready. Object Registered in rmi registry.");
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}