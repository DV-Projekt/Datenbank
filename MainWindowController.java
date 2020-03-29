
/**
 * Beschreiben Sie hier die Klasse MainWindowController.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.fxml.*;
import java.io.*;
public class MainWindowController
{
    //Views
    @FXML private Label labelstart;
    @FXML private Text krankenkassennummer;
    @FXML private TextField eingabefeldsuche;
    @FXML private MenuBar menubar;
    @FXML private Menu datei;
    @FXML private MenuItem anlegen;
    public Main main;
    
    public void setMain(Main main)
    {
        this.main = main;
    }
    
     @FXML
     public void suche()
    {
        String eingabe = eingabefeldsuche.getText();
        int nummer = Integer.parseInt(eingabe);
        // Patientenakte gesucht = new Patientenakte();
        // gesucht.Aktesuchen(nummer);
    }
    
    // @FXML
     // public void akteanlegen()
    // {
        // main.akteWindow();
    // }
}
