

/**
 * Class Notfallkontakt to contact emergency contact in case of urgency 
 * The sole purpose of this class is to save and edit data of an emergency contact that 
 * can be contacted if neccessary
 *
 * @Asma Azan
 * @version 1, 10th March,2020
 * 
 * @version 2, 9th April, 2020
 * @version 3, 13th April, 2020
 * @version 4, 16th April.2020
 */
public class Notfallkontakt
{
  
    //Attributes of the class Notfallkontakt
    private String Name;
    private String Adresse;
    private String Beziehung;
    private String telefonnummer;
    private String Blutgrupp;
    
     
/**
 * standard constructor for objects of class Notfallkontakt
 */
     public Notfallkontakt()
{       //standard constructor
        Name = "Max Mustermann";
        Adresse = "Musterstraße 20";
        Beziehung= "bruder";
        telefonnummer= "07720 1234567";
        Blutgrupp = "A-";
    } 
  
    
/**
     *constructor for objects of class Notfallkontakt
     *@param: n-Name of emergency contact
     *@param: ad-Adresse of emergency contact  
     *@param: bez-Beziehung; how is this emergency contact related to the patient?
     *@param: tel-Telefonnummer of emergency contact
     *@param: bg-Blutgruppe; Blood type of emergency contact
     */
    
    public Notfallkontakt(String n, String ad, String bez, String tel,String bg)
    {
        this.Name = n;
        this.Adresse = ad;
        this.Beziehung = bez;
        this.telefonnummer= tel;
        this.Blutgrupp= bg;
    }
   


/**
   * Set method to set adress of emergency contact
   * @param: ad- Adress of the emergency contact
   */
  public void setadresse(String ad)
    {
        this.Adresse= ad;
    }
    
    
    /**
     *  set Method to set name of emergency contact
     *  @param: n-Name of emergency contact
     */
public void setname(String n)
    {
        this.Name = n;
   } 

/**
     * Method to edit already existing, or new contact details
     *
     * @param: n-Name
     * @param:ad-Adresse
     * @param:bez-Beziehung
     * @param:tel-Telefonnummer
     */
    public void kontaktdatenbearbeiten(String ad, String bez, String tel, String b)
    {
        Adresse = ad;
        Beziehung = bez;
        telefonnummer = tel;
        Blutgrupp = b;
    }
   
  /**
   * Set method to set relation of emergency contact to patient
   * @param: bez-Beziehungen
   * @return: a(String)- variable
   */

  
public String setbeziehung(String bez)
    {
        String a = "Bitte gültige Beziehung eingbeben";
    if( 
        bez.equals("schwester")|bez.equals("Schwester")|bez.equals("bruder")| bez.equals("Bruder")
        |bez.equals("mutter")|bez.equals("Mutter")|bez.equals("Vater")| bez.equals("vater")
        |bez.equals("grossmutter")|bez.equals("Grossmutter")|bez.equals("grossvater")| bez.equals("Grossvater")
        |bez.equals("oma")|bez.equals("Oma")|bez.equals("Opa")| bez.equals("Opa")
        |bez.equals("cousin")|bez.equals("Cousin")|bez.equals("Cousine")| bez.equals("cousine")
        |bez.equals("schwager")|bez.equals("Schwager")|bez.equals("Schwaegerin")| bez.equals("schwaegerin")
        |bez.equals("tante")|bez.equals("Tante")|bez.equals("Onkel")| bez.equals("onkel")
        |bez.equals("schwiegermutter")|bez.equals("Schwiegermutter")|bez.equals("schwiegervater")| bez.equals("Schwiegervater")
        |bez.equals("freund")|bez.equals("Freund")|bez.equals("Freundin")| bez.equals("freundin")
        |bez.equals("Ehemann")|bez.equals("Ehefrau")|bez.equals("ehemann")|bez.equals("ehefrau")|bez.equals("nachbar")
        |bez.equals("Nachbar")|bez.equals("Nachbarin")|bez.equals("nachbarin"))
    try
    {
        Beziehung = bez;
    }
   
    catch(Exception e)
    {
           return a;
    }   
    return null;
    }  
 
    /**
     * Set method to set blood type of emergency contact
     * @param: bg-Blutgruppe of the person
     * @return: a(String)
     */


  public String setblutgruppe(String bg)
  {
     String a = "Bitte gültige Blutgruppe eingeben!";
      
    if(bg.equals("O+")|bg.equals("O-")|bg.equals("A+")|bg.equals("A-")|bg.equals("B+")|
      bg.equals("B-")|bg.equals("AB+")|bg.equals("AB-"))
      try
    {
      Blutgrupp=bg;
    }
      catch(Exception e)
    {
      return a;
    }
    return null;
} 


/**
 * Set method to set telephone number of emergency contact
 * @param: tel- Telefonnummer of the person
 * @return: a(String)
 */


public String settelefonnummer(String tel)
{
   String a = "Bitte gültige Telefonnummer eingeben!";
   if(tel.matches("[0-9]+"))
   try
   {
        telefonnummer = tel;
   }
    
    catch(Exception e)
   {
        return a;  
   }
   return null;
}
/**
     * Get-Method to get name of emergency contact
     * @return: Name(String)
     */
    public String getName()
    {
        return Name;
    }
/**
     * Get-method to get adress of emergency contact
     * @return: Adresse(String)
     */
    public String getadresse()
    { return Adresse;
    }
    
/**
     *return method to get relation of emergency contact to patient
     *@return: Beziehung(String)
     */
    public String getbeziehung()
    {
        return Beziehung;
    }
/**
     * Get-method to get telephone number of emergrncy contact
     * @return: telefonnummer(String)
     */
     public String gettelefonnummer()
    {
        return telefonnummer;
    }
    
    /**
     *Get- method to get blood type of emergency contact
     * @return: Blutgruppe(String)
     */
    public String getblutgruppe()
    {
        return Blutgrupp;
}
}