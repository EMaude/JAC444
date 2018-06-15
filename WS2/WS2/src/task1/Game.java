package task1;

public class Game {
	static String word;
	static String foundChars;
	static String unique;
	static int numMisses;
	public static void fromFile()
	{
		System.out.println("Not Implemented ... Calling random");
		random();
	}
	
	public static void random()
	{
		word = "program";
		unique = "";
		for (int i = 0; i < word.length(); i++)
		{
	         if(unique.indexOf(word.charAt(i)) == -1 )
	         {
	        	 unique = unique + word.charAt(i);
	         }
	    }
		
		foundChars = "";
		numMisses = 0;
		gameLoop();
	}
	
	public static void gameLoop()
	{
		System.out.print("Enter a letter for the word [");
		
		for(int i = 0; i < word.length(); i++)
		{
			if(foundChars.indexOf(word.charAt(i)) != -1)
			{
				System.out.print(word.charAt(i));
			}
			else
			{
				System.out.print('*');	
			}
		}
		
		System.out.println("]: ");
		
		char guess = Input.getChar();
		
		if(word.indexOf(guess) != -1)
		{	
			foundChars += guess;
		}
		else
		{
			numMisses++;
		}
		
		
		if(foundChars.length() == unique.length())
		{
			Menu.drawMenu();
		}
		else
		{
			gameLoop();
		}
	}
}