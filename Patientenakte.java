
/**
 * Write a description of class Patientenakte here.
 *
 * @author (Lennart Burkart, Ricarda Henkel)
 * @version (0.0.2)
 */
import java.util.*;
public class Patientenakte
{
    private String Name;
    private int Alter;
    private String Adresse;
    private String Geschlecht;
    private int KrankenkassenNr;
    private String Blutgruppe;
    private String ZuständigerArzt;
    private int Telefonnummer;
    private String Vorerkrankungen;
    private String Allergien;
    private ArrayList<Analysebericht> Analyseberichte;
    private ArrayList<Notfallkontakt> Notfallkontakte;
    
    //erstellt eine neue Patientenakte und weist ihr die eingegebenen Werte zu.
    public Patientenakte(String N, int Alt, String Ad, String Gesch, int KrankNr, 
    String Blut, String Arzt, int Tel, String Vor, String All)
    {
        Name=N;
        Alter=Alt;
        Adresse=Ad;
        Geschlecht=Gesch;
        KrankenkassenNr=KrankNr;
        Blutgruppe=Blut;
        ZuständigerArzt=Arzt;
        Telefonnummer=Tel;
        Vorerkrankungen=Vor;
        Allergien=All;
        Analyseberichte = new ArrayList<Analysebericht>();
        Notfallkontakte = new ArrayList<Notfallkontakt>();
    }
    
    //ändert die Werte einer bereits vorhandenen Patientenakte auf die neu 
    //eingegebenen Werte
    public void Aktebearbeiten(String Ad, String Gesch, int KrankNr, 
    String Blut, String Arzt, int Tel, String Vor, String All)
    {
        Adresse=Ad;
        Geschlecht=Gesch;
        KrankenkassenNr=KrankNr;
        Blutgruppe=Blut;
        ZuständigerArzt=Arzt;
        Telefonnummer=Tel;
        Vorerkrankungen=Vor;
        Allergien=All;  
    }
    
    //erstellt einen neuen Analysebericht mit den eingegebenen Werten und fügt
    //ihn der Liste von Analyseberichten hinzu.
    public void Analyseberichtanlegen(String Laborantenkuerzel, String 
    Laborname, String AnalyseObjekt, String Analysemethode, 
    String Analyseergebnis)
    {
        Analysebericht Bericht=new Analysebericht(Laborantenkuerzel, Laborname,
        AnalyseObjekt, Analysemethode, Analyseergebnis);
        Analyseberichte.add(Bericht);
    }
    public void Analyseberichtsuchen()
    {
        
    }
    public void Exportieren()
    {
        
    }
    public void Analyseberichtlöschen()
    {
        
    }
    public void Notfallkontaktaufrufen()
    {
        
    }
    
    //Erstellt einen neuen Notfallkontakt mit den eingegebenen Werten und fügt
    //ihn der Liste mit Notfallkontakten hinzu.
    public void Notfallkontakterstellen()
    {
        Notfallkontakt Kontakt = new Notfallkontakt();
        Notfallkontakte.add(Kontakt);
    }
    public void Notfallkontaktlöschen()
    {
        
    }
}
