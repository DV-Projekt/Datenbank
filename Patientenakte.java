/**
 * In dieser Klasse wird eine Patientenakte neu initialisiert. 
 * Die Klasse führt die Klassen Notfallkontakt und Analysebericht zusammen.
 * Außerdem erstellt sie für jeden neuen Patienten eine Datei.
 * @author (Lennart Burkart, Ricarda Henkel)
 * @version (0.0.22)
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
     * Der Standardkonstruktor welcher eine neue Patientenakte erstellt
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
     *  @param all  Allergien des Patienten
     */
    public void SetAllergien(String all)
    {
        Allergien=all;
    }

    /** Set-Methode für die Vorerkrankungen des Patienten
     * 
     * @param v  Vorerkrankungen des Patienten
     */
    public void SetVorerkrankungen(String v)
    {
        Vorerkrankungen=v;
    }

    /** Set-Methode für die Telefonnummer des Patienten
     * 
     * @param t  Telefonnummer des Patienten
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
     * @param z  zuständiger Arzt des Patienten
     */
    public void SetZuständigerArzt(String z)
    {
        ZuständigerArzt=z;
    }

    /** Set-Methode für die Blutgruppe des Patienten
     * 
     * @param b  Blutgruppe des Patienten
     */
    public void SetBlutgruppe(String b)
    {
        Blutgruppe=b;
    }

    /** Set-Methode für das Geschlecht des Patienten
     * 
     * @param gesch  Geschlecht des Patienten
     */
    public String SetGeschlächt(String gesch)
    {
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
     * @param ad  Adresse des Patienten 
     */
    public void SetAdresse(String ad)
    {
        Adresse=ad;
    }

    /** Set-Methode für das Alter des Patienten
     * 
     * @param A  Alter des Patienten
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
     * @param N   Name des Patienten
     */
    public void SetName(String N)
    {
        Name=N;
    }

    /** Set-Methode für die Krankenkassen Nummer
     * 
     * @param nr  Krankenkassennummer des Patienten
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
     * @return KrankenkassenNr 
     */
    public String getKrankenkassenNr ()
    {
        return KrankenkassenNr;
    }

    /** Get-Methode für den Namen
     * 
     * @return Name
     */
    public String getName ()
    {
        return Name;
    }

    /** Get-Methode für das Alter
     * 
     * @return Alter 
     */
    public String getAlter ()
    {
        return Alter;
    }

    /** Get-Methode für das Geschlecht
     * 
     * @return Geschlecht
     */
    public String getGeschlecht ()
    {
        return Geschlecht;
    }

    /** Get-Methode für die Adresse
     * 
     * @return Adresse
     */
    public String getAdresse ()
    {
        return Adresse;
    }

    /** Get-Methode für die Blutgruppe
     * 
     * @return Blutgruppe
     */
    public String getBlutgruppe ()
    {
        return Blutgruppe;
    }

    /** Get-Methode für den zuständigen Arzt
     * 
     * @return ZuständigerArzt 
     */
    public String getZuständigerArzt ()
    {
        return ZuständigerArzt;
    }

    /** Get-Methode für die Telefonnummer
     * 
     * @return Telefonnummer 
     */
    public String getTelefonnummer ()
    {
        return Telefonnummer;
    }

    /** Get-Methode für die Vorerkrankungen
     * 
     * @return Vorerkrankungen
     */
    public String getVorerkrankungen ()
    {
        return Vorerkrankungen;
    }

    /** Get-Methode für die Allergien
     * 
     * @return Allergien
     */
    public String getAllergien()
    {
        return Allergien;
    }

    /** Get-Methode für die ArrayList der AnalyseBerichte
     * 
     * @return Analyseberichte 
     */
    public ArrayList <Analysebericht> getAnalysebericht()
    {
        return Analyseberichte;
    }

    /** Get-Methode für die ArrayList der Notfallkontakte
     * 
     * @return Notfallkontakte 
     */
    public ArrayList <Notfallkontakt> getNotfallkontakte()
    {
        return Notfallkontakte;
    }

    /** Die Methode Aktebearbeiten ändert die Werte einer bereits vorhandenen Patientenakte auf die neu eingegebenen Werte
     * 
     * @param Ad  Adresse des Patienten
     * @param Gesch  Geschlecht des Patienten
     * @param KrankNr  Krankenkassennummer des Patienten
     * @param Blut  Blutgruppe des Patienten
     * @param Arzt  zuständiger Arzt des Patienten
     * @param Tel  Telefonnummer des Patienten
     * @param Vor  Vorerkrankungen des Patienten
     * @param All  Allergien des Patienten 
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
     * @param Laborantenkuerzel   Kürzel des Laboranten aus der Klasse Analyseberichte
     * @param Laborname   Name des Labors aus der Klasse Analyseberichte
     * @param AnalyseObjekt   Objekt der Analyse aus der Klasse Analyseberichte
     * @param Analysemethode  Methode der Analyse aus der Klasse Analyseberichte
     */
    public void Analyseberichtanlegen(String Laborantenkuerzel, String 
    Laborname, String AnalyseObjekt, String Analysemethode, 
    String Analyseergebnis)
    {
        Analysebericht Bericht=new Analysebericht(Laborantenkuerzel, Laborname,
                AnalyseObjekt, Analysemethode, Analyseergebnis);
        Analyseberichte.add(Bericht);
    }

    /** Die Methode Analyseberichtsuchen vergleicht alle Attribute jedes Analyseberichtes aus der Analyseberichte Liste mit dem eingegebenen String
     * und gibt bei Übereinstimmung den Analysebericht aus der den gesuchten String enthält.
     * 
     * @param gesucht   eingegebener String des gesuchten Attributes
     *
     * @return Analyseberichte.get(i)   Analysebericht(e) inklusive des gesuchten String
     * @return null   wenn Nichts gefunden wurde
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

    /** Die Methode Exportieren wird verwendet um die Werte in eine Datei zu exportieren.
     * 
     * @param Dateiname   Der Name den die Datei haben soll
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
     * @return b  wenn die Datei gelöscht wurde
     * @return d  wenn die Datei nicht gelöscht werden konnte
     * @return null   wenn keine Datei mit der eingegebenen Nummer gefunden wurde
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

    /** Die Methode Notfallkontaktaufrufen vergleicht das Attribut Name jedes Notfallkontaktes aus der Liste mit Notfallkontakten mit dem eingegebenen 
     * String und gibt bei Übereinstimmung den Notfallkontakt, der den gesuchten String enthält, aus.
     * 
     * @param gesucht  Der Gesuchte Name des Notfallkontaktes
     * 
     * @return Notfallkontakte.get(i)  gefundener Notfallkontakt
     * @return null  Wenn kein Notfallkontakt mit dem gesuchten String gefunden wurde
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
     * @param n  Name des Notfallkontaktes
     * @param ad  Adresse des Notfallkontaktes
     * @param bez  Beziehung des Notfallkontaktes zum Patienten
     * @param tel  Telefonnummer des Notfallkontaktes
     * @param bg   Blutgruppe des Notfallkontaktes
     */
    public void Notfallkontakterstellen(String n, String ad, String bez, 
    String tel, String bg)
    {
        Notfallkontakt Kontakt = new Notfallkontakt(n, ad, bez, tel, bg);
        Notfallkontakte.add(Kontakt);
    }

    /** Die Methode Notfallkontaktlöschen führt die Methode Notfallkontaktaufrufen mit dem eingegebenen String aus und entfernt den Notfallkontakt der
     * von Notfallkontaktsuchen zurück gegeben wird von der Liste der Notfallkontakte. Danach macht sie eine Ausgabe auf dem 
     * Bildschirm dass der Nofallkontakt mit dem eingegebenen Namen gelöscht wurde.
     * 
     * @param Name  Name des gesuchten Notfallkontaktes
    */
    public void Notfallkontaktlöschen(String Name)
    {
        Notfallkontakte.remove(Notfallkontaktaufrufen(Name));
    }
}
