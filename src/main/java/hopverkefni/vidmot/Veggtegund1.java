package hopverkefni.vidmot;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Rectangle;

public class Veggtegund1 extends Rectangle {

    private DoubleProperty uppfaertYProperty = new SimpleDoubleProperty(); // Tengir pallinn við boltann
    public Veggtegund1() {
        FXML_Lestur.lesa(this, "veggtegund1.fxml");
    }

    public DoubleProperty getUppfaertYUppi(){
        uppfaertYProperty.set(yProperty().get() - 39);
        System.out.print("frá ofan ");
        return uppfaertYProperty;
    }

    public DoubleProperty getUppfaertYUndir(){
        uppfaertYProperty.set(yProperty().get() + 60);
        System.out.print("frá neðan ");
        return uppfaertYProperty;
    }

}
