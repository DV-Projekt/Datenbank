
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
    public Analysebericht Analyseberichtsuchen(String gesucht)
    {
       Iterator<Analysebericht> it1 = Analyseberichte.iterator();
       boolean gefunden=false;
       int i=0;
       while(it1.hasNext()&&!gefunden)
       {
           if(Analyseberichte.get(i).getLaborantenkuerzel().equals(gesucht))
           {    
               gefunden=true;
               return Analyseberichte.get(i);
           }
           else if(Analyseberichte.get(i).getLaborname().equals(gesucht))
           {    
               gefunden=true;
               return Analyseberichte.get(i);
               
           }
           else if(Analyseberichte.get(i).getAnalyseObjekt().equals(gesucht))
           {    
               gefunden=true;
               return Analyseberichte.get(i);
           }
           else if(Analyseberichte.get(i).getAnalysemethode().equals(gesucht))
           {    
               gefunden=true;
               return Analyseberichte.get(i);
           }
           else if(Analyseberichte.get(i).getAnalyseergebnis().equals(gesucht))
           {    
               gefunden=true;
               return Analyseberichte.get(i);
           }
           else if(Analyseberichte.get(i).getAnalysedatum().equals(gesucht))
           {    
               gefunden=true;
               return Analyseberichte.get(i);
           }
           i++;
       }
       return null;
    }
    public void Exportieren()
    {
        
    }
    public void Analyseberichtlöschen()
    {
        
    }
    public Notfallkontakt Notfallkontaktaufrufen(String gesucht)
    {
       Iterator<Notfallkontakt> it2 = Notfallkontakte.iterator();
       boolean gefunden=false;
       int i=0;
       while(it2.hasNext()&&!gefunden)
       {
          if(
          return Notfallkontakte.get(i); 
       }
       return null;
    }
    
    //Erstellt einen neuen Notfallkontakt mit den eingegebenen Werten und fügt
    //ihn der Liste mit Notfallkontakten hinzu.
    public void Notfallkontakterstellen(String n, String ad, String bez, 
    int tel)
    {
        Notfallkontakt Kontakt = new Notfallkontakt(n, ad, bez, tel);
        Notfallkontakte.add(Kontakt);
    }
    public void Notfallkontaktlöschen()
    {
        
    }
}
