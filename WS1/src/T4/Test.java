package T4;

public class Test {
	public static void main(String[] args)
	{
		ChequingAccount CA = new ChequingAccount(1, 100.00, 50.00);
		SavingsAccount SA = new SavingsAccount(1, 100.00);
	
		System.out.println(CA.toString());
		System.out.println(SA.toString());
	}
}
