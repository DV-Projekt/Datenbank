
/**
 * Verwalter der Patientenakten. Er enthällt alle Patientenakten. 
 * Somit kann er auf diese Patientenakten zugreifen, sie aufrufen und löschen.
 *
 * @author (Angelika Jouperina)
 * @version (0.0.13)
 */
import java.util.ArrayList;
import java.io.File;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.commons.collections4.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;

public class Verwalter
{
    public ArrayList <Patientenakte> Akten;

    /**
     * Konstruktor der eine Leere ArrayList der Patientenakten erstellt
     */
    public Verwalter ()
    {
        Akten = new ArrayList <Patientenakte> ();
    }

    /**
     * Konstruktor der die ArrayList der Patientenakten erstellt 
     * und zusätzlich eine Patientenakte erstellt und hinzufügt
     * @param Name
     * @param Alter
     * @param Adresse
     * @param Geschlecht
     * @param KrankenkassenNr
     * @param Blutgruppe
     * @param Arzt
     * @param Telefonnummer
     * @param Vorerkrankungen
     * @param Allergien
     */
    public Verwalter (String Name, String Alter, String Adresse, 
    String Geschlecht, String KrankenkassenNr, String Blutgruppe, 
    String Arzt, String Telefonnummer, String Vorerkrankungen, String Allergien)
    {
        Akten = new ArrayList <Patientenakte> ();        
        Patientenakte Akte = new Patientenakte (Name,Alter,Adresse,Geschlecht,
                KrankenkassenNr,Blutgruppe,Arzt,Telefonnummer,Vorerkrankungen,Allergien);
        Akten.add(Akte);
    }

    /**
     * Konstruktor der die ArrayList der Patientenakten erstellt
     * und der man eine schon erstellte Patientenakte übergibt
     * @param Patientenakte a
     */ 
    public Verwalter (Patientenakte a)
    {
        Akten = new ArrayList <Patientenakte> ();  
        Akten.add(a);
    }

    /**
     * Get Methode für die ArrayList
     * 
     * @param -
     * @return ArrayList "Akten"
     */ 
    public ArrayList <Patientenakte> getArrayList ()
    {
        return Akten;
    }

    /**
     * Akteanlegen: Methode die eine neue Patientenakte anlegt und diese der ArrayList
     * hinzufügt dabei wird überprüft, ob diese schon exsistiert
     * @throws IllegalArgumentException wenn die Krankenkassennummern übereinstimmen und es somit schon so eine Patientenakte gib
     * 
     * @param Name
     * @param Alter
     * @param Adresse
     * @param Geschlecht
     * @param KrankenkassenNr
     * @param Blutgruppe
     * @param Arzt
     * @param Telefonnummer
     * @param Vorerkrankungen
     * @param Allergien
     * @return hinzu (String)
     */
    public String Akteanlegen (String Name, String Alter, String Adresse, 
    String Geschlecht, String KrankenkassenNr, String Blutgruppe,
    String Arzt, String Telefonnummer, String Vorerkrankungen, String Allergien)
    {
        Patientenakte Akte = new Patientenakte (Name,Alter,Adresse,Geschlecht,
                KrankenkassenNr,Blutgruppe,Arzt, Telefonnummer, Vorerkrankungen,Allergien);

        Patientenakte ak = Aktesuchen (KrankenkassenNr);
        if (ak != null)
        {
            throw new IllegalArgumentException("Diese Akte gibt es schon!");
        }
        else
        {
            Akten.add(Akte);
            String hinzu = "Akte wurde hinzugefügt!";
            return hinzu;
        }
    }

    /**
     * Aktelöschen: Methode die eine Akte sucht und dannach diese aus der
     * ArrayList entfernt und auch deren exportierte Datei falls vorhanden
     * @throws IllegalArgumentException wenn die Krankenkassennummern nicht übereinstimmen
     * 
     * @param KrankenkassenNr
     * @return gelöscht (String)
     */

