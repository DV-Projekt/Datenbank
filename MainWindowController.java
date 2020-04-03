
/**
 * Beschreiben Sie hier die Klasse MainWindowController.
 * 
 * @author Nicolas Pfaff, Lennart Burkart
 * @version 0.0.12
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
    
    public Verwalter v;

    public void setMain(Main main)
    {
        this.main = main;
    }
    
    @FXML
    public void suche()
    {   
        int nummer=0;
        if(eingabefeldsuche.getText() == null || eingabefeldsuche.getText().trim().isEmpty())
        {
            warningDaten();
        }
         if(Akten.size()==0)
        {
            String eingabe = eingabefeldsuche.getText();
            nummer = Integer.parseInt(eingabe);
            try{
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("secondWindow.fxml"));
                VBox pane = loader.load();
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
            Patientenakte ps = v.Aktesuchen(nummer);
            try{
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("patientenakte.fxml"));
                VBox pane = loader.load();
                Scene scene = new Scene(pane);
                Main.primaryStage.setScene(scene);
                Main.primaryStage.show();
                
                ausgabename.setText(ps.getName());
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
            int alter1 = Integer.parseInt(alter.getText());
            int krankenkassennr = Integer.parseInt(krankenkassennummer1.getText());
            int telefonnr = Integer.parseInt(telefonnummer.getText());
            v = new Verwalter(name.getText(), alter1, adresse.getText(), geschlecht.getText(), krankenkassennr, 
                    blutgruppe.getText(), arzt.getText(), telefonnr, vorerkrankungen.getText(), allergien.getText());
            // ArrayList <Patientenakte> Akten = new ArrayList <Patientenakte> ();
            // Akten = Main.verwalter.getArrayList();
            // Akten.add(Patient);
            
            try{
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainWindow.fxml"));
                VBox pane = loader.load();
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

}
