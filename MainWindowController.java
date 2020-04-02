
/**
 * Beschreiben Sie hier die Klasse MainWindowController.
 * 
 * @author Nicolas Pfaff, Lennart Burkart
 * @version 0.0.8
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
public class MainWindowController
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
    private TextField vorerkrankungen;
    @FXML 
    private TextField allergien;
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
    public Main main;
    Stage second; 
    private Verwalter v;
    public void setMain(Main main)
    {
        this.main = main;
    }
    
    // public void action()
    // {
        // anlegen.setVisible(true);
    // }
    
    @FXML
    public void suche()
    {
        if(eingabefeldsuche.getText() == null || eingabefeldsuche.getText().trim().isEmpty())
        {
            warningAlert();
        }
        
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
        
    }
    
    @FXML
    public void save()
    {
        int alter1 = Integer.parseInt(alter.getText());
        int krankenkassennummer2 = Integer.parseInt(krankenkassennummer1.getText());
        int telefonnummer1 = Integer.parseInt(telefonnummer.getText());
        
        v = new Verwalter(name.getText(), alter1, adresse.getText(), geschlecht.getText(), krankenkassennummer2, 
        blutgruppe.getText(), arzt.getText(), telefonnummer1, vorerkrankungen.getText(), allergien.getText());
        try{
            Stage back = main.getPrimaryStage();
            FXMLLoader loader2 = new FXMLLoader(Main.class.getResource("MainWindow.fxml"));
            VBox pane2 = loader2.load();
            Scene scene = new Scene(pane2);
            back.setScene(scene);
            back.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void warningAlert() 
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Achtung");
        alert.setHeaderText("Achtung!");
        alert.setContentText("Bitte Daten eingeben");
 
        alert.showAndWait();
    }
}
