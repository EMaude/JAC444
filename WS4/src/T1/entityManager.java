/**********************************************
 Workshop 4
 Name:Elliot Maude
 ID:032830127

 This assignment represents my own work in accordance with Seneca Academic Policy.
 Date:7/20/18
 **********************************************/

public class entityManager{
    
    static List<name> mNames = new List<name>();
    static List<name> fNames = new List<name>();
    
    public static void fromString(String in, int year)
    {
        String recs[] = in.split(" ");
        
        int rank = m.getInt(recs[0]);
        
        mNames.add(new name(recs[1], 'M', rank, year));
        fNames.add(new name(recs[3], 'F', rank, year));
    }
    
    public static name Find(String in, Char sex)
    {
       if(sex == 'M' || sex == 'm')
       {
           for(int i = 0; i < mNames.size(); i++)
           {
               if(mNames.get(i).isMatch(in))
               {
                   return mNames.get(i);
               }
           }
           
       } else if (sex == 'F' || sex == 'f')
       {
           for(int i = 0; i < fNames.size(); i++)
           {
               if(fNames.get(i).isMatch(in))
               {
                   return fNames.get(i);
               }
           }
       } else
       {
           return null;
       }
    }
    
    public static void clear()
    {
        names.clear();
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
}