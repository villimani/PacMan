package hopverkefni.vidmot;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class PacmanBord extends Pane {

    @FXML
    private Pacman fxPacman;
    @FXML
    private Draugur fxDraugur;

    @FXML
    private Veggtegund1 fxVeggtegund1;

    @FXML
    private Veggtegund2 fxVeggtegund2;

    private boolean erAvegg=false;
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

    public boolean bordarmat() {
        return fxPacman.getX() == 100;
    }
    public boolean bordarfeitannmat() {
        return fxPacman.getX() == 110;
    }

   // public boolean athugaPacmanavegg(Veggtegund1 p, Veggtegund2 p2) {
   //     if(fxPacman.getBoundsInParent().intersects(p.getBoundsInParent())) {
   //         erAvegg = true;
   //         if (erAvegg) {
   //             fxPacman.xProperty().bind(p.getUppfaertYProperty());
   //         } else {
   //             erAvegg = false;
   //             fxPacman.xProperty().unbind();
   //         }
   //     } else {
    //         fxPacman.yProperty().unbind();
   //         erAvegg = false;
   //         fxPacman.setX((int)(fxPacman.getX() + 5));
   //     }
    //    return false;
   // }
}
