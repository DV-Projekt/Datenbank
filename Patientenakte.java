/**
 * In dieser Klasse wird eine Patientenakte neu initialisiert. 
 * Die Klasse führt die Klassen Notfallkontakt und Analysebericht zusammen.
 * Außerdem erstellt sie für jeden neuen Patienten eine Exelatei die alle Attributwerte enthält.
 * @author (Lennart Burkart, Ricarda Henkel)
 * @version (0.0.25)
 */
import java.util.*;
import java.io.File;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.commons.collections4.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;

public class Patientenakte
{
    private String Name;
    private String Alter;
    private String Adresse;
    private String Geschlecht;
    private String KrankenkassenNr;
    private String Blutgruppe;
    private String ZuständigerArzt;
    private String Telefonnummer;
    private String Vorerkrankungen;
    private String Allergien;
    private ArrayList<Analysebericht> Analyseberichte;
    private ArrayList<Notfallkontakt> Notfallkontakte;

    /**
     * Der Standardkonstruktor welcher eine neue Patientenakte mit bereits festgelegten Werten für die Attribute erstellt
     * 
     * Parameter: keine
     * Rückgabe: keine
     */
    public Patientenakte()
    {
        Name = "n";
        Alter= "0";
        Adresse = "ad";
        Geschlecht = "gesch";
        KrankenkassenNr = "0";
        Blutgruppe = "blutgr";
        ZuständigerArzt = "arzt";
        Telefonnummer = "0";
        Vorerkrankungen = "vor";
        Allergien = "all";
        Analyseberichte = new ArrayList<Analysebericht>();
        Notfallkontakte = new ArrayList<Notfallkontakt>();
    }

    /** 
     * Konstruktor welcher eine neue Patientenakte erstellt und ihr die angegebenen Werte zuweist. 
     * 
     * @param N     Name des Patienten
     * @param Alt   Alter des Patienten
     * @param Ad    Adresse des Patienten
     * @param Gesch Geschlecht des Patienten
     * @param KrankNr Krankenkassennummer des Patienten
     * @param Blut  Blutgruppe des Patienten
     * @param Arzt  Zuständiger Arzt des Patienten
     * @param Tel   Telefonnummer des Patienten
     * @param Vor   Vorerkrankungen des Patienten
     * @param All   Allergien des Patienten
     * Rückgabe: keine
     */
    public Patientenakte(String N, String Alt, String Ad, String Gesch, String KrankNr, 
    String Blut, String Arzt, String Tel, String Vor, String All)
    {
        Alter=Alt;
        KrankenkassenNr=KrankNr;
        Telefonnummer=Tel;
        Adresse=Ad;
        Blutgruppe=Blut;
        ZuständigerArzt=Arzt;
        Geschlecht=Gesch;
        Name=N;
        Vorerkrankungen=Vor;
        Allergien=All;
        Analyseberichte = new ArrayList<Analysebericht>();
        Notfallkontakte = new ArrayList<Notfallkontakt>();
    }

    /** Set-Methode für die Allergien des Patienten 
     * 
     * Ändert das Attribut Allergie auf den eingegebenen String
     * @param all (String) Allergien des Patienten
     * Rückgabe: keine
     */
    public void SetAllergien(String all)
    {
        Allergien=all;
    }

    /** Set-Methode für die Vorerkrankungen des Patienten
     * 
     * Ändert das Attribut Vorerkrankung auf den eingegebenen String
     * @param v (String) Vorerkrankungen des Patienten
     * Rückgabe: keine
     */
    public void SetVorerkrankungen(String v)
    {
        Vorerkrankungen=v;
    }

    /** Set-Methode für die Telefonnummer des Patienten
     * 
     * Ändert das Attribut Telefonnummer auf den eingegebenen String, falls dieser nur aus Zahlen besteht
     * @param t (String) Telefonnummer des Patienten
     * @return a (String)
     */
    public String SetTelefonnummer(String t)
    {
        String a="Bitte geben Sie eine Nummer ein.";
        if(t.matches("[0-9]+"))
            Telefonnummer=t;
        else
            return a;
        return null;
    }

    /** Set-Methode für den zuständigen Arzt 
     * 
     * Ändert das Attribut zuständigerArzt auf den eingegebenen String
     * @param z (String) zuständiger Arzt des Patienten
     * Rückgabe: keine
     */
    public void SetZuständigerArzt(String z)
    {
        ZuständigerArzt=z;
    }

    /** Set-Methode für die Blutgruppe des Patienten
     * 
     * Ändert das Attribut Blutgruppe auf den eingegebenen String
     * @param b (String) Blutgruppe des Patienten
     * Rückgabe: keine
     */
    public void SetBlutgruppe(String b)
    {
        Blutgruppe=b;
    }

