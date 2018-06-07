package T4;
import T2.Account;

public class ChequingAccount extends Account{
	
	double overdraft = 100.00;
	
	public ChequingAccount(int initId, double initBalance, double od)
	{
		super(initId, initBalance);
		overdraft = od;
	}
	
	public double getOverdraft()
	{
		return overdraft;
	}
	
	public void setOverdraft(double od)
	{
		overdraft = od;
	}
	
	 public void setBalance(double sBalance)
	 {
		 if(sBalance > 0 - overdraft)
		 {
			 balance = sBalance;
		 }
	 }
	 public void withdraw(double amount)
	 {
		 if((balance -= amount) > 0 - overdraft)
		 {
	       balance -= amount;
		 }
	 }
}
