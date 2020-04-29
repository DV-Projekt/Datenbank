
/**
 * Beschreiben Sie hier die Klasse MainWindowController.
 * 
 * @author Nicolas Pfaff, Lennart Burkart
 * @version 0.0.14
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
            Patientenakte ps = new Patientenakte();
            ps = verwalter.Aktesuchen(eingabe);
            p = ps;
            try{
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
        krankenkassennummer.setText("Hey");
    }

    @FXML
    public void analysebanlegen()
    {
        krankenkassennummer.setText("Hey");
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
    public void notfallkontanlegen()
    {
    }
}