    public String Aktelöschen (String KrankenkassenNr)
    {
        Patientenakte ak = Aktesuchen (KrankenkassenNr);
        if (ak != null)
        {
            Akten.remove(ak);

            try{
                File f = new File("C://ChemischeAnalysedatenbank//PatientenakteMitAnalyseberichten");
                File[] fileArray = f.listFiles();
                if(fileArray.length != 0)
                {
                    for(File v : fileArray)
                    {
                        String name = v.getName();
                        if(name.contains(KrankenkassenNr))
                        {
                            File d = new File("C://ChemischeAnalysedatenbank//PatientenakteMitAnalyseberichten//"+ name);
                            d.delete();
                        }
                    }
                }

                File o = new File("C://ChemischeAnalysedatenbank//Patientenakten");
                File[] fileArray2 = o.listFiles();
                if(fileArray2.length != 0)
                {
                    for(File v : fileArray2)
                    {
                        String name = v.getName();
                        if(name.contains(KrankenkassenNr))
                        {
                            File d = new File("C://ChemischeAnalysedatenbank//Patientenakten//"+ name);
                            d.delete();
                        }
                    }
                }
            }catch (NullPointerException e)
            {
                e.printStackTrace();
            }
            String gelöscht = "Akte wurde erfolgreich gelöscht!";
            return gelöscht;
        }
        else
        {
            throw new IllegalArgumentException("Es wurde keine Akte gefunden die die Nummer "+KrankenkassenNr+" enthällt!");
        }
    }

    /**
     * Aktesuchen: Methode die eine Akte nach der Krankenkassennummer sucht
     * 
     * @param KrankenkassenNummer
     * @return Patientenakte c
     */

    public Patientenakte Aktesuchen (String KrankenkassenNr)
    {
        for (Patientenakte c : Akten)
        {
             if (c.getKrankenkassenNr().equals(KrankenkassenNr))
            {
                return c;
            }
        }

        return null;
    }

    /**
     * Exportieren: Methode die eine Patientenakte mit allen ihren Analyseberichten in eine Exeltabelle exportiert
     * @throws IllegalArgumentException wenn keine Akte gefunde wurde
     * 
     * @param KrankenkassenNr
     * @param Filename
     * @return -
     */
    public void Exportieren (String KrankenkassenNr, String Filename)
    {
        Patientenakte ob = Aktesuchen (KrankenkassenNr);
        if (ob == null)
        {
            throw new IllegalArgumentException("Es wurde keine Akte gefunden die diese Nummer enthällt!");
        }
        else 
        {
            Path f = Paths.get("C:\\ChemischeAnalysedatenbank\\PatientenakteMitAnalyseberichten");
            if (!Files.exists(f)) {
                try {
                    Files.createDirectories(f);
                } catch (IOException e) {
                    e.printStackTrace();    
                }
            }
            String filename = "C:\\ChemischeAnalysedatenbank\\PatientenakteMitAnalyseberichten"+ System.getProperty("file.separator") + KrankenkassenNr+Filename +".xlsx";

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Patientenakte mit Analyseberichte");

            String[][] werte = new String [][]{{"Name", "Alter", "Addresse","Geschlecht", 
                        "KrankenkassenNr", "Blutgruppe", "ZuständigerArzt", "Telefonnummer",
                        "Vorerkrankungen", "Allergien"},
                    {ob.getName(),ob.getAlter(),ob.getAdresse(),ob.getGeschlecht(),ob.getKrankenkassenNr(),ob.getBlutgruppe(),ob.getZuständigerArzt(),
                        ob.getTelefonnummer(),ob.getVorerkrankungen(),ob.getAllergien() }};

            int rowNum =0;

            try{
                for (int i=0; i < 2 ; i++) {
                    Row row = sheet.createRow(rowNum++);
                    int colNum = 0;
                    for (int j=0; j< werte[0].length ; j++) {
                        Cell cell = row.createCell(colNum++);
                        cell.setCellValue(werte[i][j]);
                    }
                }

                ArrayList <Analysebericht> bericht = new ArrayList <Analysebericht> ();

                int rowNum2 = rowNum+2;

                for (Analysebericht b: ob.getAnalysebericht ())
                {
                    bericht.add(b);
                }            

                for ( int c=0; c< bericht.size(); c++)
                {
                    Analysebericht ber = bericht.get(c); 

                    String[][] werte2 = new String [][] {{"Bericht NR", "Laborantenkuerzel", "Analysedatum","Laborname", "Analyseobjekt", "Analysemethode", "Analyseergebnis"},
                            {ber.getBerichtNR(),ber.getLaborantenkuerzel(),ber.getAnalysedatum(),ber.getLaborname(),ber.getAnalyseObjekt(),ber.getAnalysemethode(),ber.getAnalyseergebnis()}};

                    for (int i=0; i < 2 ; i++) {
                        Row row = sheet.createRow(rowNum2++);
                        int colNum = 0;
                        for (int j=0; j< werte2[0].length ; j++) {
                            Cell cell = row.createCell(colNum++);
                            cell.setCellValue(werte2[i][j]);
                        }
                    }
                    rowNum2++;
                }

                FileOutputStream outputStream = new FileOutputStream(filename);
                workbook.write(outputStream);
                workbook.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }

        }

    }
}
