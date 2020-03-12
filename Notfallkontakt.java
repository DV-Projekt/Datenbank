
/**
 * Class Notfallkontakt for emergencies with individual patients 
 *
 * @Asma Azan
 * @version 1, 10th March, 2020
 */
public class Notfallkontakt
{
    //Attributes of the class Notfallkontak
    private String Name;
    private String Adresse;
    private String Beziehung;
    private int Telefonnummer;

    /**
     * Standard constructor for objects of class Notfallkontakt
     */
    public Notfallkontakt()
    {
        // Setting attributes to zero
        this.Name = "";
        this.Adresse = "";
        this.Beziehung = "";
        this.Telefonnummer= 0;
    }

    /**
     * Set method for name of emergency contact
     * @param: n
     */
    public void setname(String n)
    {
        // put your code here
        Name = n;
    }

    /**
     * Set method for adress of emergency contact
     * @param: ad
     */
    public void setAdresse(String ad)
    {
        Adresse = ad;
    }

    /**
     * Set method for relation to emergency contact
     * @param: bez
     */
    public void setBeziehung(String bez)
    {
        Beziehung = bez;
    }

    /**
     * Set methods for telephone number of the emergency contacts 
     * @param: tel
     */
    public void setTelefonnummer(int tel)
    {
        Telefonnummer = tel;
    }

    /**
     * Method to edit already existing, or new contact details
     *
     * @param: n
     * @param:ad
     * @param:bez
     * @param:tel
     */
    public void kontaktdatenbearbeiten(String n, String ad, String bez, int tel)
    {
        Name = n;
        Adresse = ad;
        Beziehung = bez;
        Telefonnummer = tel;
    }

}
