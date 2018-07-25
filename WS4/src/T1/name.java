/**********************************************
 Workshop 4
 Name:Elliot Maude
 ID:032830127

 This assignment represents my own work in accordance with Seneca Academic Policy.
 Date:7/20/18
 **********************************************/
package T1;

public class Name {
    
    String m_name;
    char m_sex;
    int m_rank;    
    int m_year;
    
    public Name()
    {
        m_name = "";
        m_sex = ' ';
        m_rank = -1;
    }
    
    public Name(String name, char sex, int rank, int year)
    {
        m_name = name.trim();
        m_sex = sex;
        m_rank = rank;
        m_year = year;
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