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

public class Client {
    public static void main (String[] argv) {
        try {

            Interface client = new BMI();

            Registry registry = 	LocateRegistry.getRegistry(2020);
            Interface server = 	(Interface)registry.lookup("BMI");

            server.connect();
            do
            {
                double height = 0.0;
                do {
                    System.out.println("Enter Height in meters: ");
                    height = Input.getDouble();
                }while( height <= 0.0);

                server.setHeight(height);

                double weight = 0.0;
                do {
                    System.out.println("Enter Weight in kilos: ");
                    weight = Input.getDouble();
                }while( weight <= 0.0);

                server.setWeight(weight);

                System.out.println("Waiting for BMI from server ...");
                System.out.println(server.calcBMI());


            }while(again());

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean again()
    {
        System.out.println("Again?(y/n) ");
        char choice = Input.getChar();
        Input.clear();

        if(choice == 'Y' || choice == 'y')
        {
            return true;
        }
        else if(choice == 'N' || choice == 'n')
        {
            return false;
        }
        else {
            return again();
        }
    }
}
