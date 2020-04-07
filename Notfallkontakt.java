
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
    private String Telefonnummer;
     /**
     *constructor for objects of class Notfallkontakt
     */
    
    public Notfallkontakt(String n, String ad, String bez, String tel)
    {
        this.Name = n;
        this.Adresse = ad;
        this.Beziehung = bez;
        this.Telefonnummer= tel;
    }
    /**
     * Method to edit already existing, or new contact details
     *
     * @param: n
     * @param:ad
     * @param:bez
     * @param:tel
     */
    public void kontaktdatenbearbeiten(String n, String ad, String bez, String tel)
    {
        Name = n;
        Adresse = ad;
        Beziehung = bez;
        Telefonnummer = tel;
    }
    public String getName()
    {
        return Name;
    }
}
