package hopverkefni.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static final String BOUNCE = "Bouncing";
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("adal-view.fxml"));
        Parent root = loader.load();
        PacmanController sc = loader.getController();
        stage.setTitle(BOUNCE);
        Scene s = new Scene(root, 400, 500);
        stage.setScene(s);
        sc.orvatakkar();
        stage.show();
        sc.hefjaLeik();
    }

    public static void main(String[] args) {
        launch();
    }
}