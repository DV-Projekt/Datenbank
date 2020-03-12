/**
 * Beschreiben Sie hier die Klasse Analysebericht.
 * 
 * @author Nicolas Pfaff 
 * @version 0.0.8
 */

import java.util.*;
import java.io.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.commons.collections4.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Analysebericht
{
    String Laborantenkuerzel;
    String Analysedatum;
    String Laborname;
    String AnalyseObjekt;
    String Analysemethode;
    String Analyseergebnis;

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
        Analysedatum = date.get(Calendar.DAY_OF_MONTH ) + "." + (date.get(Calendar.MONTH) + 1 ) + "." + date.get(Calendar.YEAR);
        this.Laborname = Laborname;
        this.AnalyseObjekt = AnalyseObjekt;
        this.Analysemethode = Analysemethode;
        this.Analyseergebnis = Analyseergebnis;
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
        File f = new File("C:\\ChemischeAnalysedatenbank");
        if (f.mkdir()) {
            System.out.println("");
        } else {
            System.out.println("Ordner konnte nicht erstellt werden ");
        }

        String filename = "C:\\ChemischeAnalysedatenbank"+ System.getProperty("file.separator") + Filename+".xlsx";

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Analysebericht "+Analysedatum);

        String[][] werte = new String [][]{{"Laborantenkuerzel", "Analysedatum","Laborname", "Analyseobjekt", "Analysemethode", "Analyseergebnis"},
                {Laborantenkuerzel, Analysedatum, Laborname, AnalyseObjekt,Analysemethode, Analyseergebnis}};

        int rowNum =0;
        System.out.println("Dokument wird erstellt");

        for (int i=0; i<2; i++) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (int j=0; j<6; j++) {
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
}

