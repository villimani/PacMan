package hopverkefni.vidmot;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class PacmanBord extends Pane {

    @FXML
    private Pacman fxPacman;
    @FXML
    private Draugur fxDraugur;


    private ObservableList<Node> fxVeggtegund1 = FXCollections.observableArrayList();

    private ObservableList<Node> fxVeggtegund2 = FXCollections.observableArrayList();

    private int life = 3;

    private boolean veggur = false;

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

    public boolean stopPacman() {
        if (veggur) {
            return true;
        } else {
            return false;
        }
    }

    public void veggjaStopp(){
        for (int i = 0; i < fxVeggtegund1.size()-1; i++) {
            Veggtegund1 p=(Veggtegund1) fxVeggtegund1.get(i+1);
            athugaPacmanaveggTegund1(p);
        }
        for (int i = 0; i < fxVeggtegund2.size()-1; i++) {
            Veggtegund2 p=(Veggtegund2) fxVeggtegund2.get(i+1);
            athugaPacmanaveggTegund2(p);
        }
    }


    public boolean athugaPacmanaveggTegund1(Veggtegund1 p) {
       if(fxPacman.getBoundsInParent().intersects(p.getBoundsInParent())) {
           veggur = true;
           return true;
       }
       return false;
    }

    public boolean athugaPacmanaveggTegund2(Veggtegund2 p2) {
        if (fxPacman.getBoundsInParent().intersects(p2.getBoundsInParent())) {
            veggur = true;
            return true;
        }
        return false;
    }

    public boolean missaLif() {
        if (fxPacman.getBoundsInParent().intersects(fxDraugur.getBoundsInParent())) {
            System.out.println("missa lif");
            life--;
            return true;
        }
        else {
            return false;
        }
    }


}
