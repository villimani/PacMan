package hopverkefni.vidmot;

import javafx.scene.layout.Pane;

public class PacmanBord extends Pane {

    private Pacman fxpacman;
    public PacmanBord() {;
        FXML_Lestur.lesa(this, "leikbord-view.fxml");
    }

    public void afram() {
        fxpacman.afram();
    }

    public  void setStefna(int s) {
        fxpacman.setRotate(s);
    }

}
