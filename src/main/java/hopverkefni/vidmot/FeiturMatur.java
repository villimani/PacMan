package hopverkefni.vidmot;

import javafx.scene.shape.Rectangle;

public class FeiturMatur extends Rectangle {
    /**
     * Les inn feitann mat úr fxml skrá.
     */
    public FeiturMatur() {
        FXML_Lestur.lesa(this, "feiturmatur.fxml");
    }
}

