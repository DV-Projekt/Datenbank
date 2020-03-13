/**
 * Beschreiben Sie hier die Klasse Analysebericht.
 * 
 * @author Nicolas Pfaff 
 * @version 0.0.12
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
    int BerichtNR;

    /**
     * Der Konstruktor der Klasse Analysebericht erstellt einen neuen Analysebericht. 
     * Dabei werden die Daten Laborant, Labor, Analyseobjekt, Analysemethode und Analyseergebnis durch Parameter übergeben.
     * Das aktuelle Datum wird durch die Klasse Calendar erzeugt.
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
        BerichtNR = (int) (Math.random()*((1000-1)+1))+1;
    }

    public void Analyseberichtbearbeiten(String Laborantenkuerzel, String Erstellungsdatum, String Laborname, String AnalyseObjekt, String Analysemethode, String Analyseergebnis)
    {
        this.Laborantenkuerzel = Laborantenkuerzel;
        this.Analysedatum = Erstellungsdatum;
        this.Laborname = Laborname;
        this.AnalyseObjekt = AnalyseObjekt;
        this.Analysemethode = Analysemethode;
        this.Analyseergebnis = Analyseergebnis;
    }

    public void Berichtexportieren(String Filename)
    {
        Path f = Paths.get("C:\\ChemischeAnalysedatenbank\\Analyseberichte");
        if (!Files.exists(f)) {
            try {
                Files.createDirectories(f);
            } catch (IOException e) {
                e.printStackTrace();    
            }
        }
        String filename = "C:\\ChemischeAnalysedatenbank\\Analyseberichte"+ System.getProperty("file.separator") + BerichtNR + Filename + ".xlsx";

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Analysebericht "+Analysedatum);

        String[][] werte = new String [][]{{"Bericht NR", "Laborantenkuerzel", "Analysedatum","Laborname", "Analyseobjekt", "Analysemethode", "Analyseergebnis"},
                {Integer.toString(BerichtNR), Laborantenkuerzel, Analysedatum, Laborname, AnalyseObjekt,Analysemethode, Analyseergebnis}};

        int rowNum =0;
        System.out.println("Dokument wird erstellt");

        for (int i=0; i<2; i++) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (int j=0; j<7; j++) {
                Cell cell = row.createCell(colNum++);
                cell.setCellValue(werte[i][j]);
            }
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

        System.out.println("Bericht wurde exportiert");

    }

    public String getLaborantenkuerzel()
    {
        return Laborantenkuerzel;
    }

    public String getLaborname()
    {
        return Laborname;
    }

    public String getAnalyseObjekt()
    {
        return AnalyseObjekt;
    }

    public String getAnalysemethode()
    {
        return Analysemethode;
    }

    public String getAnalyseergebnis()
    {
        return Analyseergebnis;
    }

    public String getAnalysedatum()
    {
        return Analysedatum;
    }

    public int getBerichtNR()
    {
        return BerichtNR;
    }

    // public void löscheBericht(int nummer )
    // {
        // File f = new File("C:/ChemischeAnalysedatenbank/Analyseberichte");
        // File[] fileArray = f.listFiles();
        // boolean r = false;
        // for(int i = 0; i<fileArray.length; i++)
        // {
            // String name = fileArray[i].getName();
            // System.out.println(name);
            // String n = Integer.toString(nummer);
            // System.out.println(n);
            // if(name.contains(n))
            // {
                // File d = new File("C:/ChemischeAnalysedatenbank/Analyseberichte/"+name);
                // d.delete();
                // r= true;
            // }
        // }

        // if(r==false)
        // {
            // System.out.println("Datei konnte nicht gelöscht werden");
        // }
        // else
        // {
            // System.out.println("Datei wurde gelöscht");
        // }
    //}
}

