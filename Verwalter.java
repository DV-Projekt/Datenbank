
/**
 * Verwalter der Akten. Er enthällt alle Akten. 
 * Somit kann er auf diese Akten zugreifen, sie aufrufen und löschen.
 *
 * @author (Angelika Jouperina)
 * @version (0.0.6)
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
     * hinzufügt
     * 
     * @param Name,Aler,Addresse,Geschlecht,KrankenkassenNr,Blutgruppe,
     * Arzt,Telefonnummer,Vorerkrankungen,Allergien
     * 
     * @ return keiner
     */
    public void Akteanlegen (String Name, int Alter, String Addresse, 
    String Geschlecht, int KrankenkassenNr, String Blutgruppe, 
    String Arzt, int Telefonnummer, String Vorerkrankungen, String Allergien)
    {
        Patientenakte Akte = new Patientenakte (Name,Alter,Addresse,Geschlecht,
                KrankenkassenNr,Blutgruppe,Arzt, Telefonnummer, Vorerkrankungen,Allergien);

        boolean gefunden = false;
        for (Patientenakte a : Akten)
        {
            if (a.getKrankenkassenNr () == KrankenkassenNr)
            {
                gefunden = true;
                System.out.println("Die Patientenakte mit der Nummer " +KrankenkassenNr+" existiert bereits.");
            }
        }
        if (gefunden == false)
        {
            Akten.add(Akte);
            System.out.println("Neue Patientenakte wurde hinzugefügt.");
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
        boolean gefunden = false;
        for (Patientenakte b : Akten)
        {
            if (b.getKrankenkassenNr () == KrankenkassenNr)
            {
                gefunden = true;
                Akten.remove(b);
                System.out.println("Akte mit der Nummer "+KrankenkassenNr+" wurde gelöscht.");
            }
        }
        if (gefunden == false)
        {
            System.out.println("Akte mit der Nummer "+KrankenkassenNr+" wurde nicht gefunden.");
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
        boolean gefunden = false;
        for (Patientenakte b : Akten)
        {
            if (b.getKrankenkassenNr () == KrankenkassenNr)
            {
                gefunden = true;
                return b;
            }
        }
        if (gefunden == false)
        {
            System.out.println("Akte mit der Nummer "+KrankenkassenNr+" wurde nicht gefunden.");
        }

        return null;
    }
}
