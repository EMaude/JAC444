package task1;

public class Menu {
	public static void drawMenu()
	{
		System.out.println("Hangman Game");
		System.out.println("Press 1 to run game with random word");
		System.out.println("Press 2 to run game from text file");
		System.out.println("Press 0 to run Exit");
		System.out.println("Choice: ");
		int choice = Input.getInt();
		
		switch(choice) {
		case 0:
			System.exit(1);
			break;
		case 1:
			Game.random();
			break;
		case 2:
			Game.fromFile();
			break;
		default:
			System.out.println("Invalid");
			drawMenu();
			break;	
		}
	}
}
