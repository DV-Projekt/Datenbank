
/**
 * Verwalter der Akten. Er enthällt alle Akten. 
 * Somit kann er auf diese Akten zugreifen, sie aufrufen und löschen.
 *
 * @author (Angelika Jouperina)
 * @version (0.0.9)
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
     */
    public Verwalter (String Name, String Alter, String Addresse, 
    String Geschlecht, String KrankenkassenNr, String Blutgruppe, 
    String Arzt, String Telefonnummer, String Vorerkrankungen, String Allergien)
    {
        Akten = new ArrayList <Patientenakte> ();        
        Patientenakte Akte = new Patientenakte (Name,Alter,Addresse,Geschlecht,
                KrankenkassenNr,Blutgruppe,Arzt, Telefonnummer, Vorerkrankungen,Allergien);
        Akten.add(Akte);
    }

    public Verwalter (Patientenakte a)
    {
        Akten = new ArrayList <Patientenakte> ();  
        Akten.add(a);
    }

    /**
     * Get Methode für die ArrayList
     * 
     * @param keiner
     * @return ArrayList "Akten"
     */ 
    public ArrayList <Patientenakte> getArrayList ()
    {
        return Akten;
    }

    /**
     * Akteanlegen: Methode die eine neue Patientenakte anlegt und diese der ArrayList
     * hinzufügt
     * 
     * @param Name,Alter,Addresse,Geschlecht,KrankenkassenNr,Blutgruppe,
     * Arzt,Telefonnummer,Vorerkrankungen,Allergien
     * @throws IllegalArgumentException wenn die KrankenkassenNr übereinstimmen
     * @return keiner
     */
    public String Akteanlegen (String Name, String Alter, String Addresse, 
    String Geschlecht, String KrankenkassenNr, String Blutgruppe, 
    String Arzt, String Telefonnummer, String Vorerkrankungen, String Allergien)
    {
        Patientenakte Akte = new Patientenakte (Name,Alter,Addresse,Geschlecht,
                KrankenkassenNr,Blutgruppe,Arzt, Telefonnummer, Vorerkrankungen,Allergien);

        Patientenakte ak = Aktesuchen (KrankenkassenNr);
        if (ak != null)
        {
            throw new IllegalArgumentException("Diese Akte gibt es schon!");
        }

        if (ak == null)
        {
            Akten.add(Akte);
            return "Akte wurde hinzugefügt!";
        }

        return "";
    }

    /**
     * Aktelöschen: Methode die eine Akte sucht und dannach diese aus der
     * ArrayList entfernt
     * @throws IllegalArgumentException wenn die KrankenkassenNr nicht übereinstimmen
     * 
     * @param KrankenkassenNr
     * @return keiner
     */

    public String Aktelöschen (String KrankenkassenNr)
    {
        Patientenakte ak = Aktesuchen (KrankenkassenNr);
        if (ak != null)
        {
            Akten.remove(ak);
            return "Akte wurde erfolgreich gelöscht!";
        }

        if (ak == null)
        {
            throw new IllegalArgumentException("Keine Akte gefunden");
        }
        return "";
    }

    /**
     * Aktesuchen: Methode die eine Akte nach der Krankenkassennummer sucht
     * 
     * @param KrankenkassenNummer
     * @return Patientenakte
     */

    public Patientenakte Aktesuchen (String KrankenkassenNr)
    {
        for (Patientenakte c : Akten)
        {
            if (c.getKrankenkassenNr().equals(KrankenkassenNr))
            {
                return c;
            }
            // else
            // {
            // throw new IllegalArgumentException("Keine Akte gefunden");
            // }
        }

        return null;
    }
    
    /**
     * Exportieren: Methode die eine Patientenakte mit allen ihren Analyseberichten in eine Exeltabelle exportiert
     * 
     * @param KrankenkassenNr, Filename
     * @throws IllegalArgumentException wenn keine Akte gefunde wurde
     * 
     */
    public void Exportieren (String KrankenkassenNr, String Filename)
    {
        Patientenakte ob = Aktesuchen (KrankenkassenNr);
        if (ob == null)
        {
            throw new IllegalArgumentException("Keine Akte gefunden");
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
            String filename = "C:\\ChemischeAnalysedatenbank\\PatientenakteMitAnalyseberichten"+ System.getProperty("file.separator") + Filename + ".xlsx";

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Patientenakte mit Analyseberichte");

            String[][] werte = new String [][]{{"Name", "Alter", "Addresse","Geschlecht", 
                        "KrankenkassenNr", "Blutgruppe", "ZuständigerArzt", "Telefonnummer",
                        "Vorerkrankungen", "Allergien"},
                    {ob.getName(),ob.getAlter(),ob.getAdresse(),ob.getGeschlecht(),ob.getKrankenkassenNr(),ob.getBlutgruppe(),ob.getZuständigerArzt(),
                        ob.getTelefonnummer(),ob.getVorerkrankungen(),ob.getAllergien() }};

            int rowNum =0;

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

            try {
                FileOutputStream outputStream = new FileOutputStream(filename);
                workbook.write(outputStream);
                workbook.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }

    }
}
