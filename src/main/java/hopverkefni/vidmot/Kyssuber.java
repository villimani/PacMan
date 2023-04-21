package hopverkefni.vidmot;

import javafx.scene.image.ImageView;

public class Kyssuber extends ImageView {

    public Kyssuber() {
        FXML_Lestur.lesa(this, "Kyssuber.fxml");
    }

    public void stillumKyssuber(){
        setY(250);
        setX(300);

    }
}
