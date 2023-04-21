package hopverkefni.vidmot;

import javafx.scene.image.ImageView;

public class Kyssuber extends ImageView {

    public Kyssuber() {
        FXML_Lestur.lesa(this, "Kyssuber.fxml");
    }

    /**
     * Stillir staðsetnigu kirsubers á leikborði.
     */
    public void stillumKyssuber(){
        setY(225);
        setX(275);

    }
}
