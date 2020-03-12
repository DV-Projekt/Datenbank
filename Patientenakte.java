
/**
 * Write a description of class Patientenakte here.
 *
 * @author (Lennart Burkart, Ricarda Henkel)
 * @version (0.0.2)
 */
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
    
    //erstellt einen neuen Analysebericht mit den eingegebenen Werten.
    public void Analyseberichtanlegen()
    {
        
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
    public void Notfallkontakterstellen()
    {
        
    }
    public void Notfallkontaktlöschen()
    {
        
    }
}
