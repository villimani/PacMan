package hopverkefni.vidmot;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import vinnsla.Leikur;
import vinnsla.Stefna;

import java.util.HashMap;

import static vinnsla.Stefna.*;

public class PacmanController {


    @FXML
    private ListView<Integer> fxStigin;

    @FXML
    private PacmanBord fxPacmanBord;

    @FXML
    private Label fxStig;

    private Timeline t;

    private Leikur leikur;
    @FXML
    private Label fxLif;

    public static final int INTERVAL = 50;


    @FXML
    private final HashMap<KeyCode, Stefna> map=new HashMap<>();// Setur upp stefnu


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
        leikur = new Leikur();
        fxStig.textProperty().
                bind(leikur.stig().asString());
        fxLif.textProperty().
                bind(leikur.lives().asString());
        leikur.setlivesProperty(3);
        KeyFrame k = new KeyFrame(Duration.millis(INTERVAL),
                e -> {
                    fxPacmanBord.afram();
                    fxPacmanBord.aframDraugar();
                    fxPacmanBord.veggjaStopp();
                    fxPacmanBord.missaLif();
                    if(fxPacmanBord.bordarmat()) {
                        System.out.println("Plús 10");
                        leikur.haekkaStigin(10);
                    }
                    if(fxPacmanBord.bordarfeitannmat()) {
                        System.out.println("Plús 100");
                        leikur.haekkaStigin(100);
                    }
                    if (fxPacmanBord.missaLif()){
                        leikur.faekkaLif(-1);
                    }

                });
        t = new Timeline(k);
        t.setCycleCount(Timeline.INDEFINITE);   // leikurinn leikur endalaust
        t.play();
    }





    public void setStefna(int s) {
        fxPacmanBord.setStefna(s);
    }

}