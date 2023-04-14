package hopverkefni.vidmot;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class PacmanBord extends Pane {

    @FXML
    private Pacman fxPacman;
    @FXML
    private Draugur fxDraugur;

    public boolean bordadilitill = false;

    private PacmanController sc;

    private boolean erAVegg = false; // Held utan um hvort boltinn er á pallin eða ekki

    private ObservableList<Node> fxVeggir = FXCollections.observableArrayList();

    private final ObservableList<Matur> matur = FXCollections.observableArrayList();

    private final ObservableList<FeiturMatur> feiturMatur = FXCollections.observableArrayList();

    public PacmanBord() {
        FXML_Lestur.lesa(this, "leikbord-view.fxml");
        fxVeggir = getChildren();

        // Stilla lista með matnum
        for (int i = 1; i < 5; i++) {
            matur.add((Matur) fxVeggir.get(i));
        }

        // Stilla lista með feita matnum
        for (int i = 5; i < 9; i++) {
            feiturMatur.add((FeiturMatur) fxVeggir.get(i));
        }
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

    // Fara í gegnum venjulegu stigin
    public boolean bordaMat() {
        for (Matur f : matur) {
            System.out.println("borda");
            if (athugaMat(f)) {
                getChildren().remove(f);
                matur.remove(f);
                return true;
            }
        }
        System.out.println("KKKIborda");
        return false;
    }

    // Fara í gegnum alla feitu matana.
    public boolean bordaFeitanMat() {
        for (FeiturMatur f : feiturMatur) {
            System.out.println("borda");
            if (athugaFeitanMat(f)) {
                getChildren().remove(f);
                feiturMatur.remove(f);
                return true;
            }
        }
        System.out.println("KKKIborda");
        return false;
    }

    // Kíkir hvort að leikmaður klessti á vegg
    public void veggjaStopp(){
        for (int i = 9; i < fxVeggir.size()-2; i++) {
            Rectangle p = (Rectangle) fxVeggir.get(i);
            if (p.getWidth() > 99) {
                Veggtegund1 v = (Veggtegund1) fxVeggir.get(i);
                athugaVeggtegund1(v);
            } else {
                Veggtegund2 v = (Veggtegund2) fxVeggir.get(i);
                athugaVeggtegund2(v);
            }
        }
    }

    public void endurstilla(){
        nyrPac();
        nyrDraugur();
    }

    // Kíkja hvort að leikmaður snerti feitan mat
    public boolean athugaFeitanMat(FeiturMatur f) {
        if(fxPacman.getBoundsInParent().intersects(f.getBoundsInParent())) {
            System.out.print("FVENJULEGUR MATUR ");
            return true;
        }
        return false;
    }

    // Kíkja hvort að leikmaður snerti venjulegan mat
    public boolean athugaMat(Matur f) {
        if(fxPacman.getBoundsInParent().intersects(f.getBoundsInParent())) {
            System.out.print("VENJULEGUR MATUR ");
            return true;
        }
        return false;
    }

    public void athugaVeggtegund1(Veggtegund1 p) {
       if(fxPacman.getBoundsInParent().intersects(p.getBoundsInParent())) {
           erAVegg = true;
           if (erAVegg && fxPacman.getY() < p.getY()) {
               fxPacman.yProperty().bind(p.getUppfaertYUppi());
           }
           if (erAVegg && fxPacman.getY() > p.getY()) {
               System.out.print("niðri ");
               fxPacman.yProperty().bind(p.getUppfaertYUndir());
           } else {
               erAVegg = false;
               fxPacman.yProperty().unbind();
           }
       } else {
           fxPacman.yProperty().unbind();
           erAVegg = false;
       }
    }

    public void athugaVeggtegund2(Veggtegund2 p) {

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
