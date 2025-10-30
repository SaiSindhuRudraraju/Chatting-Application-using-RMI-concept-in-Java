import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

class Client
{
    public static void main(String args[])
    {
        try
        {
            IChat ichat;
            ichat = (IChat)Naming.lookup("rmi://localhost:4050/ChatApp");
            chatClient cc = new chatClient();
            IChatClient ichatClient = cc;
            System.out.println("Connected to chat server. Please enter your name:");
            String name = System.console().readLine();
            List<String> clients = ichat.connect(name, ichatClient);
            System.out.println("Currently connected clients:");
            for(int i=0; i<clients.size(); i++)
            {
                System.out.println(clients.get(i));
            }
            String ch;
            do
            {
                System.out.println("Enter message to send 'client name:message':");
                String msg = System.console().readLine();
                String[] message = msg.split(":");
                ichat.sendMessage(message[0], message[1]);
                System.out.println("Do you want to continue? Y/N");
                ch = System.console().readLine();
            }while(ch.equals("Y"));
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}