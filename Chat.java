import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

class Chat implements IChat
{
    private Hashtable<String, IChatClient> clients;
    List<String> clientNames;

    public Chat()
    {
        clients = new Hashtable<String, IChatClient>();
    }

    public List<String> connect(String name, IChatClient chatClient)
    {
        Hashtable ht1 = clients;
        clients.put(name, chatClient);
        Enumeration<String> e = ht1.keys();
        int i = 0;
        clientNames = new ArrayList<String>();
        while(e.hasMoreElements())
        {
            String clientName = e.nextElement();
            IChatClient cc = (IChatClient)ht1.get(clientName);
            try
            {
                cc.newClientJoined(name);
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
            clientNames.add(i, clientName);
            i++;
        }
        return clientNames;
    }

    public void sendMessage(String clientName, String message)
    {
        if(clients.containsKey(clientName))
        {
            try
            {
                ((IChatClient)clients.get(clientName)).deliverMessage(message);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
}