    /** Set-Methode für das Geschlecht des Patienten
     * 
     * Ändert das Attribut Geschlächt auf den eingegebenen String, falls dieser männlich oder weiblich ist.
     * @param gesch (String) Geschlecht des Patienten
     * @return a (String)
     */
    public String SetGeschlächt(String gesch)
    {
        //divers noch hinzufügen
        String a="Bitte geben Sie ein Geschlecht ein.";
        if(gesch.equals("männlich")| gesch.equals("Männlich")
        |gesch.equals("weiblich")|gesch.equals("Weiblich"))
            Geschlecht=gesch;
        else
            return a;
        return null;
    }

    /** Set-Methode für die Adresse des Patienten
     * 
     * Ändert das Attribut Adresse auf den eingegebenen String
     * @param ad (String) Adresse des Patienten 
     */
    public void SetAdresse(String ad)
    {
        Adresse=ad;
    }

    /** Set-Methode für das Alter des Patienten
     * 
     * Ändert das Attribut Alter auf den eingegebenen String, falls dieser eine Nummer ist.
     * @param A (String) Alter des Patienten
     * @retrun a (String)
     */
    public String SetAlter(String A)
    {
        String a="Bitte geben Sie eine Nummer ein.";
        if(A.matches("[0-9]+"))
            Alter=A;
        else
            return a;
        return null;
    }

    /** Set-Methode für den Patienten Namen
     * 
     * Ändert das Attribut Name auf den eingegebenen String
     * @param N (String) Name des Patienten
     * Rückgabe: keine
     */
    public void SetName(String N)
    {
        Name=N;
    }

    /** Set-Methode für die Krankenkassen Nummer
     * 
     * Ändert das Attribut KrankenkassenNr auf den eingegebenen String, falls dieser eine Zahl ist.
     * @param nr (String) Krankenkassennummer des Patienten
     * @return a (String)
     */
    public String SetKrankenkassenNr(String nr)
    {
        String a="Bitte geben Sie eine Nummer ein.";
        if(nr.matches("[0-9]+"))
            KrankenkassenNr=nr;
        else
            return a;
        return null;
    }

    /** Get-Methode für die KrankenkassenNr
     * 
     * Gibt einem die Krankenkassennummer des Patienten.
     * @return KrankenkassenNr (String)  
     */
    public String getKrankenkassenNr ()
    {
        return KrankenkassenNr;
    }

    /** Get-Methode für den Namen
     * 
     * Gibt einem den Namen des Patienten.
     * @return Name (String) 
     */
    public String getName ()
    {
        return Name;
    }

    /** Get-Methode für das Alter
     * 
     * Gibt einem das Alter des Patienten.
     * @return Alter (String)  
     */
    public String getAlter ()
    {
        return Alter;
    }

    /** Get-Methode für das Geschlecht
     * 
     * Gibt einem das Geschlecht des Patienten.
     * @return Geschlecht (String) 
     */
    public String getGeschlecht ()
    {
        return Geschlecht;
    }

    /** Get-Methode für die Adresse
     * 
     * Gibt einem die Adresse des Patienten.
     * @return Adresse (String) 
     */
    public String getAdresse ()
    {
        return Adresse;
    }

    /** Get-Methode für die Blutgruppe
     * 
     * Gibt einem die Blutgruppe des Patienten.
     * @return Blutgruppe (String) 
     */
    public String getBlutgruppe ()
    {
        return Blutgruppe;
    }

    /** Get-Methode für den zuständigen Arzt
     * 
     * Gibt einem den zuständigen Arzt des Patienten.
     * @return ZuständigerArzt (String)  
     */
    public String getZuständigerArzt ()
    {
        return ZuständigerArzt;
    }

    /** Get-Methode für die Telefonnummer
     * 
     * Gibt einem die Telefonnummer des Patienten.
     * @return Telefonnummer (String)  
     */
    public String getTelefonnummer ()
    {
        return Telefonnummer;
    }

    /** Get-Methode für die Vorerkrankungen
     * 
     * Gibt einem die Vorerkrankungen des Patienten.
     * @return Vorerkrankungen (String) 
     */
    public String getVorerkrankungen ()
    {
        return Vorerkrankungen;
    }

    /** Get-Methode für die Allergien
     * 
     * Gibt einem die Allergien des Patienten.
     * @return Allergien (String) 
     */
    public String getAllergien()
    {
        return Allergien;
    }

    /** Get-Methode für die ArrayList der AnalyseBerichte
     * 
     * Gibt einem alle Analyseberichte des Patienten.
     * @return Analyseberichte (Analysebericht)
     */
    public ArrayList <Analysebericht> getAnalysebericht()
    {
        return Analyseberichte;
    }

