package task1;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Game {
	static String word;
	static String foundChars;
	static String unique;
	static int numMisses;
	
	public static void fromFile()
	{
		ArrayList<String> inList = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("hangman.txt"));
			String tin = null;
			
			while((tin = br.readLine()) != null)
			{
				String[] tmp = tin.split(" ");
				for(int i = 0; i < tmp.length; i++)
				{
					inList.add(tmp[i].trim());
				}
			}
			
			br.close();
		} catch (IOException e) {
			System.out.println("Could not find hangman.txt file");
			Input.clear();
			Menu.drawMenu();
		}
		//pick a random word
		int choice = (int)(Math.random() * inList.size());
		word = inList.get(choice);
		setup();
	}
	
	public static void random()
	{
		///gets a random word from this list
		String words[] = {"program", "java", "compile", "runtime", "virtual", "static", "function", "hangman"};
		int randChoice = (int) (Math.random() * words.length);
		
		word = words[randChoice];
		
		setup();
	}
	
	public static void setup()
	{
		//gets unique chars in the word
		unique = "";
		for (int i = 0; i < word.length(); i++)
		{
	         if(unique.indexOf(word.charAt(i)) == -1 )
	         {
	        	 unique = unique + word.charAt(i);
	         }
	    }
		
		//inits some variables
		
		foundChars = "";
		numMisses = 0;
		
		gameLoop();
	}
	
	public static void gameLoop()
	{
		//main game loop
		//prints word and prompts for guess
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
		
		//checks if guess is in word
		if(word.indexOf(guess) != -1)
		{	
			//checks if guess has already been guessed
			if(foundChars.indexOf(guess) != -1)
			{
				System.out.println( guess + " Already exists in word");
			}
			else
			{
				foundChars += guess;
			}
		}
		else
		{
			numMisses++;
		}
		
		//checks if all chars have been found
		if(foundChars.length() == unique.length())
		{
			System.out.println("");
			System.out.println("The word is " + word);
			System.out.println("You had " + numMisses + " misses");
			
			System.out.println("Play Again? (Y/N)");
			
			//check if the player wants to play again
			boolean again = false;
			
			while(!again)
			{
				char in = Input.getChar();
				
				if(in == 'y' || in =='Y')
				{
					again = true;
					random();
				}
				else if(in  == 'n' || in == 'N')
				{
					again = true;
					Input.clear();
					Menu.drawMenu();
				}	
			}	
		}
		else
		{
			gameLoop();
		}
	}
}