
/**
 * Beschreiben Sie hier die Klasse GUI.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.fxml.*;
import java.io.*;
public class Main extends Application {

    private Stage primaryStage;
    @Override
    public void start(Stage primaryStage) 
    {
        this.primaryStage = primaryStage;
        mainWindow();
    }

    public void mainWindow()
    {
        try{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/MainWindow.fxml"));
            AnchorPane pane = loader.load();

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

    public static void main(String[] args)
    {
        launch(args);
    }
}
