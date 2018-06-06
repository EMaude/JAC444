package T3;

import T2.Account;

public class Test {

	public static void main(String[] args) {
		
		Account[] accounts = new Account[10];
		
		for(int i = 0; i < 10; i++)
		{
			accounts[i] = new Account(i, 100.00);
		}
		
		Menu.init(accounts);
	}

}
