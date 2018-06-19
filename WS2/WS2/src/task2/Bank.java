package task2;

import java.util.ArrayList;

public class Bank {
	  
	public static double minAssetLimit = 120;
	
	private int id; 
	private double balance;
	private boolean	isSafe; 
	
	//inner class loan
	public class Loan{ 
		private Bank reciver; 
		private double amount; 
		
		public Loan() { 
			reciver = null; 
			amount = 0.0;
		}
		
		public Loan(Bank b, double lamount) { 
			setReciver(b);
			setAmount(lamount);
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public Bank getReciver() {
			return reciver;
		}

		public void setReciver(Bank reciver) {
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
	
	public boolean isSafe() {
		return	isSafe;
	}
	         
	public void checkSafe()
	{  
		double loanedAmount = 0.0; 
		
		for(int i = 0; i < loans.size(); i++) {
			loanedAmount += loans.get(i).amount;
		}
		
		isSafe = (balance + loanedAmount >= minAssetLimit);
	} 
	
	public boolean checkSafeCascade() { 
		checkSafe();
		if(isSafe == true) 
		{ 
			double safeAmount = balance;
			for(int i = 0; i < loans.size(); i++) {
				
				if(loans.get(i).reciver.getId() == this.getId())
				{ 
					return true;
				}
				else if(loans.get(i).reciver.checkSafeCascade()) {
					safeAmount += loans.get(i).amount;
				}
				
			}
			isSafe = safeAmount >= minAssetLimit;
		}
		 
		return isSafe;
	}  
	
	public void newLoan(Bank reciver, double lAmount)
	{
		loans.add(new Loan(reciver, lAmount));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
