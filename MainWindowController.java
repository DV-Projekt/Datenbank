
/**
 * Beschreiben Sie hier die Klasse MainWindowController.
 * 
 * @author Nicolas Pfaff, Lennart Burkart
 * @version 0.0.17
 */
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
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
    private TextField analysedatum;

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

    public Main main;

    private Patientenakte p = new Patientenakte();

    public void setMain(Main main)
    {
        this.main = main;
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
        }

        else if(verwalter.Aktesuchen(eingabe) == null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Achtung");
            alert.setHeaderText("Eingegebene Nummer existiert im System nicht!");
            alert.setContentText("Bitte Akte anlegen");

            alert.showAndWait();
        }
        else
        {

            p = verwalter.Aktesuchen(eingabe);

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
            Patientenakte patient = new Patientenakte(name.getText(), alter.getText(), adresse.getText(), geschlecht.getText(), krankenkassennummer1.getText(), 
                    blutgruppe.getText(), arzt.getText(), telefonnummer.getText(), vorerkrankungen.getText(), allergien.getText());
            verwalter.Akten.add(patient);

            try{
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainWindow.fxml"));
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
            warningDaten();
        }

        else if(verwalter.Akten.size()==0)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Achtung");
            alert.setHeaderText("Keine Akten vorhanden!");
            alert.setContentText("Bitte Akte anlegen");

            alert.showAndWait();
        }

        else if(verwalter.Aktesuchen(eingabe) == null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Achtung");
            alert.setHeaderText("Eingegebene Nummer existiert im System nicht!");
            alert.setContentText("Bitte Akte anlegen");

            alert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Achtung");
            alert.setHeaderText("Akte wird unwiderruflich gelöscht");
            alert.setContentText("Bitte bestätigen");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.YES) 
            {
                verwalter.Aktelöschen(eingabe);
            }
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
        String change = new String(file.getPath());

        p.Exportieren2(change.replaceAll(file.getName(), p.getKrankenkassenNr() + file.getName()));
    }

    @FXML
    public void notfallkontakt()
    {
        try{
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
        analysedatum.getText() == null || analysedatum.getText().trim().isEmpty() || 
        laborname.getText() == null || laborname.getText().trim().isEmpty() || analyseobjekt.getText() == null || 
        analyseobjekt.getText().trim().isEmpty() || analysemethode.getText() == null || 
        analysemethode.getText().trim().isEmpty() || analyseergebnis.getText() == null || 
        analyseergebnis.getText().trim().isEmpty())
        {
            warningDaten(); 
        }
        else
        {
            String nr = p.getKrankenkassenNr();
            verwalter.Aktesuchen(nr).Analyseberichtanlegen(laborantenkuerzel.getText(),analysedatum.getText(),laborname.getText(), analyseobjekt.getText(), analysemethode.getText(),analyseergebnis.getText());;

            patientenakteladen();
        }
    }

    @FXML
    public void patientbearbeiten()
    {
        ausgabename.setEditable(true);
        ausgabegeschlecht.setEditable(true);
        ausgabeadresse.setEditable(true);
        ausgabealter.setEditable(true);
        auskrankenkassennummer1.setEditable(true);
        ausgabeblutgruppe.setEditable(true);
        ausgabearzt.setEditable(true);
        ausgabevorerkrankungen.setEditable(true);
        ausgabetelefonnummer.setEditable(true);
        ausgabeallergien.setEditable(true);

        speichernbutton.setDisable(false);
    }

    @FXML
    public void speichernb()
    {
        if(ausgabename.getText() == null || ausgabename.getText().trim().isEmpty() || ausgabealter.getText() == null || ausgabealter.getText().trim().isEmpty() || 
        ausgabegeschlecht.getText() == null || ausgabegeschlecht.getText().trim().isEmpty() || ausgabeadresse.getText() == null || ausgabeadresse.getText().trim().isEmpty() ||
        auskrankenkassennummer1.getText() == null || auskrankenkassennummer1.getText().trim().isEmpty() || ausgabeblutgruppe.getText() == null || 
        ausgabeblutgruppe.getText().trim().isEmpty() || ausgabearzt.getText() == null || ausgabearzt.getText().trim().isEmpty() || ausgabetelefonnummer.getText() == null || 
        ausgabetelefonnummer.getText().trim().isEmpty() || ausgabevorerkrankungen.getText() == null || ausgabevorerkrankungen.getText().trim().isEmpty() ||
        ausgabeallergien.getText() == null || ausgabeallergien.getText().trim().isEmpty())
        {
            warningDaten(); 
        }
        else
        {
            verwalter.Aktesuchen(auskrankenkassennummer1.getText()).Aktebearbeiten(ausgabegeschlecht.getText(),
                ausgabeadresse.getText(), auskrankenkassennummer1.getText(), ausgabeblutgruppe.getText(), ausgabearzt.getText(), ausgabetelefonnummer.getText(),
                ausgabevorerkrankungen.getText(), ausgabeallergien.getText());

            speichernbutton.setDisable(true);

            ausgabename.setEditable(false);
            ausgabegeschlecht.setEditable(false);
            ausgabeadresse.setEditable(false);
            ausgabealter.setEditable(false);
            auskrankenkassennummer1.setEditable(false);
            ausgabeblutgruppe.setEditable(false);
            ausgabearzt.setEditable(false);
            ausgabevorerkrankungen.setEditable(false);
            ausgabetelefonnummer.setEditable(false);
            ausgabeallergien.setEditable(false);
        }
    }

    @FXML
    public void notfallanlegen()
    {
        verwalter.Aktesuchen(p.getKrankenkassenNr()).Notfallkontakterstellen(notfallname.getText(), notfalladresse.getText(), notfallbeziehung.getText(), 
            notfalltelefonnummer.getText(), notfallblutgruppe.getText());

        patientenakteladen();

    }
    
    @FXML
    public void patientenakteladen()
    {
        try{
            Patientenakte ps = new Patientenakte();
            ps = verwalter.Aktesuchen(p.getKrankenkassenNr());

            FXMLLoader loader = new FXMLLoader(Main.class.getResource("patientenakte.fxml"));
            VBox pane = loader.load();

            MainWindowController mainWindowController = loader.getController();
            setMain(main);

            Scene scene = new Scene(pane);
            main.primaryStage.setScene(scene);
            main.primaryStage.show();

            mainWindowController.ausgabename.setText(ps.getName());
            mainWindowController.ausgabealter.setText(ps.getAlter());
            mainWindowController.ausgabeadresse.setText(ps.getAdresse());
            mainWindowController.ausgabegeschlecht.setText(ps.getGeschlecht());
            mainWindowController.auskrankenkassennummer1.setText(ps.getKrankenkassenNr());
            mainWindowController.ausgabeblutgruppe.setText(ps.getBlutgruppe());
            mainWindowController.ausgabearzt.setText(ps.getZuständigerArzt());
            mainWindowController.ausgabetelefonnummer.setText(ps.getTelefonnummer());
            mainWindowController.ausgabevorerkrankungen.setText(ps.getVorerkrankungen());
            mainWindowController.ausgabeallergien.setText(ps.getAllergien());
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
}
