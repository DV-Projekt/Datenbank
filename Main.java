
/**
 * Beschreiben Sie hier die Klasse GUI.
 * 
 * @author Nicolas Pfaff, Lennart Burkart 
 * @version 0.0.6
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
public class Main extends Application {

    public static Stage primaryStage;
    // @FXML private Label labelstart;
    // @FXML private Text krankenkassennummer;
    // @FXML private TextField eingabefeldsuche;
    // @FXML private MenuBar menuBar;
    // @FXML private Menu datei;
    // @FXML private Menu help;
    // @FXML private MenuItem anlegen;
    // @FXML private MenuItem about;
    Verwalter v;
    @Override
    public void start(Stage primaryStage) 
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Chemische Analysedatenbank");
        mainWindow();
    }

    public void mainWindow()
    {
        try{
            v = new Verwalter();
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainWindow.fxml"));
            VBox pane = loader.load();

            primaryStage.setMinHeight(500.00);
            primaryStage.setMinWidth(600.00);

            MainWindowController mainWindowController = loader.getController();
            mainWindowController.setMain(this);
            Scene scene = new Scene(pane);
            
            
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } 
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public Stage getPrimaryStage()
    {
        return primaryStage;
    }
    
    
    // public void akteWindow()
    // {
        // try{
            // FXMLLoader loader2 = new FXMLLoader(Main.class.getResource("secondWindow.fxml"));
            // VBox secondpane = loader2.load();

            // MainWindowController mainWindowController = loader2.getController();
            // mainWindowController.setMain(this);
            // Scene scene = new Scene(secondpane);
            
            // Stage newWindow = new Stage();
            // newWindow.setScene(scene);
            // newWindow.setTitle("Akte anlegen");
            // newWindow.initModality(Modality.WINDOW_MODAL);
            // newWindow.show();
            
            // // primaryStage.setScene(scene);
            // // primaryStage.setTitle("Akte anlegen");
            // // primaryStage.show();
        // } 
        // catch(IOException e){
            // e.printStackTrace();
        // }
    // }
    public static void main(String[] args)
    {
        launch(args);
        
    }
}
