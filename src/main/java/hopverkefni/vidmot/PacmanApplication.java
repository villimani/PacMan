package hopverkefni.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PacmanApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("adal-view.fxml"));
        Parent root = loader.load();
        PacmanController sc = loader.getController();
        stage.setTitle("Pacman");
        Scene s = new Scene(root, 800, 600);
        stage.setScene(s);
        sc.orvatakkar();
        stage.show();
        sc.hefjaLeik();

    }

    public static void main(String[] args) {
        launch();
    }
}