
/**
 * Verwalter der Akten. Er enthällt alle Akten. 
 * Somit kann er auf diese Akten zugreifen, sie aufrufen und löschen.
 *
 * @author (Angelika Jouperina)
 * @version (0.0.8)
 */
import java.util.ArrayList;
import java.io.IOException;

public class Verwalter
{
    public ArrayList <Patientenakte> Akten;

    /**
     * Konstruktor der eine Leere ArrayList der Patientenakten erstellt
     */
    public Verwalter ()
    {
        Akten = new ArrayList <Patientenakte> ();
    }

    /**
     * Konstruktor der die ArrayList der Patientenakten erstellt 
     * und zusätzlich eine Patientenakte erstellt und hinzufügt
     */
    public Verwalter (String Name, String Alter, String Addresse, 
    String Geschlecht, String KrankenkassenNr, String Blutgruppe, 
    String Arzt, String Telefonnummer, String Vorerkrankungen, String Allergien)
    {
        Akten = new ArrayList <Patientenakte> ();        
        Patientenakte Akte = new Patientenakte (Name,Alter,Addresse,Geschlecht,
                KrankenkassenNr,Blutgruppe,Arzt, Telefonnummer, Vorerkrankungen,Allergien);
        Akten.add(Akte);
    }

    /**
     * Get Methode für die ArrayList
     * 
     * @param keiner
     * @return ArrayList "Akten"
     */ 
    public ArrayList <Patientenakte> getArrayList ()
    {
        return Akten;
    }

    /**
     * Akteanlegen: Methode die eine neue Patientenakte anlegt und diese der ArrayList
     * hinzufügt
     * 
     * @param Name,Alter,Addresse,Geschlecht,KrankenkassenNr,Blutgruppe,
     * Arzt,Telefonnummer,Vorerkrankungen,Allergien
     * 
     * @return keiner
     */
    public String Akteanlegen (String Name, String Alter, String Addresse, 
    String Geschlecht, String KrankenkassenNr, String Blutgruppe, 
    String Arzt, String Telefonnummer, String Vorerkrankungen, String Allergien)
    {
        Patientenakte Akte = new Patientenakte (Name,Alter,Addresse,Geschlecht,
                KrankenkassenNr,Blutgruppe,Arzt, Telefonnummer, Vorerkrankungen,Allergien);

        Patientenakte ak = Aktesuchen (KrankenkassenNr);
        if (ak != null)
        {
            return "Akte wurde nicht gefunden!";
        }

        if (ak == null)
        {
            Akten.add(Akte);
            return "Akte wurde hinzugefügt!";
        }

        return "";
    }

    /**
     * Aktelöschen: Methode die eine Akte sucht und dannach diese aus der
     * ArrayList entfernt
     * 
     * @param KrankenkassenNr
     * @return keiner
     */

    public String Aktelöschen (String KrankenkassenNr)
    {
        Patientenakte ak = Aktesuchen (KrankenkassenNr);
        if (ak != null)
        {
            Akten.remove(ak);
            return "Akte wurde erfolgreich gelöscht!";
        }

        if (ak == null)
        {
            return "Akte wurde nicht gefunden!";
        }
        return "";
    }

    /**
     * Aktesuchen: Methode die eine Akte nach der Krankenkassennummer sucht
     * 
     * @param KrankenkassenNummer
     * @return Patientenakte
     */

    public Patientenakte Aktesuchen (String KrankenkassenNr)
    {
        for (Patientenakte c : Akten)
        {
            if (c.getKrankenkassenNr().equals(KrankenkassenNr))
            {
                return c;
            }
        }
        

        return null;
    }
}
