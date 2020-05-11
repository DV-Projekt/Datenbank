
/**
 * Beschreiben Sie hier die Klasse MainWindowController.
 * 
 * @author Nicolas Pfaff, Lennart Burkart
 * @version 0.0.39
 */
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.collections.*;
import javafx.fxml.*;
import java.io.*;
import javafx.scene.control.Alert;
import java.awt.Frame;
import java.util.*;
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
import java.text.*;
import java.time.format.*;
import java.time.*;

public class MainWindowController extends Verwalter
{
    //Views
    @FXML 
    private Label labelstart;

    @FXML 
    private TextField name;

    @FXML 
    private TextField alter;

    @FXML 
    private TextField adresse;

    @FXML 
    private TextField geschlecht;

    @FXML 
    private TextField krankenkassennummer1;

    @FXML 
    private TextField blutgruppe;

    @FXML 
    private TextField arzt;

    @FXML 
    private TextField telefonnummer;

    @FXML 
    private TextArea vorerkrankungen;

    @FXML 
    private TextArea allergien;

    @FXML 
    private Text krankenkassennummer;

    @FXML 
    private TextField eingabefeldsuche;

    @FXML 
    private MenuBar menuBar;

    @FXML 
    private Menu datei;

    @FXML 
    private Menu help;

    @FXML 
    private MenuItem anlegen;

    @FXML 
    private MenuItem about;

    @FXML
    private Alert alert1;

    @FXML 
    private TextField ausgabename;

    @FXML 
    private TextField ausgabealter;

    @FXML 
    private TextField ausgabeadresse;

    @FXML 
    private TextField ausgabegeschlecht;

    @FXML 
    private TextField auskrankenkassennummer1;

    @FXML 
    private TextField ausgabeblutgruppe;

    @FXML 
    private TextField ausgabearzt;

    @FXML 
    private TextField ausgabetelefonnummer;

    @FXML 
    private TextArea ausgabevorerkrankungen;

    @FXML 
    private TextArea ausgabeallergien;

    @FXML 
    private TextField laborantenkuerzel;

    @FXML 
    private DatePicker analysedatum;

    @FXML 
    private TextField laborname;

    @FXML 
    private TextArea analyseobjekt;

    @FXML 
    private TextArea analysemethode;

    @FXML 
    private TextArea analyseergebnis;

    @FXML
    private Button speichernbutton;

    @FXML
    private TextField notfallname;

    @FXML
    private TextField notfalladresse;

    @FXML
    private TextField notfallbeziehung;

    @FXML
    private TextField notfalltelefonnummer;

    @FXML
    private TextField notfallblutgruppe;

    @FXML
    private TextField analyseberichtnummer;

    @FXML
    private Label BerichtNR;

    @FXML
    private TextField laborantenkuerzelanzeige;

    @FXML
    private DatePicker analysedatumanzeige;

    @FXML
    private TextField labornameanzeige;

    @FXML
    private TextArea analyseobjektanzeige;

    @FXML
    private TextArea analysemethodeanzeige;

    @FXML
    private TextArea analyseergebnisanzeige;

    @FXML
    private TextField notfallnameanzeige;

    @FXML
    private TextField notfalladresseanzeige;

    @FXML
    private TextField notfallbeziehunganzeige;

    @FXML
    private TextField notfalltelefonnummeranzeige;

    @FXML
    private TextField notfallblutgruppeanzeige;

    @FXML
    private Button speichernbuttonanalysebericht;

    @FXML
    private Button Notfallkontaktspeicherbutton;

    @FXML
    private TextField analyseberichtsuchenfeld;

    @FXML
    private TextField Notfallkontaktsuchenfeld;

    @FXML 
    private ListView listanalyseberichte;

    @FXML 
    private ListView listNotfallkontakte;

    @FXML
    private Button anzeigebutton;

    public Main main;
    public void setMain(Main main)
    {
        this.main = main;
    }

