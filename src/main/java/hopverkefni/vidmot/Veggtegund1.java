package hopverkefni.vidmot;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Rectangle;

public class Veggtegund1 extends Rectangle {

    private DoubleProperty uppfaertYProperty = new SimpleDoubleProperty(); // Tengir pallinn við boltann
    public Veggtegund1() {
        FXML_Lestur.lesa(this, "veggtegund1.fxml");
    }

    /**
     * Skilar aðeins efri Y staðsetningu veggsins. (staðsetning fyrir ofan vegg)
     */
    public DoubleProperty getUppfaertYUppi(){
        uppfaertYProperty.set(yProperty().get()-31);
        return uppfaertYProperty;
    }

    /**
     * Skilar aðeins lægri Y staðsetningu veggsins. (staðsetning fyrir neðan vegg)
     */
    public DoubleProperty getUppfaertYUndir(){
        uppfaertYProperty.set(yProperty().get()+31);
        return uppfaertYProperty;
    }

}
