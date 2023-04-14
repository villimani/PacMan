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

    private final ObservableList<Matur> matur = FXCollections.observableArrayList();

    private boolean veggur = false;

    public PacmanBord() {
        FXML_Lestur.lesa(this, "leikbord-view.fxml");
        fxVeggtegund1=getChildren();
        fxVeggtegund2=getChildren();
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



    public void veggjaStopp(){
        for (int i = 0; i < fxVeggtegund1.size()-1; i++) {
            Veggtegund1 p=(Veggtegund1) fxVeggtegund1.get(i+1);
            athugaPacmanaveggTegund1(p);
        }
        for (int i = 0; i < fxVeggtegund2.size()-1; i++) {
            Veggtegund2 p2=(Veggtegund2) fxVeggtegund2.get(i+1);
            athugaPacmanaveggTegund2(p2);
        }
    }

    public void endurstilla(){
        nyrPac();
        nyrDraugur();
    }


    public boolean athugaPacmanaveggTegund1(Veggtegund1 p) {
       if(fxPacman.getBoundsInParent().intersects(p.getBoundsInParent())) {
           veggur = true;
           System.out.println("veggur");
       }
       veggur = false;
       return veggur;
    }

    public boolean athugaPacmanaveggTegund2(Veggtegund2 p2) {
        if (fxPacman.getBoundsInParent().intersects(p2.getBoundsInParent())) {
            veggur = true;
            System.out.println("veggur");
        }
        veggur = false;
        return veggur;
    }

    public boolean missaLif() {
        if (fxPacman.getBoundsInParent().intersects(fxDraugur.getBoundsInParent())) {
            System.out.println("missa lif");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean bordarmat() {
        for (Matur f : matur) {
            if (etaMat(f)) {
                getChildren().remove(f);
                matur.remove(f);
                return true;
            }
        }
        return false;
    }

    public boolean etaMat(Matur f) {
        if (fxPacman.getBoundsInParent().intersects(f.getBoundsInParent())) {
            System.out.println("eta mat");
            return true;
        }
        return false;
    }

    public boolean bordarfeitannmat() {
        for (Matur f : matur) {
            if (etaMat(f)) {
                getChildren().remove(f);
                matur.remove(f);
                return true;
            }
        }
        return false;
    }


    public Pacman nyrPac() {
        if (fxPacman != null)
            getChildren().remove(fxPacman);
        fxPacman = new Pacman();
        getChildren().add(fxPacman);
        fxPacman.stillumPacman();
        return fxPacman;
    }

    public Draugur nyrDraugur() {
        if (fxDraugur != null)
            getChildren().remove(fxDraugur);
        fxDraugur = new Draugur();
        getChildren().add(fxDraugur);
        fxDraugur.stillumDraug();
        return fxDraugur;
    }
}
