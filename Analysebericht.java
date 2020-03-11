/**
 * Beschreiben Sie hier die Klasse Analysebericht.
 * 
 * @author Nicolas Pfaff 
 * @version 0.0.1
 */
import java.util.*;

public class Analysebericht
{
    String Laborantenkürzel;
    String Analysedatum;
    String Laborname;
    String AnalyseObjekt;
    String Analysemethode;
    String Analyseergebnis;

    /**
     * Der Konstruktor der Klasse Analysebericht erstellt einen neuen Analysebericht. 
     * Dabei werden die Daten Laborant, Labor, Analyseobjekt, Analysemethode und Analyseergebnis durch Parameter übergeben.
     * Das aktuelle Datum wird durch die Klasse Calendar erzeugt.
     * 
     * @param Laborantenkürzel
     * @param Laborname
     * @param AnalyseObjekt
     * @param Analysemethode
     * @param Analyseergebnis
     */
    public Analysebericht(String Laborant, String Labor, String Analyseobjekt, String Analysemethode, String Analyseergebnis)
    {
        Laborantenkürzel = Laborant;
        Calendar date = Calendar.getInstance();
        Analysedatum = date.get(Calendar.DAY_OF_MONTH ) + "." + (date.get(Calendar.MONTH) + 1 ) + "." + date.get(Calendar.YEAR);
        this.Laborname = Labor;
        this.AnalyseObjekt = Analyseobjekt;
        this.Analysemethode = Analysemethode;
        this.Analyseergebnis = Analyseergebnis;
    }

    public void Analyseberichtbearbeiten(String Laborant, String Erstellungsdatum, String Labor, String Analyseobjekt, String Analysemethode, String Analyseergebnis)
    {
        this.Laborantenkürzel = Laborant;
        this.Analysedatum = Erstellungsdatum;
        this.Laborname = Labor;
        this.AnalyseObjekt = Analyseobjekt;
        this.Analysemethode = Analysemethode;
        this.Analyseergebnis = Analyseergebnis;
    }
}
