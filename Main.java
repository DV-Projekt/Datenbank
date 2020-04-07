
/**
 * Beschreiben Sie hier die Klasse GUI.
 * 
 * @author Nicolas Pfaff, Lennart Burkart 
 * @version 0.0.7
 */
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.fxml.*;
import java.io.*;
//import java.awt.Frame;
public class Main extends Application {
    
    public static Stage primaryStage;
    public Verwalter verwalter  = new Verwalter();
    
    
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
    

    public static void main(String[] args)
    {
        launch(args);
        
    }
}
