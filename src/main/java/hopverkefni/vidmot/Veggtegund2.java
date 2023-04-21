package hopverkefni.vidmot;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Rectangle;

public class Veggtegund2 extends Rectangle {

    private DoubleProperty uppfaertXProperty = new SimpleDoubleProperty(); // Tengir pallinn við boltann
    public Veggtegund2() {
        FXML_Lestur.lesa(this, "veggtegund2.fxml");
    }

    // Hægra megin við vegg
    public DoubleProperty getUppfaertXHaegri(){
        uppfaertXProperty.set(xProperty().get() + 40);
        return uppfaertXProperty;
    }
    // Vinstra megin við vegg
    public DoubleProperty getUppfaertXVinstri(){
        uppfaertXProperty.set(xProperty().get() - 40);
        System.out.println();
        return uppfaertXProperty;
    }
}
