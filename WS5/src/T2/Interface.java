/**********************************************
 Workshop 5
 Name:Elliot Maude
 ID:032830127

 This assignment represents my own work in accordance with Seneca Academic Policy.
 Date:7/20/18
 **********************************************/
package T2;

import java.rmi.*;

public interface Interface extends Remote{
    String calcBMI() throws RemoteException;
    void setHeight(double h) throws RemoteException;
    void setWeight(double w) throws RemoteException;
    void connect() throws RemoteException;
}
