
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
import java.awt.Frame;
public class MainWindowController
{
    //Views
    @FXML 
    private Label labelstart;
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
    public Main main;
    Stage second; 
    public void setMain(Main main)
    {
        this.main = main;
    }
    
    public void action()
    {
        anlegen.setVisible(true);
    }
    @FXML
    public void suche()
    {
        String eingabe = eingabefeldsuche.getText();
        int nummer = Integer.parseInt(eingabe);
        try{
            second = main.getPrimaryStage();
            FXMLLoader loader2 = new FXMLLoader(Main.class.getResource("secondWindow.fxml"));
            VBox pane2 = loader2.load();
            Scene scene = new Scene(pane2);
            second.setScene(scene);
            second.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void akteanlegen()
    {
        try{
            second = main.getPrimaryStage();
            FXMLLoader loader2 = new FXMLLoader(Main.class.getResource("secondWindow.fxml"));
            VBox pane2 = loader2.load();
            Scene scene = new Scene(pane2);
            second.setScene(scene);
            second.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
