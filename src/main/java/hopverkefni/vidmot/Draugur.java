package hopverkefni.vidmot;

import javafx.scene.image.ImageView;

public class Draugur extends ImageView {
    public Draugur () {
        FXML_Lestur.lesa(this, "draugur-view.fxml");
    }
}
