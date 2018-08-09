/**********************************************
 Workshop 5
 Name:Elliot Maude
 ID:032830127

 This assignment represents my own work in accordance with Seneca Academic Policy.
 Date:7/20/18
 **********************************************/
package T2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main (String[] argv) {

        try {
            BMI server = new BMI();

            Registry registry =	LocateRegistry.createRegistry(2020);
            registry.rebind("BMI", server);

            System.out.println("[System] BMI Server is ready: " + new java.util.Date());

        } catch (Exception e) {
            System.out.println("[System] Server failed: " + e);
        }
    }
}
