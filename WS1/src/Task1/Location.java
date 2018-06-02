package Task1;

public class Location {

	int row;
	int col;
	double maxVal;
	
	public static Location locateLargest(double	[][] a)
	{
		Location loc = new Location();
		
		for(int row = 0; row < a.length; row++)
		{
			for(int col = 0; col < a[row].length; col++)
			{
				if(a[row][col] > loc.maxVal)
				{
					loc.maxVal = a[row][col];
					loc.col = col;
					loc.row = row;
				}
			}
		}
		
		return loc;
	}
}
