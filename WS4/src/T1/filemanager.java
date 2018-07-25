package T1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**********************************************
 Workshop 4
 Name:Elliot Maude
 ID:032830127

 This assignment represents my own work in accordance with Seneca Academic Policy.
 Date:7/20/18
 **********************************************/

public class FileManager {
    
    Path path;
    int m_year; 
    BufferedReader br;
    
    public FileManager(int year)
    {
        m_year = year;
        path = Paths.get("data/babynamesranking" + m_year + ".txt");
        
        try
        {
            br = new BufferedReader(new FileReader(path.toFile()));
        } 
        catch(FileNotFoundException e)
        {
            br = null;
            System.out.println("No data from  " + year + " found");
        }
    }

    public boolean good()
    {
        return br != null;
    }

    public String readRecord()
    {
        String in = null;
        
        try {
			in = br.readLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return in;
    }
} 