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

    /**
     * Stillir hjörtun á leikborðið.
     */
    public void nyrLeikur() {
        hjarta1 = nytthjarta1();
        hjarta2 = nytthjarta2();
        hjarta3 = nytthjarta3();
    }

    /**
     * Eyðir gömlum hjörtum ef eru og stillir ný allstaðar.
     */
    public Hjortu nytthjarta1() {
        if (hjarta1 != null)
            getChildren().remove(hjarta1);
        hjarta1 = new Hjortu();
        getChildren().add(hjarta1);
        hjarta1.stillumhjarta1();
        return hjarta1;
    }
    public Hjortu nytthjarta2() {
        if (hjarta2 != null)
            getChildren().remove(hjarta2);
        hjarta2 = new Hjortu();
        getChildren().add(hjarta2);
        hjarta2.stillumhjarta2();
        return hjarta2;
    }
    public Hjortu nytthjarta3() {
        if (hjarta3 != null)
            getChildren().remove(hjarta3);
        hjarta3 = new Hjortu();
        getChildren().add(hjarta3);
        hjarta3.stillumhjarta3();
        return hjarta3;
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