    /** Get-Methode für die ArrayList der Notfallkontakte
     * 
     * Gibt einem alle Notfallkontakte des Patienten
     * @return Notfallkontakte (Notfallkontakt)
     */
    public ArrayList <Notfallkontakt> getNotfallkontakte()
    {
        return Notfallkontakte;
    }

    /** Die Methode Aktebearbeiten ändert die Werte einer bereits vorhandenen Patientenakte auf die neu eingegebenen Werte
     * 
     * @param Ad (String) Adresse des Patienten
     * @param Gesch (String) Geschlecht des Patienten
     * @param KrankNr (String) Krankenkassennummer des Patienten
     * @param Blut (String) Blutgruppe des Patienten
     * @param Arzt (String) zuständiger Arzt des Patienten
     * @param Tel (String) Telefonnummer des Patienten
     * @param Vor (String) Vorerkrankungen des Patienten
     * @param All (String) Allergien des Patienten
     * Rückgabe: keine
     */
    public void Aktebearbeiten(String Ad, String Gesch, String KrankNr, 
    String Blut, String Arzt, String Tel, String Vor, String All)
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

    /** Die Methode Analyseberichtanlegen erstellt einen neuen Analysebericht mit den eingegebenen Werten und fügt
     * ihn der Liste von Analyseberichten hinzu.
     * 
     * @param Laborantenkuerzel (String) Kürzel des Laboranten aus der Klasse Analyseberichte
     * @param Laborname (String)  Name des Labors aus der Klasse Analyseberichte
     * @param AnalyseObjekt (String) Objekt der Analyse aus der Klasse Analyseberichte
     * @param Analysemethode (String) Methode der Analyse aus der Klasse Analyseberichte
     * Rückgabe: keine
     */
    public void Analyseberichtanlegen(String Laborantenkuerzel, String 
    Laborname, String AnalyseObjekt, String Analysemethode, 
    String Analyseergebnis)
    {
        Analysebericht Bericht=new Analysebericht(Laborantenkuerzel, Laborname,
                AnalyseObjekt, Analysemethode, Analyseergebnis);
        Analyseberichte.add(Bericht);
    }

    /** Die Methode Analyseberichtsuchen vergleicht alle Attribute jedes Analyseberichtes aus der Analyseberichte Liste 
     * mit dem eingegebenen String und gibt bei Übereinstimmung den Analysebericht aus der den gesuchten String enthält.
     * 
     * @param gesucht (String) eingegebener String des gesuchten Attributes
     * @return Analysebericht (Analysebericht) Analysebericht(e) die den gesuchten String enthalten
     */
    public Analysebericht Analyseberichtsuchen(String gesucht)
    {
       boolean gefunden=false;
       for(int i = 0; i< Analyseberichte.size(); i++)
       {
            if(Analyseberichte.get(i).getLaborantenkuerzel().equalsIgnoreCase(gesucht))
            {    
                gefunden=true;
                return Analyseberichte.get(i);
            }
            else if(Analyseberichte.get(i).getLaborname().equalsIgnoreCase(gesucht))
            {    
                gefunden=true;
                return Analyseberichte.get(i);

            }
            else if(Analyseberichte.get(i).getAnalyseObjekt().equalsIgnoreCase(gesucht))
            {    
                gefunden=true;
                return Analyseberichte.get(i);
            }
            else if(Analyseberichte.get(i).getAnalysemethode().equalsIgnoreCase(gesucht))
            {    
                gefunden=true;
                return Analyseberichte.get(i);
            }
            else if(Analyseberichte.get(i).getAnalyseergebnis().equalsIgnoreCase(gesucht))
            {    
                gefunden=true;
                return Analyseberichte.get(i);
            }
            else if(Analyseberichte.get(i).getAnalysedatum().equalsIgnoreCase(gesucht))
            {    
                gefunden=true;
                return Analyseberichte.get(i);
            }
            if(gefunden == false)
            {
                throw new IllegalArgumentException("Es existiert keine Akte mit dem gesuchten Wort");
            }
            return null;
        }
        return null;
    }

