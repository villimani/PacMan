package hopverkefni.vidmot;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class HjortuBord extends Pane {

    @FXML
    private Hjortu hjarta1;
    @FXML
    private Hjortu hjarta2;
    @FXML
    private Hjortu hjarta3;
    public HjortuBord() {
        FXML_Lestur.lesa(this, "hjortun.fxml");

    }

    public void drepahjarta(int upp) {
        if (upp==3){
            getChildren().remove(hjarta3);
        }
        else if (upp==2){
            getChildren().remove(hjarta2);
        }
        else if (upp==1){
            getChildren().remove(hjarta1);
        }

    }
}

