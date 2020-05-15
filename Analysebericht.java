/**
 * Die Klasse Analysebericht ist verantwortlich für die Erstellung der Analyseberichte.
 * Außerdem können die Analyseberichte bearbeitet und als xlsx-File exportiert werden
 * 
 * @author Nicolas Pfaff 
 * @version 1.0
 * 
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

public class Analysebericht
{
    String Laborantenkuerzel;
    String Analysedatum;
    String Laborname;
    String AnalyseObjekt;
    String Analysemethode;
    String Analyseergebnis;
    String BerichtNR;

    /**
     * Der Konstruktor der Klasse Analysebericht erstellt einen neuen Analysebericht. 
     * Dabei werden die Daten Laborant, Analysedatum, Laborname, Analyseobjekt, Analysemethode und Analyseergebnis als Parameter übergeben.
     * Die Berichtnummer wird zufällig erstellt.
     * 
     * @param Laborantenkuerzel
     * @param Analysedatum
     * @param Laborname
     * @param AnalyseObjekt
     * @param Analysemethode
     * @param Analyseergebnis
     */

    public Analysebericht(String Laborantenkuerzel, String Analysedatum, String Laborname, String AnalyseObjekt, String Analysemethode, String Analyseergebnis)
    {
        this.Laborantenkuerzel = Laborantenkuerzel;
        this.Analysedatum = Analysedatum;
        this.Laborname = Laborname;
        this.AnalyseObjekt = AnalyseObjekt;
        this.Analysemethode = Analysemethode;
        this.Analyseergebnis = Analyseergebnis;
        int nr = (int) (Math.random()*(10000-1)+1);
        BerichtNR = Integer.toString(nr);
    }

    /**
     * Der Konstruktor der Klasse Analysebericht erstellt einen neuen Analysebericht. 
     * Dabei werden die Daten Laborant, Laborname, Analyseobjekt, Analysemethode und Analyseergebnis durch Parameter übergeben.
     * Das aktuelle Datum wird durch die Klasse Calendar erzeugt und es wird eine zufällige Berichtnummer erstellt.
     * 
     * @param Laborantenkuerzel
     * @param Laborname
     * @param AnalyseObjekt
     * @param Analysemethode
     * @param Analyseergebnis
     */
    public Analysebericht(String Laborantenkuerzel, String Laborname, String AnalyseObjekt, String Analysemethode, String Analyseergebnis)
    {
        this.Laborantenkuerzel = Laborantenkuerzel;
        Calendar date = Calendar.getInstance();
        Analysedatum = date.get(Calendar.MONTH) + "-" + (date.get(Calendar.DAY_OF_MONTH) + 1 ) + "-" + date.get(Calendar.YEAR);
        this.Laborname = Laborname;
        this.AnalyseObjekt = AnalyseObjekt;
        this.Analysemethode = Analysemethode;
        this.Analyseergebnis = Analyseergebnis;
        int nr = (int) (Math.random()*(10000-1)+1);
        BerichtNR = Integer.toString(nr);
    }

    /**
     * Der Standardkonstruktor der Klasse Analysebericht erstellt einen neuen Analysebericht mit den vorgegebenen Werten für die Attribute und einer zufälligen Berichtnummer. 
     * Das aktuelle Datum wird durch die Klasse Calendar erzeugt.
     * 
     */
    public Analysebericht()
    {
        Laborantenkuerzel = "Frau Tschan";
        Calendar date = Calendar.getInstance();
        Analysedatum = date.get(Calendar.MONTH) + "-" + (date.get(Calendar.DAY_OF_MONTH) + 1 ) + "-" + date.get(Calendar.YEAR);
        Laborname = "HFU";
        AnalyseObjekt = "Blut";
        Analysemethode = "Gelelektrophorese";
        Analyseergebnis = "Funktioniert";
        int nr = (int) (Math.random()*(10000-1)+1);
        BerichtNR = Integer.toString(nr);
    }

    /**
     * Die Methode Analyseberichtbearbeiten setzt die Attribute beim Aufruf auf die eingegebenen String Parameter.
     * 
     * @param Laborantenkuerzel
     * @param Erstellungsdatum
     * @param Laborname
     * @param AnalyseObjekt
     * @param Analysemethode
     * @param Analyseergebnis
     */
    public void Analyseberichtbearbeiten(String Laborantenkuerzel, String Erstellungsdatum, String Laborname, String AnalyseObjekt, String Analysemethode, String Analyseergebnis)
    {
        this.Laborantenkuerzel = Laborantenkuerzel;
        this.Analysedatum = Erstellungsdatum;
        this.Laborname = Laborname;
        this.AnalyseObjekt = AnalyseObjekt;
        this.Analysemethode = Analysemethode;
        this.Analyseergebnis = Analyseergebnis;
    }

    /**
     * Die Methode Berichtexportieren erzeugt beim Aufruf eine xlsx-Datei (Excel-Datei), in denen alle Attribute und ihre zugehörigen Werte abgespeichert werden.
     * Dazu wird ein frei wählbarer Filename (übergeben durch den Parameter Filename) und die Berichtnummer als Dateiname gewählt. Die Berichtnummer gewährleistet, 
     * dass jeder exportierte Bericht eindeutig identifiziert werden kann. Falls noch nicht vorhanden, erstellt die Methode einen Ordner ChemischeAnalysedatenbank 
     * und einen Unterordner Analyseberichte, in dem alle Berichte abgespeichert werden.
     * 
     * @param Filename
     */
    public void Berichtexportieren(String Filename)
    {
        Path f = Paths.get("C:\\ChemischeAnalysedatenbank\\Analyseberichte");
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
        String filename = "C:\\ChemischeAnalysedatenbank\\Analyseberichte"+ System.getProperty("file.separator")+ BerichtNR + Filename + ".xlsx";

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Analysebericht "+Analysedatum);

        String[][] werte = new String [][]{{"Bericht NR", "Laborantenkuerzel", "Analysedatum","Laborname", "Analyseobjekt", "Analysemethode", "Analyseergebnis"},
                {BerichtNR, Laborantenkuerzel, Analysedatum, Laborname, AnalyseObjekt,Analysemethode, Analyseergebnis}};

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
    
    public void Berichtexportieren2(String Dateipfad)
    {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Analysebericht "+Analysedatum);

        String[][] werte = new String [][]{{"Bericht NR", "Laborantenkuerzel", "Analysedatum","Laborname", "Analyseobjekt", "Analysemethode", "Analyseergebnis"},
                {BerichtNR, Laborantenkuerzel, Analysedatum, Laborname, AnalyseObjekt,Analysemethode, Analyseergebnis}};

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
            FileOutputStream outputStream = new FileOutputStream(Dateipfad);
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
    /**
     * Get-Methode für Laborantenkuerzel
     * 
     * @return Laborantenkuerzel
     */
    public String getLaborantenkuerzel()
    {
        return Laborantenkuerzel;
    }

    /**
     * Get-Methode für Laborname
     * 
     * @return Laborname
     */
    public String getLaborname()
    {
        return Laborname;
    }

    /**
     * Get-Methode für AnalyseObjekt
     * 
     * @return AnalyseObjekt
     */
    public String getAnalyseObjekt()
    {
        return AnalyseObjekt;
    }

    /**
     * Get-Methode für Analysemethode
     * 
     * @return Analysemethode
     */
    public String getAnalysemethode()
    {
        return Analysemethode;
    }

    /**
     * Get-Methode für Analyseergebnis
     * 
     * @return Analyseergebnis
     */
    public String getAnalyseergebnis()
    {
        return Analyseergebnis;
    }

    /**
     * Get-Methode für Analysedatum
     * 
     * @return Analysedatum
     */
    public String getAnalysedatum()
    {
        return Analysedatum;
    }

    /**
     * Get-Methode für BerichtNR
     * 
     * @return BerichtNR
     */
    public String getBerichtNR()
    {
        return BerichtNR;
    }

    /**
     * Set-Methode für Laborantenkuerzel
     * 
     * @param Laborantenkuerzel
     */
    public void setLaborantenkuerzel(String Laborantenkuerzel)
    {
        this.Laborantenkuerzel = Laborantenkuerzel; 
    }

    /**
     * Set-Methode für Analysedatum
     * 
     * @param Analysedatum
     */
    public void setAnalysedatum(String Analysedatum)
    {
        this.Analysedatum = Analysedatum; 
    }

    /**
     * Set-Methode für Laborname
     * 
     * @param Laborname
     */
    public void setLaborname(String Laborname)
    {
        this.Laborname = Laborname;

    }

    /**
     * Set-Methode für AnalyseObjekt
     * 
     * @param AnalyseObjekt
     */
    public void setAnalyseObjekt(String AnalyseObjekt)
    {
        this.AnalyseObjekt = AnalyseObjekt; 
    }

    /**
     * Set-Methode für Analysemethode
     * 
     * @param Analysemethode
     */
    public void setAnalysemethode(String Analysemethode)
    {
        this.Analysemethode = Analysemethode; 
    }

    /**
     * Set-Methode für Analyseergebnis
     * 
     * @param Analyseergebnis
     */
    public void setAnalyseergebnis(String Analyseergebnis)
    {
        this.Analyseergebnis = Analyseergebnis; 
    }

    /**
     * Set-Methode für BerichtNR
     * 
     * @param BerichtNR
     */
    public void setBerichtNR(String BerichtNR)
    {
        this.BerichtNR = BerichtNR;
    }
}

