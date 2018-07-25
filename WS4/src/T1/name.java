/**********************************************
 Workshop 4
 Name:Elliot Maude
 ID:032830127

 This assignment represents my own work in accordance with Seneca Academic Policy.
 Date:7/20/18
 **********************************************/

public class name{
    
    String m_name;
    Char m_sex;
    int m_rank;    
    int m_year;
    
    public name()
    {
        m_name = "";
        m_sex = '';
        m_rank = -1;
    }
    
    public name(String name, Char sex; int rank, int m_year)
    {
        m_name = name;
        m_sex = sex;
        m_rank = rank;
    }
    
    public void display()
    {
        System.out.println(m_sex + " Name " + m_name + " is ranked " + m_rank + " in year " + m_year);
    }
    
    public boolean isMatch(String name)
    {
        return m_name.equalsIgnoreCase(name);
    }
}