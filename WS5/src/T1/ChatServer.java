/**********************************************
 Workshop 5
 Name:Elliot Maude
 ID:032830127

 This assignment represents my own work in accordance with Seneca Academic Policy.
 Date:7/20/18
 **********************************************/
package T1;

import java.util.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
 
public class ChatServer {
    public static void main (String[] argv) {
        try {
            Scanner s = new Scanner(System.in);
            Chat server = new Chat("SERVER");

            Registry registry =	LocateRegistry.createRegistry(2020);
            registry.rebind("Chat", server);

            System.out.println("[System] Chat Remote Object is ready: " + new java.util.Date());

            while(true){
                String msg = s.nextLine().trim();

                if (!server.getClient().isEmpty()){

                    ArrayList<ChatInterface> client = server.getClient();
                    msg= "[" + server.getName() + "] " + msg;

                    for(int i = 0; i < client.size(); i++) {
                        client.get(i).write(msg);
                    }
                }
            }
        }catch (Exception e) {
            System.out.println("[System] Server failed: " + e);
        }
    }
}
