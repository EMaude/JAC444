package task2;

import java.util.ArrayList;

public class Tester { 
	public static void main (String[] args) { 
		ArrayList<Bank> banks = new ArrayList<Bank>();
		
		/*banks.add(new Bank(0, 25));
		banks.add(new Bank(1, 125));
		banks.add(new Bank(2, 175));
		banks.add(new Bank(3, 75));
		banks.add(new Bank(4, 181));
		
		banks.get(0).newLoan(banks.get(1).getId(), 100.5);
		banks.get(0).newLoan(banks.get(4).getId(), 320.5);
		banks.get(1).newLoan(banks.get(2).getId(), 40);
		banks.get(1).newLoan(banks.get(3).getId(), 85);
		banks.get(2).newLoan(banks.get(3).getId(), 75);
		banks.get(2).newLoan(banks.get(0).getId(), 125);
		banks.get(3).newLoan(banks.get(0).getId(), 125);
		banks.get(4).newLoan(banks.get(2).getId(), 125);
		*/
		
		Parser p = new Parser("input.txt");
		
		int numBanks = p.numBanks();
		System.out.println("Number of Banks: " + numBanks);
		
		Bank.setminAssetLimit(p.assetLimit());
		System.out.println("Min Asset Limit: " + Bank.getminAssetLimit());
		System.out.println("");
		
		for(int i = 0; i < numBanks; i++)
		{
			banks.add(p.newBank()); 
			System.out.println("Bank: " + banks.get(i).getId() + " Balance: "  + banks.get(i).getBalance());
			banks.get(i).dspLoans();
		}
		
		ArrayList<Integer> unsafe = new ArrayList<Integer>();
		boolean moreUnsafe;
		
		do { 
			moreUnsafe = false;
			
			for(int i = 0; i < banks.size(); i++)
			{	
				if(!banks.get(i).checkSafe(unsafe))
				{
					if(!unsafe.contains(banks.get(i).getId()))
					{
						unsafe.add(i);
						moreUnsafe = true;
					}
				}
			}
		 }while( moreUnsafe	);
		
		System.out.println("Unsafe Banks are:");
		for(int i = 0; i < unsafe.size(); i++)
		{
			System.out.println(" Bank " + unsafe.get(i).toString());
		}
		
	}
}
