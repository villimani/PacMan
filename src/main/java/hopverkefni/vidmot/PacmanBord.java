package hopverkefni.vidmot;

import javafx.scene.layout.Pane;

public class PacmanBord extends Pane {
    public PacmanBord() {;
        FXML_Lestur.lesa(this, "leikbord-view.fxml");
    }

}
