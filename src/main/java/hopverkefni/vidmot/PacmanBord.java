package hopverkefni.vidmot;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class PacmanBord extends Pane {

    @FXML
    private Pacman fxPacman;
    @FXML
    private Draugur fxDraugur;

    @FXML
    private Allurmatur fxAllurmatur;

    @FXML
    private Pane fxGeymsla;

    @FXML
    private Kyssuber fxKyssuber;

    public boolean bordadilitill = false;



    private boolean erAVegg = false; // Held utan um hvort boltinn er á pallin eða ekki

    private boolean erAVeggD = false;

    private ObservableList<Node> fxVeggir = FXCollections.observableArrayList();

    private ObservableList<Node> matur = FXCollections.observableArrayList();
    private ObservableList<Node> maturGeymsla = FXCollections.observableArrayList();

    private final ObservableList<FeiturMatur> feiturMatur = FXCollections.observableArrayList();

    public PacmanBord() {

        FXML_Lestur.lesa(this, "leikbord-view.fxml");
        fxVeggir = getChildren();
        matur= fxAllurmatur.getChildren();


        // Stilla lista með feita matnum
        for (int i = 2; i <6; i++) {
            feiturMatur.add((FeiturMatur) fxVeggir.get(i));
        }
    }

    public void setBord (){
        getChildren().removeAll(getChildren());

        // lesa inn aftur upp á nýtt
        FXML_Lestur.lesa(this, "leikbord-view.fxml");
        fxVeggir = getChildren();
        matur= fxAllurmatur.getChildren();

        // Stilla lista með feita matnum
        for (int i = 2; i <6; i++) {
            feiturMatur.add((FeiturMatur) fxVeggir.get(i));
        }
        nyrkyss();

    }

    public void afram() {
        fxPacman.afram();
    }

    public void setStefna(int upp) {
        fxPacman.setRotate(upp);
    }

    public void aframDraugar() {
        fxDraugur.afram();
    }

    public void draugastefna(int a) {
       fxDraugur.setRotate(a);
    }

    public void pacmanstefna(int a) {
        fxPacman.setRotate(a);
    }



    // Fara í gegnum venjulegu stigin
    public boolean bordaMat() {
        for (Node f : matur) {
            if (athugaMat((Node) f)) {
                getChildren().remove(f);
                matur.remove(f);
                return true;
            }
        }
        return false;
    }




    // Fara í gegnum alla feitu matana.
    public boolean bordaFeitanMat() {
        for (FeiturMatur f : feiturMatur) {
            if (athugaFeitanMat(f)) {
                getChildren().remove(f);
                feiturMatur.remove(f);
                return true;
            }
        }
        return false;
    }

    public boolean bordakyssuber() {
        if (athugakyssuber()){
            getChildren().remove(fxKyssuber);
            return true;
        }
        return false;
    }


    // Kíkir hvort að leikmaður klessti á vegg
    public void veggjaStopp() {
        for (int i = 6; i < fxVeggir.size() - 3; i++) {
            Rectangle p = (Rectangle) fxVeggir.get(i);
            if (p.getWidth() > 11) {
                Veggtegund1 v = (Veggtegund1) fxVeggir.get(i);
                athugaVeggtegund1(v);
            } else {
                Veggtegund2 v = (Veggtegund2) fxVeggir.get(i);
                athugaVeggtegund2(v);
            }
        }
    }

    public void veggjaStoppD() {
        for (int i= 6; i < fxVeggir.size() - 3; i++) {
            Rectangle p = (Rectangle) fxVeggir.get(i);
            if (p.getWidth() > 11) {
                Veggtegund1 v = (Veggtegund1) fxVeggir.get(i);
                athugaVeggtegund1Draugur(v);

            } else {
                Veggtegund2 v = (Veggtegund2) fxVeggir.get(i);
                athugaVeggtegund2Draugur(v);

            }
        }
    }

    public void endurstilla() {
        nyrPac();
        nyrDraugur();
    }

    // Kíkja hvort að leikmaður snerti feitan mat
    public boolean athugaFeitanMat(FeiturMatur f) {
        if (fxPacman.getBoundsInParent().intersects(f.getBoundsInParent())) {
            System.out.print("FVENJULEGUR MATUR ");
            return true;
        }
        return false;
    }

    // Kíkja hvort að leikmaður snerti venjulegan mat
    public boolean athugaMat(Node f) {
        if (fxPacman.getBoundsInParent().intersects(f.getBoundsInParent())) {
            System.out.print("VENJULEGUR MATUR ");
            return true;
        }
        return false;
    }

    public boolean athugakyssuber() {
        if (fxPacman.getBoundsInParent().intersects(fxKyssuber.getBoundsInParent())) {
            System.out.print("KYSSUBER ");

            return true;
        }
        return false;

    }

    public void athugaVeggtegund1(Veggtegund1 p) {
        if (fxPacman.getBoundsInParent().intersects(p.getBoundsInParent())) {
            erAVegg = true;
            if (fxPacman.getY() < p.getY()) {
                System.out.println("uppi " + fxPacman.getY());
                fxPacman.yProperty().bind(p.getUppfaertYUppi());
                pacmanstefna(90);
            }
            if (fxPacman.getY() > p.getY()) {
                System.out.println("niðri " + fxPacman.getY());
                fxPacman.yProperty().bind(p.getUppfaertYUndir());
                pacmanstefna(270);
            } else {
                erAVegg = false;
                fxPacman.yProperty().unbind();
            }
        }else {
            fxPacman.yProperty().unbind();
            erAVegg = false;
        }
    }

    public void athugaVeggtegund1Draugur(Veggtegund1 p) {
        if (fxDraugur.getBoundsInParent().intersects(p.getBoundsInParent())) {
            erAVeggD = true;
            if (fxDraugur.getY() < p.getY()) {
                draugastefna(90);
                fxDraugur.yProperty().bind(p.getUppfaertYUppi());

            }
            if (fxDraugur.getY() > p.getY()) {
                draugastefna(90);
                fxDraugur.yProperty().bind(p.getUppfaertYUndir());

            } else {
                erAVeggD = false;
                fxDraugur.yProperty().unbind();
            }
        } else {
            erAVeggD = false;
            fxDraugur.yProperty().unbind();
        }
    }



    public void athugaVeggtegund12Draugur(Veggtegund1 p) {
        if (fxDraugur.getBoundsInParent().intersects(p.getBoundsInParent())) {
            erAVeggD = true;
            if (fxDraugur.getY() > p.getY()) {
                draugastefna(90);
                fxDraugur.yProperty().bind(p.getUppfaertYUndir());

            }
        } else {
            erAVeggD = false;
            fxDraugur.yProperty().unbind();
        }

    }

    public void athugaVeggtegund2(Veggtegund2 p) {
        if (fxPacman.getBoundsInParent().intersects(p.getBoundsInParent())) {
            erAVegg = true;
            if (fxPacman.getX ()> p.getX()) {
                fxPacman.xProperty().bind(p.getUppfaertXHaegri());
                pacmanstefna(0);
            }
            if (fxPacman.getX() < p.getX()) {
                fxPacman.xProperty().bind(p.getUppfaertXVinstri());
                pacmanstefna(180);
            } else {
                erAVegg = false;
                fxPacman.xProperty().unbind();
            }
        }else {
            fxPacman.xProperty().unbind();
            erAVegg = false;
        }
    }

    public void athugaVeggtegund2Draugur(Veggtegund2 p) {
        if (fxDraugur.getBoundsInParent().intersects(p.getBoundsInParent())) {
            erAVeggD = true;
            if (fxDraugur.getX() > p.getX()) {
                draugastefna(270);
                fxDraugur.xProperty().bind(p.getUppfaertXHaegri());
                System.out.println("Draugastefna");

            }
            if (fxDraugur.getX() < p.getX()) {
                draugastefna(270);
                System.out.print("niðri ");
                fxDraugur.xProperty().bind(p.getUppfaertXVinstri());

            } else {
                erAVeggD = false;
                fxDraugur.xProperty().unbind();
            }
        }else {
            fxDraugur.xProperty().unbind();
            erAVeggD = false;
        }
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


    public boolean etaMat(Matur f) {
        if (fxPacman.getBoundsInParent().intersects(f.getBoundsInParent())) {
            System.out.println("eta mat");
            return true;
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

    public Kyssuber nyrkyss() {
        if (fxKyssuber != null)
            getChildren().remove(fxKyssuber);
        fxKyssuber = new Kyssuber();
        getChildren().add(fxKyssuber);
        fxKyssuber.stillumKyssuber();
        return fxKyssuber;
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
