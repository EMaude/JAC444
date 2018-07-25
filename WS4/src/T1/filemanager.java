/**********************************************
 Workshop 4
 Name:Elliot Maude
 ID:032830127

 This assignment represents my own work in accordance with Seneca Academic Policy.
 Date:7/20/18
 **********************************************/

public class filemanager{
    
    Path path;
    int m_year; 
    BufferedReader br;
    
    public filemanager(int year)
    {
        m_year = year;
        path = Paths.get("babynamesranking" + m_year + ".txt");
        
        try
        {
            br = new BufferedReader(new FileReader(filename));
        } 
        catch(FileNotFoundException e)
        {
            System.out.println("No data from  " + year + " found");
        }
    }
    
    public void readRecord()
    {
        String in;
        
        try {
			in = br.readLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
        
        entityManager.fromString(in, m_year);
    }
} 