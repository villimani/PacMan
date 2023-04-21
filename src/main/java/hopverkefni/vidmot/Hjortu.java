package hopverkefni.vidmot;

import javafx.scene.image.ImageView;

public class Hjortu extends ImageView {
    public Hjortu() {
        FXML_Lestur.lesa(this, "Hjortu.fxml");
    }

    /**
     * Stillir staðsetningu hjartanna á leikborðinu.
     */
    public void stillumhjarta1(){
        setY(1);
        setX(1);
    }
    public void stillumhjarta2(){
        setY(1);
        setX(30);
    }
    public void stillumhjarta3(){
        setY(1);
        setX(60);
    }
}
