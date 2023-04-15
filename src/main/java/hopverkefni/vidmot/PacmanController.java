package hopverkefni.vidmot;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import vinnsla.Leikur;
import vinnsla.Stefna;

import java.util.HashMap;
import java.util.Optional;

import static vinnsla.Stefna.*;

public class PacmanController {

    public static final String VILTU_HALDA_AFRAM = " : Viltu reyna aftur?";

    public static final String VILTU_HALDA_AFRAMB = " : Viltu spila aftur?";

    public static final String PAC = "Þú ert búinn með lífin þín";

    public static final String PACB = "Til hamingju þú vannst!";
    @FXML
    private ListView<String> fxStigin;

    @FXML
    private PacmanBord fxPacmanBord;

    @FXML
    private Label fxStig;

    private Timeline t;

    public Leikur getLeikur() {
        return leikur;
    }

    private Leikur leikur;


    public HjortuBord fxHjortuBord;

    public static final int INTERVAL = 50;


    @FXML
    private final HashMap<KeyCode, Stefna> map=new HashMap<>();// Setur upp stefnu


    public void initialize() {
        leikur = new Leikur();      // búa til vinnsluna
        fxStigin.setItems(leikur.getStigin());  // setja upp listann
        fxStigin.setFocusTraversable(false);    // ekki hægt að focus-a á listann
    }
    public void orvatakkar() {
        map.put(KeyCode.UP, UPP);
        map.put(KeyCode.DOWN, NIDUR);
        map.put(KeyCode.RIGHT, HAEGRI);
        map.put(KeyCode.LEFT, VINSTRI);
        fxStigin.getScene().addEventFilter(KeyEvent.ANY,event->{
            adgerdLykill(event);
                });
    }

   private void adgerdLykill(KeyEvent event) {
        try {
            if (map.get(event.getCode()) == null) {
                event.consume();
            }
            else {
                this.setStefna(map.get(event.getCode()).getGradur());
                System.out.print(map.get(event.getCode()));
            }
        } catch (NullPointerException n) {
            event.consume();
        }
    }


    public void hefjaLeik() {
        fxStig.textProperty().
                bind(leikur.stig().asString());
        leikur.setlivesProperty(3);
        KeyFrame k = new KeyFrame(Duration.millis(INTERVAL),
                e -> {
                    fxPacmanBord.veggjaStopp();
                    fxPacmanBord.afram();
                    fxPacmanBord.aframDraugar();
                    if(fxPacmanBord.bordaMat()) {
                        leikur.haekkaStigin(10);
                    }
                    if(fxPacmanBord.bordaFeitanMat()) {
                        leikur.haekkaStigin(100);
                    }
                    if (fxPacmanBord.missaLif()){
                        if (leikur.getLivesProperty()-1==0){
                            stoppaleik();
                            Platform.runLater(() -> synaAlertA("Leikmaður"));
                        }
                        forADraug();
                        fxHjortuBord.drepahjarta(leikur.getLivesProperty()+1);
                    }
                    if (leikur.getStiginProperty()==540){
                        Platform.runLater(() -> synaAlertB("Leikmaður"));
                        stoppaleik();
                    }
                });
        t = new Timeline(k);
        t.setCycleCount(Timeline.INDEFINITE);   // leikurinn leikur endalaust
        t.play();
    }

    private void synaAlertA(String s) {
        Alert a = new AdvorunDialog("", PAC, s + VILTU_HALDA_AFRAM);
        Optional<ButtonType> u = a.showAndWait();
        if (u.isPresent() && !u.get().getButtonData().isCancelButton())
            nyrLeikur();
    }

    private void synaAlertB(String s) {
        Alert a = new AdvorunDialog("", PACB, s + VILTU_HALDA_AFRAMB);
        Optional<ButtonType> u = a.showAndWait();
        if (u.isPresent() && !u.get().getButtonData().isCancelButton())
            nyrLeikur();
    }

    public void nyrLeikur() {
        fxPacmanBord.nyrLeikur();
        fxHjortuBord.nyrLeikur();
        leikur.setlivesProperty(3);
        t.play();
    }

    public void forADraug() {
        leikur.missirlif();
        fxPacmanBord.endurstilla();
    }

    public void stoppaleik() {
        t.stop();
        leikur.leiklokid();
    }


    public void setStefna(int s) {
        fxPacmanBord.setStefna(s);
    }

}