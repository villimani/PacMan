package hopverkefni.vidmot;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Rectangle;

public class Veggtegund2 extends Rectangle {

    private DoubleProperty uppfaertXProperty = new SimpleDoubleProperty(); // Tengir pallinn við boltann
    public Veggtegund2() {
        FXML_Lestur.lesa(this, "veggtegund2.fxml");
    }

    /**
     * Skilar aðeins hærri X staðsetningu veggsins. (staðsetning hægra megin við vegg)
     */
    public DoubleProperty getUppfaertXHaegri(){
        uppfaertXProperty.set(xProperty().get() + 31);
        return uppfaertXProperty;
    }

    /**
     * Skilar aðeins lægri X staðsetningu veggsins. (staðsetning vinstra megin við vegg)
     */
    public DoubleProperty getUppfaertXVinstri(){
        uppfaertXProperty.set(xProperty().get() - 31);
        System.out.println();
        return uppfaertXProperty;
    }
}
