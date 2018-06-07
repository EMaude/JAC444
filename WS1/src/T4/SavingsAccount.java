package T4;

import T2.Account;

public class SavingsAccount extends Account{
	
	public SavingsAccount(int initId, double initBalance)
	{
		if(initBalance < 0)
		{
			initBalance = 0;
		}
		setBalance(initBalance);
		setId(initId);
	}
	 public void setBalance(double sBalance)
	 {
		 if(sBalance > 0)
		 {
			 balance = sBalance;
		 }
	 }
	 public void withdraw(double amount)
	 {
		 if((balance -= amount) > 0)
		 {
	       balance -= amount;
		 }
	 }
}