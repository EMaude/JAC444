/**********************************************
 Workshop 4
 Name:Elliot Maude
 ID:032830127

 This assignment represents my own work in accordance with Seneca Academic Policy.
 Date:7/20/18
 **********************************************/
package T1;
public class Lookup
{
    public static void main(String[] args)
    {
        int year;
        int prevYear = -1;
        FileManager fm = null;

        do {
            do {
                do {
                    System.out.println("Enter the year:(2001 - 2010) ");
                    year = Input.getInt();
                } while (year == -1);

                if (year != prevYear) {
                    fm = new FileManager(year);
                }
                //Create a file manager

            } while (!fm.good());


            if (year != prevYear) {
                EntityManager.clear();
                //read all records and send to the entity manager
                String rec;
                while ((rec = fm.readRecord()) != null) {
                    EntityManager.fromString(rec, year);
                }
            }

            check();
            prevYear = year;
        }while(again());

    }

    public static void check()
    {
        Name result;

            char sex;
            String name;

            do {
                System.out.println("Enter the Sex: ");
                sex = Input.getChar();
                Input.clear();
            }while(sex != 'M' && sex != 'm' && sex != 'F' && sex != 'f');

            System.out.println("Enter the name: ");
            name = Input.getString();

            result = EntityManager.find(name, sex);

            if(result != null) {
                result.display();
            }
    }

    public static boolean again()
    {
        System.out.println("Another query?(y/n) ");
        char choice = Input.getChar();
        Input.clear();

        if(choice == 'Y' || choice == 'y')
        {
            return true;
        }
        else if(choice == 'N' || choice == 'n')
        {
            return false;
        }
        else {
            return again();
        }
    }
}