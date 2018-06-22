package task2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	
	public String filename;
	BufferedReader br;
	
	
	public Parser(String fname)
	{
		filename = fname;
		
		try {
			br = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			System.out.println(filename + " Not found");
		}
	}
	
	public int numBanks()
	{
		String in = null;
		try {
			in = br.readLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return getInt(in);
		
	}
	 
	public double assetLimit()
	{
		String in = null;
		try {
			in = br.readLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return getDouble(in);
	}
	
	public Bank newBank()
	{
		String in = null;
		try {
			in = br.readLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		int id = getInt(in);
		
		String[] s = in.split(":");
		
		int i = 1;
		while( getDouble(s[i]) == -1)
		{
			i++;
		}
		
		double bal = getDouble(s[i]);
		i++;
		Bank b = new Bank(id, bal);
		
		while( getInt(s[i]) == -1)
		{
			i++;
		}
		
		int numLoans = getInt(s[i]);
		i++;

		for(int j = 0; j < numLoans; j++) 
		{
			while( getInt(s[i]) == -1)
			{
				i++;
			}
			
			int bId = getInt(s[i]);
			i++;
			
			while( getDouble(s[i]) == -1)
			{
				i++;
			}
			
			double amt = getDouble(s[i]);
			i++;
			
			b.newLoan(bId, amt);
		}
		
		return b;
	}
	
	public void close()
	{
		try {
			br.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public int getInt(String in)
	{
		Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(in);
		
		if(m.find())
		{
			return (int)Double.parseDouble(m.group(1));
		}else {
			return -1;
		}
	}
	
	public double getDouble(String in)
	{
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
}
