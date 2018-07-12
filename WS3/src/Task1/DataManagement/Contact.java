package Task1.DataManagement;

public class Contact {

    private String m_name;
    private String m_street;
    private String m_city;
    private String m_state;
    private String m_zip;

    public Contact() {
        String m_name = "";
        String m_street = "";
        String m_city = "";
        String m_state = "";
        String m_zip = "";
    }

    public Contact(String str) { //String should be in format that toString lays out
        String[] strings = str.split("\\|");
        if(strings.length < 5) {
            System.out.println("Error reading string, not enough records");
        } else {
            m_name = strings[0];
            m_street = strings[1];
            m_city = strings[2];
            m_state = strings[3];
            m_zip = strings[4];
        }
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String name) {
        m_name = ParseString(name, 32);
    }

    public String getM_street() {
        return m_street;
    }

    public void setM_street(String street) {
        m_street = ParseString(street, 32);
    }

    public String getM_city() {
        return m_city;
    }

    public void setM_city(String city) {
        m_city = ParseString(city, 20);
    }

    public String getM_state() {
        return m_state;
    }

    public void setM_state(String state) {
        m_state = ParseString(state, 2);
    }

    public String getM_zip() {
        return m_zip;
    }

    public void setM_zip(String zip) {
        m_zip = ParseString(zip, 5);
    }


    public void display()
    {
        System.out.println("Name: " + m_name);
        System.out.println("Street: " + m_street);
        System.out.println("City: " + m_city);
        System.out.println("State: " + m_state);
        System.out.println("Zip: " + m_zip);
    }

    public String toString() {
        return m_name + "|" + m_street + "|" + m_city + "|" + m_state + "|" + m_zip + "|";
    }

    private String ParseString(String text, int length) {
        return String.format("%-" + length + "." + length + "s", text);
    }
}