    /** Die Methode Exportieren wird verwendet um die Werte der Attribute in eine Exeldatei zu exportieren.
     * 
     * @param Dateiname (String) Der Name den die Datei haben soll
     * Rückgabe: keine
     */
    public void Exportieren(String Dateiname)
    {
        Path f = Paths.get("C:\\ChemischeAnalysedatenbank\\Patientenakten");
        if (!Files.exists(f)) 
        {
            try 
            {
                Files.createDirectories(f);
            } 
            catch (IOException e) 
            {
                e.printStackTrace();    
            }
        }
        String filename = "C:\\ChemischeAnalysedatenbank\\Patientenakten"+ System.getProperty("file.separator")
            + KrankenkassenNr + Dateiname + ".xlsx";

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Patientenakte "+KrankenkassenNr);

        String[][] werte = new String [][]{{"Name", "Alter", "Adresse","Geschlecht", "KrankenkassenNr", 
                    "Blutgruppe", "ZuständigerArzt", "Telefonnummer", "Vorerkrankungen", "Allergien"},
                {Name, Alter, Adresse, Geschlecht, KrankenkassenNr, Blutgruppe, ZuständigerArzt, Telefonnummer, 
                    Vorerkrankungen, Allergien}};

        int rowNum =0;

        for (int i=0; i<2; i++) 
        {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (int j=0; j<7; j++) 
            {
                Cell cell = row.createCell(colNum++);
                cell.setCellValue(werte[i][j]);
            }
        }

        try 
        {
            FileOutputStream outputStream = new FileOutputStream(filename);
            workbook.write(outputStream);
            workbook.close();
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    /** Die Methode Analyseberichtlöschen entfernt den Analysebericht welcher die eingegebene Nummer besitzt.
     * 
     * @param Nummer  die gesuchte Nummer die eingegeben wird
     * 
     * @return b (String)  wenn die Datei gelöscht wurde
     * @return d (String)  wenn die Datei nicht gelöscht werden konnte
     */
    public String Analyseberichtlöschen(String Nummer)
    {
        Iterator<Analysebericht> it1 = Analyseberichte.iterator();
        boolean gelöscht=false;
        int i=0;
        while(gelöscht == false && it1.hasNext())
        {
            try
            {
                if(Analyseberichte.get(i).getBerichtNR().equals(Nummer))
                {   
                    Analyseberichte.remove(Analyseberichte.get(i));
                    File f = new File("C:/ChemischeAnalysedatenbank/Analyseberichte");
                    File[] fileArray = f.listFiles();
                    boolean r = false;
                    for(int k = 0; k<fileArray.length; k++)
                    {
                        String name = fileArray[k].getName();
                        if(name.contains(Nummer))
                        {
                            File d = new File("C:/ChemischeAnalysedatenbank/Analyseberichte/"+name);
                            d.delete();
                            r= true;
                        }
                    }   
                    if(r==false)
                    {   
                        String d="Datei konnte nicht gelöscht werden";
                        return d;
                    }
                    else
                    {
                        String b="Der Analysebericht mit der Nummer: "+Nummer+" wurde erfolgreich gelöscht.";
                        gelöscht=true;
                        return b;
                    }
                }
                i++;
            }
            catch (NullPointerException e)
            {
                e.printStackTrace();
            }
        }
        if(gelöscht == false)
        {
            String c="Es wurde kein Analysebericht mit der Nummer: "+Nummer+" zum löschen gefunden.";
            return c;
        }
        return null;
    }

    /** Die Methode Notfallkontaktaufrufen vergleicht das Attribut Name jedes Notfallkontaktes aus der Liste der 
     * Notfallkontakten mit dem eingegebenen String und gibt bei Übereinstimmung den Notfallkontakt, der den gesuchten 
     * String enthält, aus.
     * 
     * @param gesucht (String) Der Gesuchte Name des Notfallkontaktes
     * 
     * @return Notfallkontakt (Notfallkontakt) Notfallkontakt der den eingegebenen String enthält.
     */
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
        return null;
    }

    /** Die Methode Notfallkontakterstellen erstellt einen neuen Notfallkontakt mit den eingegebenen Werten und fügt
     * ihn der Liste mit Notfallkontakten hinzu.
     * 
     * @param n (String) Name des Notfallkontaktes
     * @param ad (String) Adresse des Notfallkontaktes
     * @param bez (String) Beziehung des Notfallkontaktes zum Patienten
     * @param tel (String) Telefonnummer des Notfallkontaktes
     * @param bg (String) Blutgruppe des Notfallkontaktes
     * Rückgabe: keine
     */
    public void Notfallkontakterstellen(String n, String ad, String bez, 
    String tel, String bg)
    {
        Notfallkontakt Kontakt = new Notfallkontakt(n, ad, bez, tel, bg);
        Notfallkontakte.add(Kontakt);
    }

    /** Die Methode Notfallkontaktlöschen führt die Methode Notfallkontaktaufrufen mit dem eingegebenen String aus und 
     * entfernt den Notfallkontakt der von Notfallkontaktsuchen zurück gegeben wird von der Liste der Notfallkontakte. 
     * 
     * @param Name (String) Name des gesuchten Notfallkontaktes
     * Rückgabe: keine
    */
    public void Notfallkontaktlöschen(String Name)
    {
        Notfallkontakte.remove(Notfallkontaktaufrufen(Name));
    }
}
