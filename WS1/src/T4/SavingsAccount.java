package T4;

import T2.Account;

public class SavingsAccount extends Account{
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