/**
 * Beschreiben Sie hier die Klasse Analysebericht.
 * 
 * @author Nicolas Pfaff 
 * @version 0.0.3
 */
import java.util.*;

public class Analysebericht
{
    String Laborantenkuerzel;
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
     * @param Laborantenkuerzel
     * @param Laborname
     * @param AnalyseObjekt
     * @param Analysemethode
     * @param Analyseergebnis
     */
    public Analysebericht(String Laborantenkuerzel, String Laborname, String AnalyseObjekt, String Analysemethode, String Analyseergebnis)
    {
        this.Laborantenkuerzel = Laborantenkuerzel;
        Calendar date = Calendar.getInstance();
        Analysedatum = date.get(Calendar.DAY_OF_MONTH ) + "." + (date.get(Calendar.MONTH) + 1 ) + "." + date.get(Calendar.YEAR);
        this.Laborname = Laborname;
        this.AnalyseObjekt = AnalyseObjekt;
        this.Analysemethode = Analysemethode;
        this.Analyseergebnis = Analyseergebnis;
    }

    public void Analyseberichtbearbeiten(String Laborantenkuerzel, String Erstellungsdatum, String Laborname, String AnalyseObjekt, String Analysemethode, String Analyseergebnis)
    {
        this.Laborantenkuerzel = Laborantenkuerzel;
        this.Analysedatum = Erstellungsdatum;
        this.Laborname = Laborname;
        this.AnalyseObjekt = AnalyseObjekt;
        this.Analysemethode = Analysemethode;
        this.Analyseergebnis = Analyseergebnis;
    }
}
