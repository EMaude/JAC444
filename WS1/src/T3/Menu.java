package T3;

import T2.Account;

public class Menu {
	static Account account;
	
	public static void init(Account accounts[])
	{
		System.out.println("Enter a Id: ");
		int id = Input.getInt();
		
		if(id < 10 && id >= 0)
		{
			account = accounts[id];
			menu();
		}
		else
		{
			System.out.println("Account not found");
			init(accounts);
		}
	}
	
	public static void menu()
	{
		System.out.println("");
		System.out.println("Main Menu");
		System.out.println("1: Check Balance");
		System.out.println("2: Withdraw");
		System.out.println("3: Deposit");
		System.out.println("4: Exit");
		
		int select = Input.getInt();
		
		switch(select) 
		{
		case 1:
			bal();
			break;
		case 2:
			withdraw();
			break;
		case 3:
			deposit();
			break;
		case 4:
			Input.close();
			System.exit(0);
			break;
		default:
			System.out.println("Unknown Selection");
			menu();
				break;
		}
	}
	public static void bal()
	{
		System.out.println("The balance is " + account.getBalance());
		menu();
	}
	public static void withdraw()
	{
		System.out.print("Enter amount to withdraw: ");
		double amount = Input.getDouble();
		account.withdraw(amount);
		menu();
	}
	public static void deposit()
	{
		System.out.print("Enter amount to deposit: ");
		double amount = Input.getDouble();
		account.deposit(amount);
		menu();
	}
}
