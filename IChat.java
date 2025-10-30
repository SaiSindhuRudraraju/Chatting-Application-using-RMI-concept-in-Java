import java.util.*;
import java.rmi.*;

public interface IChat extends Remote
{
    public List<String> connect(String str, IChatClient chatClient) throws RemoteException;

    public void sendMessage(String clientName, String message) throws RemoteException;
}