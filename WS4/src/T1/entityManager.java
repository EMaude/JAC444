/**********************************************
 Workshop 4
 Name:Elliot Maude
 ID:032830127

 This assignment represents my own work in accordance with Seneca Academic Policy.
 Date:7/20/18
 **********************************************/
package T1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntityManager {
    
    static ArrayList<Name> mNames = new ArrayList<Name>();
    static ArrayList<Name> fNames = new ArrayList<Name>();
    
    public static void fromString(String in, int year)
    {
        String recs[] = in.split(" ");
        
        int rank = getInt(recs[0]);

        String mName = recs[1].split("\t")[1];
        String fName = recs[2];

        mNames.add(new Name(mName, 'M', rank, year));
        fNames.add(new Name(fName, 'F', rank, year));

    }


    public static Name find(String in, char sex)
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
       }

       System.out.println("No record found for " + in + " sex: " + sex);
       return null;
    }
    
    public static void clear()
    {
        mNames.clear();
        fNames.clear();
    }
    
    public static int getInt(String in)
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