/**********************************************
 Workshop 5
 Name:Elliot Maude
 ID:032830127

 This assignment represents my own work in accordance with Seneca Academic Policy.
 Date:7/20/18
 **********************************************/
package T1;

import java.rmi.*;
import java.util.ArrayList;

public interface ChatInterface extends Remote{
	
	String getName() throws RemoteException;
	void send(String msg, ChatInterface client) throws	RemoteException;
	void setClient(ChatInterface c)throws RemoteException;
	ArrayList<ChatInterface> getClient() throws RemoteException;
    void write(String s)throws RemoteException;
}
