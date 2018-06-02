package Task1;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of rows and cols: ");
	
		String rowCol = input.nextLine();
		Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(rowCol); //This finds doubles, whole numbers (with and without a decimal point), and fractions (a leading decimal point)
		
		int rows = 0;
		int cols = 0;
		
		if(m.find())
		{
			rows = Integer.parseInt(m.group(1));
		}
		
		if(m.find())
		{
			cols = Integer.parseInt(m.group(1));
		}

		System.out.println("Rows: " + rows + "\nCols: " + cols);
		
		
		System.out.println("Enter the array: ");
		double[][] arr = new double[rows][cols];

		for(int i = 0; i < arr.length; i++)
		{
			String line = input.nextLine();
			Matcher l = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(line);
			
			int count = 0;
			while(l.find() && count < arr[i].length)
			{
				arr[i][count] = Double.parseDouble(l.group(1));
				count++;
			}
		}
		
		Location loc = Location.locateLargest(arr);
		System.out.println("The largest element is " + loc.maxVal + " and is at " + loc.row + " : " + loc.col);
		
		input.close();
	}
}
