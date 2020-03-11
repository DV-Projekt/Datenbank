
/**
 * Write a description of class Patientenakte here.
 *
 * @author (Lennart Burkart)
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
    public void Aktebearbeiten(String N, int Alt, String Ad, String Gesch, int KrankNr, 
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
