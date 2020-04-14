/**
 * Write a description of class Patientenakte here.
 *
 * @author (Lennart Burkart, Ricarda Henkel)
 * @version (0.0.15)
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
    
    //Standardkonstruktor
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

    //erstellt eine neue Patientenakte und weist ihr die eingegebenen Werte zu.
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
    
    //Set Methode für die Allergien des Patienten
    public void SetAllergien(String all)
    {
        Allergien=all;
    }
    
    //Set Methode für die Vorerkrankungen des Patienten
    public void SetVorerkrankungen(String v)
    {
        Vorerkrankungen=v;
    }
    
    //Set Methode für die Telefonnummer des Patienten
    public String SetTelefonnummer(String t)
    {
        String a="Bitte geben Sie eine Nummer ein.";
        if(t.matches("[0-9]+"))
            Telefonnummer=t;
        else
            return a;
        return null;
    }
    
    //Set Methode für den zuständigen Arzt
    public void SetZuständigerArzt(String z)
    {
        ZuständigerArzt=z;
    }
    
    //Set Methode für die Blutgruppe des Patienten
    public void SetBlutgruppe(String b)
    {
                Blutgruppe=b;
    }
    
    //Set Methode für das Geschlecht des Patienten
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
    
    //Set Methode für die Adresse des Patienten
    public void SetAdresse(String ad)
    {
        Adresse=ad;
    }
    
    //Set Methode für das Alter des Patienten
    public String SetAlter(String A)
    {
        String a="Bitte geben Sie eine Nummer ein.";
        if(A.matches("[0-9]+"))
            Alter=A;
        else
            return a;
        return null;
    }
    
    //Set Methode für den Patienten Namen
    public void SetName(String N)
    {
        Name=N;
    }
    
    //Set Methode für die Krankenkassen Nummer
    public String SetKrankenkassenNr(String nr)
    {
       String a="Bitte geben Sie eine Nummer ein.";
        if(nr.matches("[0-9]+"))
            KrankenkassenNr=nr;
       else
            return a;
       return null;
    }
    
    //Get Methode für KrankenkassenNr
    public String getKrankenkassenNr ()
    {
        return KrankenkassenNr;
    }
    
    //Get Methode für Name
    public String getName ()
    {
        return Name;
    }
    
    //Get Methode für Alter
    public String getAlter ()
    {
        return Alter;
    }
    
    //Get Methode für Geschlecht
    public String getGeschlecht ()
    {
        return Geschlecht;
    }
    
    //Get Methode für Adresse
    public String getAdresse ()
    {
        return Adresse;
    }
    
    //Get Methode für Blutgruppe
    public String getBlutgruppe ()
    {
        return Blutgruppe;
    }
    
    //Get Methode für ZuständigerArzt
    public String getZuständigerArzt ()
    {
        return ZuständigerArzt;
    }
    
    //Get Methode für Telefonnummer
    public String getTelefonnummer ()
    {
        return Telefonnummer;
    }
    
    //Get Methode für Vorerkrankungen
    public String getVorerkrankungen ()
    {
        return Vorerkrankungen;
    }
    
    //Get Methode für Allergien
    public String getAllergien()
    {
        return Allergien;
    }
    
    //Get Methode für ArrayList der AnalyseBerichte
    public ArrayList <Analysebericht> getAnalysebericht()
    {
        return Analyseberichte;
    }
    
    //Get Methode für ArrayList der Notfallkontakte
    public ArrayList <Notfallkontakt> getNotfallkontakte()
    {
        return Notfallkontakte;
    }

    //ändert die Werte einer bereits vorhandenen Patientenakte auf die neu 
    //eingegebenen Werte
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
        if(!gefunden)//System out print durch exeptions ersetzen für oberfläche
            System.out.print("Keinen Analysebericht gefunden der "+gesucht+" enthält");
        return null;
    }

    //Methode zum exportieren der Werte in eine Datei.
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

    //entfernt den Analysebericht der die eingegebene Nummer besitzt.
    public void Analyseberichtlöschen(String Nummer)
    {
        Iterator<Analysebericht> it1 = Analyseberichte.iterator();
        boolean gelöscht=false;
        int i=0;
        while(!gelöscht&& it1.hasNext())
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
                    System.out.println("Datei konnte nicht gelöscht werden");
                }
                else
                {
                    System.out.println("Datei wurde gelöscht");
                    System.out.print("Der Analysebericht mit der Nummer: "+Nummer+" wurde erfolgreich gelöscht.");
                    gelöscht=true;
                }
            }
            i++;
        }
        
        if(gelöscht == false)
        {
        System.out.print("Es wurde kein Analysebericht mit der Nummer: "+Nummer+" zum löschen gefunden.");
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
    String tel)
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
