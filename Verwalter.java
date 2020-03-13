
/**
 * Verwalter der Akten. Er enthällt alle Akten. 
 * Somit kann er auf diese Akten zugreifen und sie aufrufen.
 *
 * @author (Angelika Jouperina)
 * @version (0.0.5)
 */
import java.util.ArrayList;

public class Verwalter
{
    private ArrayList <Patientenakte> Akten;

    /**
     * Konstruktor der die ArrayList der Patientenakten erstellt
     */
    public Verwalter ()
    {
        Akten = new ArrayList <Patientenakte> ();
    }

    /**
     * Akteanlegen: Methode die eine neue Patientenakte anlegt und diese der ArrayList
     * hinzfügt
     * 
     * @param Name,Aler, Addresse Geschlecht,KrankenkassenNr,Blutgruppe,
     * Arzt,Telefonummer,Vorerkrankungen,Allergien
     * 
     * @ return keiner
     */
    public void Akteanlegen (String Name, int Alter, String Addresse, 
    String Geschlecht, int KrankenkassenNr, String Blutgruppe, 
    String Arzt, int Telefonummer, String Vorerkrankungen, String Allergien)
    {
        Patientenakte Akte = new Patientenakte (Name,Alter,Addresse,Geschlecht,
                KrankenkassenNr,Blutgruppe,Arzt, Telefonummer, Vorerkrankungen,Allergien);

        boolean gefunden = true;
        for (Patientenakte a : Akten)
        {
            if (a.getKrankenkassenNr () == KrankenkassenNr)
            {
                gefunden = false;
            }
        }
        if (gefunden == true)
        {
            Akten.add(Akte);
        }
    }

    /**
     * Aktelöschen: Methode die eine Akte sucht und dannach diese aus der
     * ArrayList entfernt
     * 
     * @param KrankenkassenNr
     * @return keiner
     */

    public void Aktelöschen (int KrankenkassenNr)
    {
        for (Patientenakte b : Akten)
        {
            if (b.getKrankenkassenNr () == KrankenkassenNr)
            {
                 Akten.remove(b);
            }
        }
    }

    /**
     * Aktesuchen: Methode die eine Akte nach der Krankenkassennummer sucht
     * 
     * @param KrankenkassenNummer
     * @return Patientenakte
     */

    public Patientenakte Aktesuchen (int KrankenkassenNr)
    {
        for (Patientenakte b : Akten)
        {
            if (b.getKrankenkassenNr () == KrankenkassenNr)
            {
                return b;
            }
        }
        
        return null;
    }
}
