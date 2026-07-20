import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("conversor.fxml"));
        
        Scene scene = new Scene(loader.load(), 400, 350);

        stage.setTitle("Conversor de Monedas");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
