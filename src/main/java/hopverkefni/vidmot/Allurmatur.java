package hopverkefni.vidmot;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class Allurmatur extends Pane {

    private final ObservableList<Matur> matur = FXCollections.observableArrayList();

    private ObservableList<Node> fxVeggir = FXCollections.observableArrayList();

    public Allurmatur() {
        FXML_Lestur.lesa(this, "allurmatur.fxml");
        fxVeggir = getChildren();
        for (int i = 0; i < 14; i++) {
            matur.add((Matur) fxVeggir.get(i));
        }

    }


}
