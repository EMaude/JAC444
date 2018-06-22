package task2;

import java.util.ArrayList;

public class Bank {
	  
	private static double minAssetLimit = 201.00;
	
	private int id; 
	private double balance;
	//inner class loan
	public class Loan{ 
		private int reciver; 
		private double amount; 
		
		public Loan() { 
			reciver = -1; 
			amount = 0.0;
		}
		
		public Loan(int b, double lamount) { 
			setReciver(b);
			setAmount(lamount);
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public int getReciver() {
			return reciver;
		}

		public void setReciver(int reciver) {
			this.reciver = reciver;
		}
	} 
	
	
	private ArrayList<Loan> loans = new ArrayList<Loan>();
	
	public Bank() { 
		setId(0); 
		balance = 0.0;
	}
	
	public Bank(int iid, double ibalance) { 
		setId(iid); 
		balance = ibalance;
	}
	
	
	public boolean checkSafe(ArrayList<Integer> unsafeBanks) 
	{
		double loanedAmount = 0.0;
		
		for(int i = 0; i < loans.size(); i++)
		{
			if(!unsafeBanks.contains(loans.get(i).getReciver()))
			{
				loanedAmount += loans.get(i).amount;
			}
		}
		return balance + loanedAmount >= minAssetLimit;
	}
	
	public void newLoan(int reciver, double lAmount)
	{
		loans.add(new Loan(reciver, lAmount));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static void setminAssetLimit(double i)
	{
		minAssetLimit = i;
	}
	
	public static double getminAssetLimit()
	{ 
		return minAssetLimit;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void dspLoans()
	{
		System.out.println("Loans: ");
		for(int i = 0; i < loans.size(); i++)
		{
			System.out.println("	Bank: " + loans.get(i).reciver + " Amount: " + loans.get(i).amount);
		}
		System.out.println("");
	}
}
