
/**
 * Write a description of class Patientenakte here.
 *
 * @author (Lennart Burkart, Ricarda Henkel)
 * @version (0.0.7)
 */
import java.util.*;
import java.io.File;
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
    
    public void SetKrankenkassenNr (int nr)
    {
        KrankenkassenNr=nr;
    }
    
    
    //Get Methode für KrankenkassenNr (benutzt in Verwalter)
    public int getKrankenkassenNr ()
    {
        return KrankenkassenNr;
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

    //Vergleicht alle Attribute jedes Analyseberichtes aus der Analyseberichte liste mit dem eingegebenen String
    //und gibt bei übereinstimmung den Analysebericht aus der den gesuchten String enthält.
    public Analysebericht Analyseberichtsuchen(String gesucht)
    {
        Iterator<Analysebericht> it1 = Analyseberichte.iterator();
        boolean gefunden=false;
        int i=0;
        while(it1.hasNext()&&!gefunden)
        {
            Analysebericht a=it1.Next();
            if(a.getLaborantenkuerzel().equals(gesucht))
            {    
                gefunden=true;
                return Analyseberichte.get(i);
            }
            else if(a.getLaborname().equals(gesucht))
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
        if(!gefunden)//System out print durch exeptions ersetzen für oberfläche
            System.out.print("Keinen Analysebericht gefunden der "+gesucht+" enthält");
        return null;
    }

    public void Exportieren()
    {

    }

    //entfernt den Analysebericht der die eingegebene Nummer besitzt.
    public void Analyseberichtlöschen(int Nummer)
    {
        Iterator<Analysebericht> it1 = Analyseberichte.iterator();
        boolean gelöscht=false;
        int i=0;
        while(!gelöscht&& it1.hasNext())
        {
            if(Analyseberichte.get(i).getBerichtNR() == Nummer)
            {
                Analyseberichte.remove(Analyseberichte.get(i));
                System.out.print("Der Analysebericht mit der Nummer: "+Nummer+" wurde erfolgreich gelöscht.");
                gelöscht=true;
            }
            i++;
        }
        System.out.print("Es wurde kein Analysebericht mit der Nummer: "+Nummer+" zum löschen gefunden.");

        //löschen der Datei von Nico
        File f = new File("C:/ChemischeAnalysedatenbank/Analyseberichte");
        File[] fileArray = f.listFiles();
        boolean r = false;
        for(int k = 0; k<fileArray.length; k++)
        {
            String name = fileArray[k].getName();
            String n = Integer.toString(Nummer);
            if(name.contains(n))
            {
                File d = new File("C:/ChemischeAnalysedatenbank/Analyseberichte/"+name);
                d.delete();
                r= true;
            }
        }
        if(r==false)
        {
            System.out.println("Datei konnte nicht gelöscht werden");
        }
        else
        {
            System.out.println("Datei wurde gelöscht");
        }
    }

    //Vergleicht das Attribut Name jedes Notfallkontaktes aus der Liste mit Notfallkontakten mit dem eingegebenen 
    //String und gibt bei übereinstimmung den Notfallkontakt der den gesuchten String enthält aus.
    public Notfallkontakt Notfallkontaktaufrufen(String gesucht)
    {
        Iterator<Notfallkontakt> it2 = Notfallkontakte.iterator();
        boolean gefunden=false;
        int i=0;
        while(it2.hasNext()&&!gefunden)
        {
            if(Notfallkontakte.get(i).getName().equals(gesucht))
            {
                gefunden=true;
                return Notfallkontakte.get(i); 
            }
            i++;
        }
        if(!gefunden)
            System.out.print("Kein Notfallkontakt mit dem Namen: "+gesucht+" gefunden.");
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

    //führt die Methode Notfallkontaktaufrufen mit dem eingegebenen String aus und entfernt den Notfallkontakt der
    //von Notfallkontaktsuchen zurück gegeben wird von der Liste der Notfallkontakte. Macht eine Ausgabe auf dem 
    //Bildschirm dass der Nofallkontakt mit dem eingegebenen Namen gelöscht wurde.
    public void Notfallkontaktlöschen(String Name)
    {
        Notfallkontakte.remove(Notfallkontaktaufrufen(Name));
        System.out.print("Der Notfallkontakt mit dem Namen: "+Name+" wurde erfolgreich gelöscht.");
    }
}
