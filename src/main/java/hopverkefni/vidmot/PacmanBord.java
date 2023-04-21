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
    private Draugur fxDraugur2;




    @FXML
    private Allurmatur fxAllurmatur;

    @FXML
    private Pane fxGeymsla;

    @FXML
    private Kyssuber fxKyssuber;


    private ObservableList<Node> fxVeggir = FXCollections.observableArrayList();

    private ObservableList<Node> matur = FXCollections.observableArrayList();
    private ObservableList<Node> maturGeymsla = FXCollections.observableArrayList();
    private ObservableList<Kyssuber> kyssubers = FXCollections.observableArrayList();
    private final ObservableList<FeiturMatur> feiturMatur = FXCollections.observableArrayList();

    public PacmanBord() {

        FXML_Lestur.lesa(this, "leikbord-view.fxml");
        fxVeggir = getChildren();
        matur= fxAllurmatur.getChildren();


        System.out.print(fxVeggir.size());

        // Stilla lista með feita matnum
        for (int i = 4; i < 8; i++) {
            feiturMatur.add((FeiturMatur) fxVeggir.get(i));
        }

        draugastefna2(270);
    }

    /**
     * Endurstillir alla leikhluti á leikborðinu.
     */
    public void setBord (){
        getChildren().removeAll(getChildren());

        // lesa inn aftur upp á nýtt
        FXML_Lestur.lesa(this, "leikbord-view.fxml");
        fxVeggir = getChildren();
        matur = fxAllurmatur.getChildren();

        // Stilla lista með feita matnum
        for (int i = 4; i <8; i++) {
            feiturMatur.add((FeiturMatur) fxVeggir.get(i));
        }
        fxKyssuber.relocate(275, 225);

    }

    /**
     * Hreyfir pacman áfram.
     */
    public void afram() {
        fxPacman.afram();
    }

    /**
     * Stjórnar átt pacmans.
     *
     * @param upp tekur inn gráður sem ákvarðar áttina sem pacman snýr í.
     */
    public void setStefna(int upp) {
        fxPacman.setRotate(upp);
    }

    /**
     * Hreyfir draugana áfram.
     */
    public void aframDraugar() {
        fxDraugur.afram();
        fxDraugur2.afram();


    }

    /**
     * Smiður sem setur titil, haus og spurningu í Alert dialog
     *
     * @param a tekur inn gráður sem ákvarðar áttina sem draugurinn snýr í.
     */
    public void draugastefna(int a) {
       fxDraugur.setRotate(a);
    }

    public void draugastefna2(int a) {
        fxDraugur2.setRotate(a);
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

    /**
     * Kíkir hvort að Pacman snertir grænann mat og eyðir honum þá.
     */
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

    /**
     * Kíkir hvort að Pacman snerti kirsuber og eyðir því þá.
     */
    public boolean bordakyssuber() {
        if (athugakyssuber()){
            fxKyssuber.relocate(800,900);
            return true;
        }
        return false;
    }


    /**
     * Kíkir hvort að Pacman snertir veggtegund 1 (lárétt) eða veggtegund 2 (lóðrétt).
     */
    public void veggjaStopp() {
        for (int i = 8; i < fxVeggir.size() - 3; i++) {
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

    /**
     * Kíkir hvort að draugur snerti veggtegund1 (lárétt) eða veggtegund2 (lóðrétt).
     */
    public void veggjaStoppD() {
        for (int i= 8; i < fxVeggir.size() - 3; i++) {
            Rectangle p = (Rectangle) fxVeggir.get(i);
            if (p.getWidth() > 11) {
                Veggtegund1 v = (Veggtegund1) fxVeggir.get(i);
                athugaVeggtegund1Draugur(v);
                athugaVeggtegund1Draugur2(v);


            } else {
                Veggtegund2 v = (Veggtegund2) fxVeggir.get(i);
                athugaVeggtegund2Draugur(v);
                athugaVeggtegund2Draugur2(v);


            }
        }
    }

    /**
     * Endurstillir Pacman og draug í upphafsstöður á leikborði.
     */
    public void endurstilla() {
        nyrPac();
        nyrDraugur();
        nyrDraugur2();

    }

    /**
     * Kíkir hvort að Pacman snertir feitan mat.
     */
    public boolean athugaFeitanMat(FeiturMatur f) {
        if (fxPacman.getBoundsInParent().intersects(f.getBoundsInParent())) {
            System.out.print("FVENJULEGUR MATUR ");
            return true;
        }
        return false;
    }

    /**
     * Kíkir hvort að leikmaður snerti venjulegan mat.
     */
    public boolean athugaMat(Node f) {
        if (fxPacman.getBoundsInParent().intersects(f.getBoundsInParent())) {
            System.out.print("VENJULEGUR MATUR ");
            return true;
        }
        return false;
    }

    /**
     * Kíkir hvort að leikmaður snerti kirsuber.
     */
    public boolean athugakyssuber() {
        if (fxPacman.getBoundsInParent().intersects(fxKyssuber.getBoundsInParent())) {
            System.out.print("KYSSUBER ");
            fxKyssuber.relocate(800,900);
            return true;
        }
        return false;

    }

    /**
     * Kíkir hvort leikmaður snertir veggtegund 1 (lárétt) og hvort hann er fyrir ofan eða neðan.
     */
    public void athugaVeggtegund1(Veggtegund1 p) {
        if (fxPacman.getBoundsInParent().intersects(p.getBoundsInParent())) {

            if (fxPacman.getY() < p.getY()) {
                System.out.println("uppi " + fxPacman.getY());
                fxPacman.yProperty().bind(p.getUppfaertYUppi());
            }
            if (fxPacman.getY() > p.getY()) {
                System.out.println("niðri " + fxPacman.getY());
                fxPacman.yProperty().bind(p.getUppfaertYUndir());
            } else {
                fxPacman.yProperty().unbind();
            }
        }else {
            fxPacman.yProperty().unbind();
        }
    }

    /**
     * Kíkir hvort að draugur snerti veggtegund 1 (lárétt) og hvort hann er fyrir ofan eða neðan.
     */
    public void athugaVeggtegund1Draugur(Veggtegund1 p) {
        if (fxDraugur.getBoundsInParent().intersects(p.getBoundsInParent())) {

            if (fxDraugur.getY() < p.getY()) {
                draugastefna(270);
                System.out.println("270");
                fxDraugur.yProperty().bind(p.getUppfaertYUppi());

            }
            if (fxDraugur.getY() > p.getY()) {
                draugastefna(90);
                System.out.println("90");
                fxDraugur.yProperty().bind(p.getUppfaertYUndir());

            } else {

                fxDraugur.yProperty().unbind();
            }
        } else{

            fxDraugur.yProperty().unbind();
        }
    }

    public void athugaVeggtegund1Draugur2(Veggtegund1 p) {
        if (fxDraugur2.getBoundsInParent().intersects(p.getBoundsInParent())) {
            if (fxDraugur2.getY() < p.getY()) {
                draugastefna2(180);
                System.out.println("270");
                fxDraugur2.yProperty().bind(p.getUppfaertYUppi());

            }
            if (fxDraugur2.getY() > p.getY()) {
                draugastefna2(0);
                System.out.println("90");
                fxDraugur2.yProperty().bind(p.getUppfaertYUndir());

            } else {

                fxDraugur2.yProperty().unbind();
            }
        } else{

            fxDraugur2.yProperty().unbind();
        }
    }










    public void athugaVeggtegund2(Veggtegund2 p) {
        if (fxPacman.getBoundsInParent().intersects(p.getBoundsInParent())) {

            if (fxPacman.getX ()> p.getX()) {
                fxPacman.xProperty().bind(p.getUppfaertXHaegri());

            }
            if (fxPacman.getX() < p.getX()) {
                fxPacman.xProperty().bind(p.getUppfaertXVinstri());

            } else {

                fxPacman.xProperty().unbind();
            }
        }else {
            fxPacman.xProperty().unbind();

        }
    }

    /**
     * Kíkir hvort að draugur er að snerta veggtegund 2 (lóðrétt) og hvort hann er hægra eða vinstra megin við hann.
     */
    public void athugaVeggtegund2Draugur(Veggtegund2 p) {
        if (fxDraugur.getBoundsInParent().intersects(p.getBoundsInParent())) {

            if (fxDraugur.getX() > p.getX()) {
                    draugastefna(0);
                    System.out.println("180");
                fxDraugur.xProperty().bind(p.getUppfaertXHaegri());
                System.out.println("Draugastefna");

            }
            if (fxDraugur.getX() < p.getX()) {
                    draugastefna(180);
                    System.out.println("0");
                System.out.print("niðri ");
                fxDraugur.xProperty().bind(p.getUppfaertXVinstri());

            } else {

                fxDraugur.xProperty().unbind();
            }
        }else {
            fxDraugur.xProperty().unbind();

        }
    }

    public void athugaVeggtegund2Draugur2(Veggtegund2 p) {
        if (fxDraugur2.getBoundsInParent().intersects(p.getBoundsInParent())) {

            if (fxDraugur2.getX() > p.getX()) {
                draugastefna2(90);
                System.out.println("180");
                fxDraugur2.xProperty().bind(p.getUppfaertXHaegri());
                System.out.println("Draugastefna");

            }
            if (fxDraugur2.getX() < p.getX()) {
                draugastefna2(270);
                System.out.println("0");
                System.out.print("niðri ");
                fxDraugur2.xProperty().bind(p.getUppfaertXVinstri());

            } else {

                fxDraugur2.xProperty().unbind();
            }
        }else {
            fxDraugur2.xProperty().unbind();

        }
    }










    public boolean missaLif() {
        if (fxPacman.getBoundsInParent().intersects(fxDraugur.getBoundsInParent())) {
            System.out.println("missa lif");
            return true;
        }else if (fxPacman.getBoundsInParent().intersects(fxDraugur2.getBoundsInParent())) {
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

    /**
     * Eyðir Pacman og býr til nýtt á leikborði.
     */
    public Kyssuber nyrkyss() {
        if (fxKyssuber != null)
            getChildren().remove(fxKyssuber);
        fxKyssuber = new Kyssuber();
        getChildren().add(fxKyssuber);
        fxKyssuber.stillumKyssuber();
        return fxKyssuber;
    }

    /**
     * Eyðir draug og býr til nýjan í upphafsstöðu á leikborði.
     */
    public Draugur nyrDraugur() {
        if (fxDraugur != null)
            getChildren().remove(fxDraugur);
        fxDraugur = new Draugur();
        getChildren().add(fxDraugur);
        fxDraugur.stillumDraug();
        return fxDraugur;
    }

    public Draugur nyrDraugur2() {
        if (fxDraugur2 != null)
            getChildren().remove(fxDraugur2);
        fxDraugur2 = new Draugur();
        getChildren().add(fxDraugur2);
        fxDraugur2.stillumDraug();
        return fxDraugur2;
    }


}
