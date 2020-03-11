/**
 * Beschreiben Sie hier die Klasse Analysebericht.
 * 
 * @author Nicolas Pfaff 
 * @version 0.0.1
 */
import java.util.*;

public class Analysebericht
{
    String Laborant;
    String Erstellungsdatum;
    String Labor;
    String Analyseobjekt;
    String Analysemethode;
    String Analyseergebnis;

    /**
     * Der Konstruktor der Klasse Analysebericht erstellt einen neuen Analysebericht. 
     * Dabei werden die Daten Laborant, Labor, Analyseobjekt, Analysemethode und Analyseergebnis durch Parameter übergeben.
     * Das aktuelle Datum wird durch die Klasse Calendar erzeugt.
     * 
     * @param Laborant
     * @param Labor
     * @param Analyseobjekt
     * @param Analysemethode
     * @param Analyseergebnis
     */
    public Analysebericht(String Laborant, String Labor, String Analyseobjekt, String Analysemethode, String Analyseergebnis)
    {
        this.Laborant = Laborant;
        Calendar date = Calendar.getInstance();
        Erstellungsdatum = date.get(Calendar.DAY_OF_MONTH ) + "." + (date.get(Calendar.MONTH) + 1 ) + "." + date.get(Calendar.YEAR);
        this.Labor = Labor;
        this.Analyseobjekt = Analyseobjekt;
        this.Analysemethode = Analysemethode;
        this.Analyseergebnis = Analyseergebnis;
    }

    public void changeAnalysebericht(String Laborant, String Erstellungsdatum, String Labor, String Analyseobjekt, String Analysemethode, String Analyseergebnis)
    {
        this.Laborant = Laborant;
        this.Erstellungsdatum = Erstellungsdatum;
        this.Labor = Labor;
        this.Analyseobjekt = Analyseobjekt;
        this.Analysemethode = Analysemethode;
        this.Analyseergebnis = Analyseergebnis;
    }
}
