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
 
public class ChatClient {
	public static void main (String[] argv) {
	    try {

			Scanner s=new Scanner(System.in);
            String name;
			do {
                System.out.print("Enter your name: ");
                name = s.nextLine();
            }while(name == null);

			ChatInterface client = new Chat(name);

			Registry registry = 	LocateRegistry.getRegistry(2020);
			ChatInterface server = 	(ChatInterface)registry.lookup("Chat");

			String msg="["+client.getName()+"] got connected at " + new java.util.Date();
			server.send(msg, client);

			System.out.println("[System] Chat Remote Object is ready:");
			server.setClient(client);

			while(true){
			    msg=s.nextLine().trim();
			    msg = "[" + client.getName() + "] " + msg;
			    server.send(msg, client);
			}

	    }catch (Exception e) {
	    		System.out.println("[System] Server failed: " + e);
    	}
	}
}

