package task1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
	static Scanner input = new Scanner(System.in);
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
	public static double getDouble()
	{
		String in = null;
		in = input.nextLine();
	
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
	
	public static char getChar()
	{
		return input.next().trim().charAt(0);
	}
	
	public static void clear()
	{
		input.nextLine();
	}
	
	public static void close()
	{
		input.close();
	}
}
