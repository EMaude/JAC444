/**********************************************
 Workshop 5
 Name:Elliot Maude
 ID:032830127

 This assignment represents my own work in accordance with Seneca Academic Policy.
 Date:7/20/18
 **********************************************/
package T2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BMI extends UnicastRemoteObject implements Interface {

    double height;
    double weight;

    public BMI() throws RemoteException{

    }

    public void setHeight(double h){
        this.height = h;
        System.out.println("Height is: " + this.height);
    }

    public void setWeight(double w) {
        this.weight = w;
        System.out.println("Weight is: " + this.weight);
    }

    public String calcBMI(){
        System.out.println("Calculating BMI…");
        String output;

        double bmi = weight / (height * height);

        if(bmi < 18.5) {
            output = "Underweight";
        } else if( bmi < 25) {
            output = "Normal";
        } else if(bmi < 30) {
            output = "Overweight";
        } else {
            output = "Obese";
        }

       return output;
    }

    public void connect(){
        System.out.println("Connected to a client at " + new java.util.Date());
        System.out.println("Waiting for height and weight from client: ");
    }
}
