package task2;

import java.util.ArrayList;

public class Tester { 
	public static void main (String[] args) { 
		ArrayList<Bank> banks = new ArrayList<Bank>();
		
		banks.add(new Bank(0, 25));
		banks.add(new Bank(1, 125));
		banks.add(new Bank(2, 75));
		banks.add(new Bank(3, 175));
		banks.add(new Bank(4, 181));
		
		banks.get(0).newLoan(banks.get(1), 100.5);
		banks.get(0).newLoan(banks.get(4), 320.5);
		banks.get(1).newLoan(banks.get(2), 40);
		banks.get(1).newLoan(banks.get(3), 85);
		banks.get(2).newLoan(banks.get(3), 75);
		banks.get(2).newLoan(banks.get(0), 125);
		banks.get(3).newLoan(banks.get(0), 125);
		banks.get(4).newLoan(banks.get(2), 125);
		
		
		for(int i = 0; i < banks.size(); i++)
		{ 
			if(!banks.get(i).checkSafeCascade()) { 
				System.out.println("Bank " + banks.get(i).getId() + " is unsafe");
			}
		}
	}
}
