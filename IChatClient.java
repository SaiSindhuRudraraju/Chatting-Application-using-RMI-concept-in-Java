import java.rmi.*;
import java.util.*;

public interface IChatClient extends Remote
{
    public void deliverMessage(String message) throws RemoteException;

    public void newClientJoined(String clientName) throws RemoteException;
}