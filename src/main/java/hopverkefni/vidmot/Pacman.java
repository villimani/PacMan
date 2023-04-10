package hopverkefni.vidmot;

import javafx.scene.image.ImageView;

public class Pacman extends ImageView {
    public Pacman() {
        FXML_Lestur.lesa(this, "pacman-view.fxml");
    }
}
