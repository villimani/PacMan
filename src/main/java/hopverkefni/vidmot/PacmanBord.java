package hopverkefni.vidmot;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class PacmanBord extends Pane {

    @FXML
    private Pacman fxPacman;
    @FXML
    private Draugur fxDraugur;
    public PacmanBord() {
        FXML_Lestur.lesa(this, "leikbord-view.fxml");
    }

    public void afram() {
        fxPacman.afram();
    }

    public void setStefna(int upp) {
        fxPacman.setRotate(upp);
    }

    public void aframDraugar(){
        fxDraugur.afram();
        draugastefna();
    }

    public void draugastefna(){
        fxDraugur.setRotate(0);
    }

}
