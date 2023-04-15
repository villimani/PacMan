package hopverkefni.vidmot;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Rectangle;

public class Veggtegund2 extends Rectangle {

    private DoubleProperty uppfaertXProperty = new SimpleDoubleProperty(); // Tengir pallinn við boltann
    public Veggtegund2() {
        FXML_Lestur.lesa(this, "veggtegund2.fxml");
    }

    public DoubleProperty getUppfaertXUppi(){
        uppfaertXProperty.set(xProperty().get() + 37);
        System.out.print("frá ofan ");
        return uppfaertXProperty;
    }
    public DoubleProperty getUppfaertXUndir(){
        uppfaertXProperty.set(xProperty().get()-37);
        System.out.print("frá neðan ");
        return uppfaertXProperty;
    }
}
