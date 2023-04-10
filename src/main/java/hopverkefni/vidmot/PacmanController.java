package hopverkefni.vidmot;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import vinnsla.Stefna;

import java.util.HashMap;

import static vinnsla.Stefna.*;

public class PacmanController {


    @FXML
    private ListView<Integer> fxStigin;

    private PacmanBord fxPacmanBord;


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

    public void setStefna(int s) {
        PacmanBord.setStefna(s);
    }

}