
/**
 * Verwalter der Akten. Er enthällt alle Akten. 
 * Somit kann er auf diese Akten zugreifen und die Akten aufrufen.
 *
 * @author (Angelika Jouperina)
 * @version (1.0)
 */
import java.util.*;

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

        
        Akten.add(Akte);
    }
    
    /**
     * Aktelöschen: Methode die eine Akte sucht und dannach diese aus der
     * ArrayList entfernt
     * 
     * @param
     * @return
     */

    public void Aktelöschen ()
    {
        
    }
    
    /**
     * Aktesuchen: Methode die eine Akte nach der Krankenkassennummer sucht
     * 
     * @param KrankenkassenNummer
     * @return 
     */

    public void Aktesuchen ()
    {

    }
}
