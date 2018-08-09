/**********************************************
 Workshop 5
 Name:Elliot Maude
 ID:032830127

 This assignment represents my own work in accordance with Seneca Academic Policy.
 Date:7/20/18
 **********************************************/
package T1;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;

public class Chat extends UnicastRemoteObject implements ChatInterface {
 
	public String name;
	static public ArrayList<ChatInterface> client = new ArrayList<>();

	public Chat(String n)  throws RemoteException { 
		this.name=n;   
	}
	public String getName() {
		return this.name;
	}
 	
	public void setClient(ChatInterface c){
		client.add(c);
	}
 
	public ArrayList<ChatInterface> getClient(){
		return client;
	}

	//send to all clients but the current one
	public void send(String s, ChatInterface c) {
        System.out.println(s);
        try {
            for (int i = 0; i < client.size(); i++) {
                if(!client.get(i).getName().equals(c.getName())){
                    client.get(i).write(s);
                }
            }
        }catch(Exception e)
        {
            System.out.println("[SYSTEM] Error: " + e);
        }
	}
	//write message to client
	public void write(String s)
    {
        System.out.println(s);
    }
}