    public static boolean isLetter(String s)
    {
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(Character.isLetter(c)||c==' ')
                continue;
        return false;   
        }
        return true;
    }
    
    @FXML
    public void Notfallkontakterstellen()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("notfallkontakt.fxml"));
            VBox pane = loader.load();

            MainWindowController mainWindowController = loader.getController();
            mainWindowController.setMain(main);

            Scene scene = new Scene(pane);
            Main.primaryStage.setScene(scene);
            Main.primaryStage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void suche()
    {   
        String eingabe = eingabefeldsuche.getText();

        if(eingabefeldsuche.getText() == null || eingabefeldsuche.getText().trim().isEmpty())
        {
            warningDaten();
        }

        else if(verwalter.Akten.size()==0)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Achtung");
            alert.setHeaderText("Keine Akten vorhanden!");
            alert.setContentText("Bitte Akte anlegen");

            alert.showAndWait();
            eingabefeldsuche.clear();
        }

        else if(verwalter.Aktesuchen(eingabe) == null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Achtung");
            alert.setHeaderText("Eingegebene Nummer existiert im System nicht!");
            alert.setContentText("Bitte Akte anlegen");

            alert.showAndWait();
            eingabefeldsuche.clear();
        }
        else
        {
            if(p==null)
            {
                p = new Patientenakte(verwalter.Aktesuchen(eingabe).getName(), verwalter.Aktesuchen(eingabe).getAlter(), verwalter.Aktesuchen(eingabe).getAdresse(), 
                    verwalter.Aktesuchen(eingabe).getGeschlecht(), verwalter.Aktesuchen(eingabe).getKrankenkassenNr(), verwalter.Aktesuchen(eingabe).getBlutgruppe(), 
                    verwalter.Aktesuchen(eingabe).getZuständigerArzt(), verwalter.Aktesuchen(eingabe).getTelefonnummer(), verwalter.Aktesuchen(eingabe).getVorerkrankungen(), 
                    verwalter.Aktesuchen(eingabe).getAllergien());
            }
            else
            {
                p = verwalter.Aktesuchen(eingabe);
            }
            try{
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("patientenakte.fxml"));
                VBox pane = loader.load();

                MainWindowController mainWindowController = loader.getController();
                setMain(main);

                Scene scene = new Scene(pane);
                main.primaryStage.setScene(scene);
                main.primaryStage.show();

                mainWindowController.ausgabename.setText(p.getName());
                mainWindowController.ausgabealter.setText(p.getAlter());
                mainWindowController.ausgabeadresse.setText(p.getAdresse());
                mainWindowController.ausgabegeschlecht.setText(p.getGeschlecht());
                mainWindowController.auskrankenkassennummer1.setText(p.getKrankenkassenNr());
                mainWindowController.ausgabeblutgruppe.setText(p.getBlutgruppe());
                mainWindowController.ausgabearzt.setText(p.getZuständigerArzt());
                mainWindowController.ausgabetelefonnummer.setText(p.getTelefonnummer());
                mainWindowController.ausgabevorerkrankungen.setText(p.getVorerkrankungen());
                mainWindowController.ausgabeallergien.setText(p.getAllergien());
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

    }

    @FXML
    public void akteanlegen()
    {
        try{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("secondWindow.fxml"));
            VBox pane = loader.load();

            MainWindowController mainWindowController = loader.getController();
            mainWindowController.setMain(main);

            Scene scene = new Scene(pane);
            Main.primaryStage.setScene(scene);
            Main.primaryStage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void save()
    {
        if(name.getText() == null || name.getText().trim().isEmpty() || alter.getText() == null || alter.getText().trim().isEmpty() || 
        geschlecht.getText() == null || geschlecht.getText().trim().isEmpty() || adresse.getText() == null || adresse.getText().trim().isEmpty() ||
        krankenkassennummer1.getText() == null || krankenkassennummer1.getText().trim().isEmpty() || blutgruppe.getText() == null || 
        blutgruppe.getText().trim().isEmpty() || arzt.getText() == null || arzt.getText().trim().isEmpty() || telefonnummer.getText() == null || 
        telefonnummer.getText().trim().isEmpty() || vorerkrankungen.getText() == null || vorerkrankungen.getText().trim().isEmpty() ||
        allergien.getText() == null || allergien.getText().trim().isEmpty())
        {
            warningDaten(); 
        }
        else
        {
            if(name.getText().replaceAll(" ","").matches("[a-zA-Z]+") && alter.getText().replaceAll(" ","").matches("[0-9]+") && geschlecht.getText().replaceAll(" ","").matches
            ("[a-zA-Z]+") && blutgruppe.getText().replaceAll(" ","").matches("[a-zA-Z]+") && arzt.getText().replaceAll(" ","").matches("[a-zA-Z]+") && telefonnummer.
            getText().replaceAll(" ","").matches("[0-9]+"))
            {
                Patientenakte patient = new Patientenakte(name.getText(), alter.getText(), adresse.getText(), geschlecht.
                        getText(), krankenkassennummer1.getText(), blutgruppe.getText(), arzt.getText(), telefonnummer.getText(),
                        vorerkrankungen.getText(), allergien.getText());

                verwalter.Akten.add(patient);

                try 
                {
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainWindow.fxml"));
                    AnchorPane pane = loader.load();

                    MainWindowController mainWindowController = loader.getController();
                    mainWindowController.setMain(main);

                    Scene scene = new Scene(pane);
                    Main.primaryStage.setScene(scene);
                    Main.primaryStage.show();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }   
            }
            else
            {
                if(name.getText().replaceAll(" ","").matches("[a-zA-Z]+")==false)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Achtung");
                    alert.setHeaderText("Falsche Eingabe im Namensfeld!");
                    alert.setContentText("Bitte nur Buchstaben eingeben");

                    alert.showAndWait();
                    name.clear(); 
                }
                else if(alter.getText().replaceAll(" ","").matches("[0-9]+")==false)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Achtung");
                    alert.setHeaderText("Falsche Eingabe im Alterfeld!");
                    alert.setContentText("Bitte nur Zahlen eingeben");

                    alert.showAndWait();
                    alter.clear(); 
                }
                else if(geschlecht.getText().replaceAll(" ","").matches("[a-zA-Z]+")==false)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Achtung");
                    alert.setHeaderText("Falsche Eingabe im Geschlechtfeld!");
                    alert.setContentText("Bitte nur Buchstaben eingeben");

                    alert.showAndWait();
                    geschlecht.clear(); 
                }
                else if(blutgruppe.getText().replaceAll(" ","").matches("[a-zA-Z]+")==false)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Achtung");
                    alert.setHeaderText("Falsche Eingabe im Blutgruppefeld!");
                    alert.setContentText("Bitte nur Buchstaben eingeben");

                    alert.showAndWait();
                    blutgruppe.clear(); 
                }
                else if(arzt.getText().replaceAll(" ","").matches("[a-zA-Z]+")==false)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Achtung");
                    alert.setHeaderText("Falsche Eingabe im Arztfeld!");
                    alert.setContentText("Bitte nur Buchstaben eingeben");

                    alert.showAndWait();
                    arzt.clear(); 
                }
                else if(telefonnummer.getText().replaceAll(" ","").matches("[0-9]+")==false)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Achtung");
                    alert.setHeaderText("Falsche Eingabe im Telefonnummerfeld!");
                    alert.setContentText("Bitte nur Zahlen eingeben");

                    alert.showAndWait();
                    telefonnummer.clear(); 
                }
            }
        }
    }

    public void warningDaten() 
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Achtung");
        alert.setHeaderText("Achtung!");
        alert.setContentText("Bitte Daten eingeben");

        alert.showAndWait();
    }

    @FXML
    public void aktelöschenn()
    {
        String eingabe = eingabefeldsuche.getText();
        if(eingabefeldsuche.getText() == null || eingabefeldsuche.getText().trim().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Achtung");
            alert.setHeaderText("Keine Krankenkassennummer eingegeben!");
            alert.setContentText("Bitte Krankenkassennummer eingeben");

            alert.showAndWait();
            eingabefeldsuche.clear();
        }

        else if(verwalter.Akten.size()==0)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Achtung");
            alert.setHeaderText("Keine Akten vorhanden!");
            alert.setContentText("Bitte Akte anlegen");

            alert.showAndWait();
            eingabefeldsuche.clear();
        }

        else if(verwalter.Aktesuchen(eingabe) == null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Achtung");
            alert.setHeaderText("Eingegebene Nummer existiert im System nicht!");
            alert.setContentText("Bitte Akte anlegen");

            alert.showAndWait();
            eingabefeldsuche.clear();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Achtung");
            alert.setHeaderText("Akte wird unwiderruflich gelöscht");
            alert.setContentText("Bitte bestätigen");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) 
            {
                verwalter.Aktelöschen(eingabe);
            }
            eingabefeldsuche.clear();
        }
    }

    @FXML
    public void analysebanlegen()
    {
        try{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("analysebericht.fxml"));
            VBox pane = loader.load();

            MainWindowController mainWindowController = loader.getController();
            mainWindowController.setMain(main);

            Scene scene = new Scene(pane);
            Main.primaryStage.setScene(scene);
            Main.primaryStage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void patientenakteexportieren()
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

        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Speicherort auswählen");

        filechooser.setInitialDirectory(new File(System.getProperty("user.home")));
        filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Excel (*.xlsx)", "*.xlsx"));
        File file = filechooser.showSaveDialog(Main.primaryStage);

        if (file == null)
        {

        }
        else
        {
            String change = new String(file.getPath());
            p.Exportieren2(change.replaceAll(file.getName(), p.getKrankenkassenNr() + file.getName()));
        }
    }

    @FXML
    public void notfallkontakt()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("notfallkontakt.fxml"));
            VBox pane = loader.load();

            MainWindowController mainWindowController = loader.getController();
            mainWindowController.setMain(main);

            Scene scene = new Scene(pane);
            Main.primaryStage.setScene(scene);
            Main.primaryStage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void analysespeichern()
    {
        if(laborantenkuerzel.getText() == null || laborantenkuerzel.getText().trim().isEmpty() || 
        analysedatum.getValue() == null || analysedatum.getValue().equals("")|| 
        laborname.getText() == null || laborname.getText().trim().isEmpty() || analyseobjekt.getText() == null || 
        analyseobjekt.getText().trim().isEmpty() || analysemethode.getText() == null || 
        analysemethode.getText().trim().isEmpty() || analyseergebnis.getText() == null || 
        analyseergebnis.getText().trim().isEmpty())
        {
            warningDaten(); 
        }
        else
        {
            if(laborantenkuerzel.getText().replaceAll(" ","").matches("[a-zA-Z]+")==false)
            {
                
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Achtung");
                    alert.setHeaderText("Falsche Eingabe bei Laborantenkürzel");
                    alert.setContentText("Bitte nur Buchstaben eingeben");

                    alert.showAndWait();
                    laborantenkuerzel.clear();
               
            }
            else if(laborname.getText().replaceAll(" ","").matches("[a-zA-Z]+")==false)
            {
                
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Achtung");
                    alert.setHeaderText("Falsche Eingabe bei Laborname!");
                    alert.setContentText("Bitte nur Buchstaben eingeben");

                    alert.showAndWait();
                    laborname.clear();
              
            }
            else    
            {
                String nr = p.getKrankenkassenNr();
                verwalter.Aktesuchen(nr).Analyseberichtanlegen(laborantenkuerzel.getText(),analysedatum.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),laborname.getText(), analyseobjekt.getText(), analysemethode.getText(),analyseergebnis.getText());
                p = verwalter.Aktesuchen(nr);
                patientenakteladen();
            }
        }
    }

    @FXML
    public void patientbearbeiten()
    {
        ausgabegeschlecht.setEditable(true);
        ausgabeadresse.setEditable(true);
        ausgabeblutgruppe.setEditable(true);
        ausgabearzt.setEditable(true);
        ausgabevorerkrankungen.setEditable(true);
        ausgabetelefonnummer.setEditable(true);
        ausgabeallergien.setEditable(true);

        speichernbutton.setDisable(false);
    }

    @FXML
    public void speichernpatientenaktebearbeiten()
    {
        if(ausgabename.getText() == null || ausgabename.getText().trim().isEmpty() || ausgabealter.getText() == null || 
        ausgabealter.getText().trim().isEmpty() || ausgabegeschlecht.getText() == null || ausgabegeschlecht.getText().
        trim().isEmpty() || ausgabeadresse.getText() == null || ausgabeadresse.getText().trim().isEmpty() ||
        auskrankenkassennummer1.getText() == null || auskrankenkassennummer1.getText().trim().isEmpty() || ausgabeblutgruppe
        .getText() == null || ausgabeblutgruppe.getText().trim().isEmpty() || ausgabearzt.getText() == null || ausgabearzt.
        getText().trim().isEmpty() || ausgabetelefonnummer.getText() == null || ausgabetelefonnummer.getText().trim().
        isEmpty() || ausgabevorerkrankungen.getText() == null || ausgabevorerkrankungen.getText().trim().isEmpty() ||
        ausgabeallergien.getText() == null || ausgabeallergien.getText().trim().isEmpty())
        {
            warningDaten(); 
        }
        else
        {
            if(ausgabegeschlecht.getText().replaceAll(" ","").matches("[a-zA-Z]+") && ausgabeblutgruppe.getText().replaceAll(" ","").matches("[a-zA-Z]+") &&
            ausgabearzt.getText().replaceAll(" ","").matches("[a-zA-Z]+") && ausgabetelefonnummer.getText().replaceAll(" ","").matches("[0-9]+"))
            {
                verwalter.Aktesuchen(auskrankenkassennummer1.getText()).Aktebearbeiten(ausgabeadresse.getText(),
                    ausgabegeschlecht.getText(), auskrankenkassennummer1.getText(), ausgabeblutgruppe.getText(), 
                    ausgabearzt.getText(), ausgabetelefonnummer.getText(),ausgabevorerkrankungen.getText(), ausgabeallergien.
                    getText());

                p = verwalter.Aktesuchen(auskrankenkassennummer1.getText());    
                speichernbutton.setDisable(true);

                ausgabegeschlecht.setEditable(false);
                ausgabeadresse.setEditable(false);
                auskrankenkassennummer1.setEditable(false);
                ausgabeblutgruppe.setEditable(false);
                ausgabearzt.setEditable(false);
                ausgabevorerkrankungen.setEditable(false);
                ausgabetelefonnummer.setEditable(false);
                ausgabeallergien.setEditable(false);
            }
            else
            {
                if(ausgabegeschlecht.getText().replaceAll(" ","").matches("[a-zA-Z]+")==false)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Achtung");
                    alert.setHeaderText("Falsche Eingabe im Geschlechtfeld!");
                    alert.setContentText("Bitte nur Buchstaben eingeben");

                    alert.showAndWait();
                    ausgabegeschlecht.clear(); 
                }
                else if(ausgabeblutgruppe.getText().replaceAll(" ","").matches("[a-zA-Z]+")==false)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Achtung");
                    alert.setHeaderText("Falsche Eingabe im Blutgruppefeld!");
                    alert.setContentText("Bitte nur Buchstaben eingeben");

                    alert.showAndWait();
                    ausgabeblutgruppe.clear(); 
                }
                else if(ausgabearzt.getText().replaceAll(" ","").matches("[a-zA-Z]+")==false)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Achtung");
                    alert.setHeaderText("Falsche Eingabe im Arztfeld!");
                    alert.setContentText("Bitte nur Buchstaben eingeben");

                    alert.showAndWait();
                    ausgabearzt.clear(); 
                }
                else if(ausgabetelefonnummer.getText().replaceAll(" ","").matches("[0-9]+")==false)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Achtung");
                    alert.setHeaderText("Falsche Eingabe im Telefonnummerfeld!");
                    alert.setContentText("Bitte nur Zahlen eingeben");

                    alert.showAndWait();
                    ausgabetelefonnummer.clear(); 

                }
            }
        }
    }

    @FXML
    public void patientenakteladen()
    {
        try{

            FXMLLoader loader = new FXMLLoader(Main.class.getResource("patientenakte.fxml"));
            VBox pane = loader.load();

            MainWindowController mainWindowController = loader.getController();
            setMain(main);

            Scene scene = new Scene(pane);
            main.primaryStage.setScene(scene);
            main.primaryStage.show();

            mainWindowController.ausgabename.setText(p.getName());
            mainWindowController.ausgabealter.setText(p.getAlter());
            mainWindowController.ausgabeadresse.setText(p.getAdresse());
            mainWindowController.ausgabegeschlecht.setText(p.getGeschlecht());
            mainWindowController.auskrankenkassennummer1.setText(p.getKrankenkassenNr());
            mainWindowController.ausgabeblutgruppe.setText(p.getBlutgruppe());
            mainWindowController.ausgabearzt.setText(p.getZuständigerArzt());
            mainWindowController.ausgabetelefonnummer.setText(p.getTelefonnummer());
            mainWindowController.ausgabevorerkrankungen.setText(p.getVorerkrankungen());
            mainWindowController.ausgabeallergien.setText(p.getAllergien());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void backtopatientenakte()
    {
        patientenakteladen();
    }

    @FXML
    public void backtohome()
    {
        try{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainWindow.fxml"));
            AnchorPane pane = loader.load();

            MainWindowController mainWindowController = loader.getController();
            setMain(main);

            Scene scene = new Scene(pane);
            main.primaryStage.setScene(scene);
            main.primaryStage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void notfallspeichern()
    {
        if(notfallname.getText() == null || notfallname.getText().trim().isEmpty() || notfalladresse.getText() == null || 
        notfalladresse.getText().trim().isEmpty() || notfallbeziehung.getText() == null || notfallbeziehung.getText().trim()
        .isEmpty() || notfalltelefonnummer.getText() == null || notfalltelefonnummer.getText().trim().isEmpty() ||
        notfallblutgruppe.getText() == null || notfallblutgruppe.getText().trim().isEmpty())
        {
            warningDaten(); 
        }
        else
        {
            if(notfallname.getText().replaceAll(" ","").matches("[a-zA-Z]+") && notfallbeziehung.getText().replaceAll(" ","").matches("[a-zA-Z]+") &&
            notfalltelefonnummer.getText().replaceAll(" ","").matches("[0-9]+") && notfallblutgruppe.getText().replaceAll(" ","").matches("[a-zA-Z]+"))
            {
                verwalter.Aktesuchen(p.getKrankenkassenNr()).Notfallkontakterstellen(notfallname.getText(), notfalladresse.
                    getText(), notfallbeziehung.getText(), notfalltelefonnummer.getText(), notfallblutgruppe.getText());
                String nr = p.getKrankenkassenNr();
                p = verwalter.Aktesuchen(nr);
                patientenakteladen();
            }
            else
            {
                if(notfallbeziehung.getText().matches("[a-zA-Z]+")==false)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Achtung");
                    alert.setHeaderText("Falsche Eingabe im Beziehungsfeld!");
                    alert.setContentText("Bitte nur Buchstaben eingeben");

                    alert.showAndWait();
                    notfallbeziehung.clear(); 
                }
                else if(notfallname.getText().matches("[a-zA-Z]+")==false)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Achtung");
                    alert.setHeaderText("Falsche Eingabe im Namenfeld!");
                    alert.setContentText("Bitte nur Buchstaben eingeben");

                    alert.showAndWait();
                    notfallname.clear(); 
                }
                else if(notfalltelefonnummer.getText().matches("[0-9]+")==false)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Achtung");
                    alert.setHeaderText("Falsche Eingabe im Telefonnummerfeld!");
                    alert.setContentText("Bitte nur Zahlen eingeben");

                    alert.showAndWait();
                    notfalltelefonnummer.clear(); 
                }
                else if(notfallblutgruppe.getText().matches("[a-zA-Z]+")==false)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Achtung");
                    alert.setHeaderText("Falsche Eingabe im Blutgruppefeld!");
                    alert.setContentText("Bitte nur Buchstaben eingeben");

                    alert.showAndWait();
                    notfallblutgruppe.clear(); 
                }
            }
        }
    }

    @FXML
    public void analysebearbeiten()
    {
        laborantenkuerzelanzeige.setEditable(true);
        analysedatumanzeige.setDisable(false);
        analysedatumanzeige.setEditable(true);
        labornameanzeige.setEditable(true);
        analyseobjektanzeige.setEditable(true);
        analysemethodeanzeige.setEditable(true);
        analyseergebnisanzeige.setEditable(true);

        speichernbuttonanalysebericht.setDisable(false);
    }

    @FXML
    public void notfallbearbeiten()
    {
        notfalladresseanzeige.setEditable(true); 
        notfallbeziehunganzeige.setEditable(true);
        notfalltelefonnummeranzeige.setEditable(true);
        notfallblutgruppeanzeige.setEditable(true);

        Notfallkontaktspeicherbutton.setDisable(false);
    }

    @FXML
    public void analysebearbeitenspeichern()
    {
        if(laborantenkuerzelanzeige.getText() == null || laborantenkuerzelanzeige.getText().trim().isEmpty() || analysedatumanzeige.getValue() == null || analysedatumanzeige.getValue().equals("") || 
        labornameanzeige.getText() == null || labornameanzeige.getText().trim().isEmpty() || analyseobjektanzeige.getText() == null || analyseobjektanzeige.getText().trim().isEmpty() ||
        analysemethodeanzeige.getText() == null || analysemethodeanzeige.getText().trim().isEmpty() || analyseergebnisanzeige.getText() == null || analyseergebnisanzeige.getText().trim().isEmpty())
        {
            warningDaten(); 
        }
        else
        {
            if(laborantenkuerzelanzeige.getText().replaceAll(" ","").matches("[a-zA-Z]+")==false)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Achtung");
                alert.setHeaderText("Falsche Eingabe bei Laborantenkürzel");
                alert.setContentText("Bitte nur Buchstaben eingeben");

                alert.showAndWait();
                laborantenkuerzel.clear(); 
            }
            else if(labornameanzeige.getText().replaceAll(" ","").matches("[a-zA-Z]+")==false)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Achtung");
                alert.setHeaderText("Falsche Eingabe bei Laborname!");
                alert.setContentText("Bitte nur Buchstaben eingeben");

                alert.showAndWait();
                laborname.clear(); 
            }
            else if(analyseobjektanzeige.getText().replaceAll(" ","").matches("[a-zA-Z]+")==false)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Achtung");
                alert.setHeaderText("Falsche Eingabe bei Analyseobjekt!");
                alert.setContentText("Bitte nur Buchstaben eingeben");

                alert.showAndWait();
                analyseobjekt.clear(); 
            }
            else
            {
                String berichtnr = BerichtNR.getText().replace("Analysebericht Nr. ", "");
                verwalter.Aktesuchen(p.getKrankenkassenNr()).Analyseberichtsuchen2(berichtnr).Analyseberichtbearbeiten(laborantenkuerzelanzeige.getText(),
                    analysedatumanzeige.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), labornameanzeige.getText(), analyseobjektanzeige.getText(), analysemethodeanzeige.getText(), analyseergebnisanzeige.getText());

                p = verwalter.Aktesuchen(p.getKrankenkassenNr());    

                laborantenkuerzelanzeige.setEditable(false);
                analysedatumanzeige.setEditable(false);
                analysedatumanzeige.setDisable(true);
                labornameanzeige.setEditable(false);
                analyseobjektanzeige.setEditable(false);
                analysemethodeanzeige.setEditable(false);
                analyseergebnisanzeige.setEditable(false);

                speichernbuttonanalysebericht.setDisable(true);

            }
        }
    }

    @FXML
    public void notfallbearbeitenspeichern()
    {
        if(notfallnameanzeige.getText() == null || notfallnameanzeige.getText().trim().isEmpty() || notfalladresseanzeige.getText() == null || notfalladresseanzeige.getText().trim().isEmpty() || 
        notfallbeziehunganzeige.getText() == null || notfallbeziehunganzeige.getText().trim().isEmpty() || notfalltelefonnummeranzeige.getText() == null || notfalltelefonnummeranzeige.getText().trim().isEmpty() ||
        notfallblutgruppeanzeige.getText() == null || notfallblutgruppeanzeige.getText().trim().isEmpty())
        {
            warningDaten(); 
        }
        else
        {
            if(notfallbeziehunganzeige.getText().replaceAll(" ","").matches("[a-zA-Z]+") && notfalltelefonnummeranzeige.getText().replaceAll(" ","").matches
            ("[0-9]+") && notfallblutgruppeanzeige.getText().replaceAll(" ","").matches("[a-zA-Z]+"))
            {
                String name = notfallnameanzeige.getText();
                verwalter.Aktesuchen(p.getKrankenkassenNr()).Notfallkontaktaufrufen(name).kontaktdatenbearbeiten
                (notfalladresseanzeige.getText(),notfallbeziehunganzeige.getText(), notfalltelefonnummeranzeige.getText(),
                    notfallblutgruppeanzeige.getText());

                p = verwalter.Aktesuchen(p.getKrankenkassenNr());    

                notfalladresseanzeige.setEditable(false);
                notfallbeziehunganzeige.setEditable(false);
                notfalltelefonnummeranzeige.setEditable(false);
                notfallblutgruppeanzeige.setEditable(false);

                speichernbuttonanalysebericht.setDisable(true);
            }
            else
            {
                if(notfallbeziehunganzeige.getText().matches("[a-zA-Z]+")==false)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Achtung");
                    alert.setHeaderText("Falsche Eingabe im Beziehungsfeld!");
                    alert.setContentText("Bitte nur Buchstaben eingeben");

                    alert.showAndWait();
                    notfallbeziehunganzeige.clear(); 
                }
                else if(notfalltelefonnummeranzeige.getText().matches("[0-9]+")==false)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Achtung");
                    alert.setHeaderText("Falsche Eingabe im Telefonnummerfeld!");
                    alert.setContentText("Bitte nur Zahlen eingeben");

                    alert.showAndWait();
                    notfalltelefonnummeranzeige.clear(); 
                }
                else if(notfallblutgruppeanzeige.getText().matches("[a-zA-Z]+")==false)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Achtung");
                    alert.setHeaderText("Falsche Eingabe im Blutgruppefeld!");
                    alert.setContentText("Bitte nur Buchstaben eingeben");

                    alert.showAndWait();
                    notfallblutgruppeanzeige.clear(); 
                }
            }
        }
    }

    public void AnalyseberichtsubWindow()
    {   
        try{

            FXMLLoader loader = new FXMLLoader(Main.class.getResource("SubWindow.fxml"));
            VBox pane = loader.load();

            main.substage = new Stage();
            main.substage.setMinHeight(500.00);
            main.substage.setMinWidth(600.00);

            main.substage.setTitle("Analysebericht suchen");

            MainWindowController mainWindowController = loader.getController();
            mainWindowController.setMain(main);
            Scene scene = new Scene(pane);

            main.substage.initModality(Modality.APPLICATION_MODAL);

            main.substage.setScene(scene);
            main.substage.show();

        } 
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void NotfallkontaktsubWindow()
    {   
        try{

            FXMLLoader loader = new FXMLLoader(Main.class.getResource("NotfallkontaktsubWindow.fxml"));
            VBox pane = loader.load();

            main.substage = new Stage();
            main.substage.setMinHeight(500.00);
            main.substage.setMinWidth(600.00);

            main.substage.setTitle("Notfallkontakt suchen");

            MainWindowController mainWindowController = loader.getController();
            mainWindowController.setMain(main);
            Scene scene = new Scene(pane);

            main.substage.initModality(Modality.APPLICATION_MODAL);

            main.substage.setScene(scene);
            main.substage.show();

        } 
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void listedurchsuchen()
    {
        String eingabe = analyseberichtsuchenfeld.getText();

        if(analyseberichtsuchenfeld.getText() == null || analyseberichtsuchenfeld.getText().trim().isEmpty())
        {
            warningDaten();
        }

        else if(verwalter.Aktesuchen(p.getKrankenkassenNr()).getAnalysebericht().size()==0)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Achtung");
            alert.setHeaderText("Kein Analysebericht vorhanden!");
            alert.setContentText("Bitte Analysebericht anlegen");

            alert.showAndWait();
            analyseberichtsuchenfeld.clear();
        }

        else if(verwalter.Aktesuchen(p.getKrankenkassenNr()).getAnalysebericht() == null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Achtung");
            alert.setHeaderText("Keinen Bericht mit passendem Suchbegriff gefunden");
            alert.setContentText("Bitte erneut suchen");

            alert.showAndWait();
            analyseberichtsuchenfeld.clear();
        }
        else
        {
            listanalyseberichte.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            ArrayList <Analysebericht> aba = new ArrayList<Analysebericht>();
            if(p.Analyseberichtsuchen(eingabe)==null)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Achtung");
                alert.setHeaderText("Keinen Bericht mit passendem Suchbegriff gefunden");
                alert.setContentText("Bitte erneut suchen");

                alert.showAndWait();
                analyseberichtsuchenfeld.clear();
            }   
            else
            {
                aba = p.Analyseberichtsuchen(eingabe);

                for(Analysebericht e : aba)
                {
                    listanalyseberichte.getItems().add("Analysebericht Nr. "+e.getBerichtNR());

                }

                anzeigebutton.setDisable(false);
            }
        }
    }

    @FXML
    public void Notfalllistedurchsuchen()
    {
        String eingabe = Notfallkontaktsuchenfeld.getText();

        if(Notfallkontaktsuchenfeld.getText() == null || Notfallkontaktsuchenfeld.getText().trim().isEmpty())
        {
            warningDaten();
        }

        else if(verwalter.Aktesuchen(p.getKrankenkassenNr()).getNotfallkontakte().size()==0)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Achtung");
            alert.setHeaderText("Kein Notallkontakt vorhanden!");
            alert.setContentText("Bitte Notfallkontakt anlegen");

            alert.showAndWait();
            Notfallkontaktsuchenfeld.clear();
        }

        else if(verwalter.Aktesuchen(p.getKrankenkassenNr()).getNotfallkontakte() == null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Achtung");
            alert.setHeaderText("Keinen Kontakt mit passendem Suchbegriff gefunden");
            alert.setContentText("Bitte erneut suchen");

            alert.showAndWait();
            Notfallkontaktsuchenfeld.clear();
        }
        else
        {
            if(p.Notfallkontaktaufrufen(eingabe)==null)
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Achtung");
                alert.setHeaderText("Keinen Notfallkontakt mit passendem Suchbegriff gefunden");
                alert.setContentText("Bitte erneut suchen");

                alert.showAndWait();
                Notfallkontaktsuchenfeld.clear();
            }   
            else
            {
                try
                {
                    Notfallkontakt gef = p.Notfallkontaktaufrufen(eingabe);

                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("Notfallkontaktanzeigen.fxml"));
                    VBox pane = loader.load();

                    MainWindowController mainWindowController = loader.getController();
                    mainWindowController.setMain(main);
                    Scene scene = new Scene(pane);

                    main.primaryStage.setScene(scene);

                    mainWindowController.notfallnameanzeige.setText(gef.getName());
                    mainWindowController.notfalladresseanzeige.setText(gef.getadresse());
                    mainWindowController.notfallbeziehunganzeige.setText(gef.getbeziehung());
                    mainWindowController.notfalltelefonnummeranzeige.setText(gef.gettelefonnummer());
                    mainWindowController.notfallblutgruppeanzeige.setText(gef.getblutgruppe());

                    main.substage.close();
                } 
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    public void analyseberichtanzeigen()
    {
        String berichtnummer = listanalyseberichte.getSelectionModel().getSelectedItem().toString();
        String berichtnummer2 = berichtnummer.replace("Analysebericht Nr. ", "");
        Analysebericht gef = p.Analyseberichtsuchen2(berichtnummer2);

        try{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("analyseberichtanzeigen.fxml"));
            VBox pane = loader.load();

            MainWindowController mainWindowController = loader.getController();
            mainWindowController.setMain(main);
            Scene scene = new Scene(pane);

            main.primaryStage.setScene(scene);
            main.primaryStage.show();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            mainWindowController.BerichtNR.setText("Analysebericht Nr. "+berichtnummer2);
            mainWindowController.laborantenkuerzelanzeige.setText(gef.getLaborantenkuerzel());
            mainWindowController.labornameanzeige.setText(gef.getLaborname());
            mainWindowController.analyseobjektanzeige.setText(gef.getAnalyseObjekt());
            mainWindowController.analysemethodeanzeige.setText(gef.getAnalysemethode());
            mainWindowController.analyseergebnisanzeige.setText(gef.getAnalyseergebnis());
            mainWindowController.analysedatumanzeige.setValue(LocalDate.parse(gef.getAnalysedatum(), formatter));
            main.substage.close();
        } 
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void analyseberichtexportieren()
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

        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Speicherort auswählen");

        filechooser.setInitialDirectory(new File(System.getProperty("user.home")));
        filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Excel (*.xlsx)", "*.xlsx"));
        File file = filechooser.showSaveDialog(Main.primaryStage);

        if (file == null)
        {

        }
        else
        {
            String change = new String(file.getPath());
            String berichtnr = BerichtNR.getText().replace("Analysebericht Nr. ", "");
            p.Analyseberichtsuchen2(berichtnr).Berichtexportieren2(change.replaceAll(file.getName(), berichtnr + file.getName()));
            p.Analyseberichtsuchen2(berichtnr).Berichtexportieren(change.replaceAll(file.getName(), berichtnr + file.getName()));
        }
    }

    @FXML
    public void analyseberichtlöschen()
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Achtung");
        alert.setHeaderText("Analysebericht wird unwiderruflich gelöscht");
        alert.setContentText("Bitte bestätigen");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) 
        {
            String berichtnr = BerichtNR.getText().replace("Analysebericht Nr. ", "");

            verwalter.Aktesuchen(p.getKrankenkassenNr()).Analyseberichtlöschen(berichtnr);
            patientenakteladen();
        }
    }

    @FXML
    public void notfallkontaktlöschen()
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Achtung");
        alert.setHeaderText("Notfallkontakt wird unwiderruflich gelöscht");
        alert.setContentText("Bitte bestätigen");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) 
        {
            String name = notfallnameanzeige.getText();

            verwalter.Aktesuchen(p.getKrankenkassenNr()).Notfallkontaktlöschen(name);
            patientenakteladen();
        }
    }
}