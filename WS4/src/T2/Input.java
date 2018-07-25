/**********************************************
 Workshop 4
 Name:Elliot Maude
 ID:032830127

 This assignment represents my own work in accordance with Seneca Academic Policy.
 Date:7/20/18
 **********************************************/

package T2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Used to get data from System.in
 */
public class Input {
	static Scanner input = new Scanner(System.in);

    /**
     * reads the input line and uses regex to pull out a double. Which is then cast to a int.
     * @return first integer in input
     */
	public static int getInt()
	{
		String in = input.nextLine();
		
		Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(in);
		
		if(m.find())
		{
			return (int)Double.parseDouble(m.group(1));
		}else {
			return -1;
		}
	}

    /**
     * reads the input line and uses regex to pull out a double.
     * @return first double in input
     */
	public static double getDouble()
	{
		String in = input.nextLine();
	
		Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(in);
		
		if(m.find()) 
		{
			return Double.parseDouble(m.group(1));
		}
		else
		{
			return -1;
		}
	}

    /**
     * reads the input line, trims whitespace and pulls the first character
     * @return first Char in input
     */
	public static char getChar()
	{
		return input.next().trim().charAt(0);
	}

    /**
     * flushes input buffer
     */
	public static void clear()
	{
		input.nextLine();
	}

    /**
     * closes input connection, not used in the current static implementation
     */
	public static void close()
	{
		input.close();
	}
}
