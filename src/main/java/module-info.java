module hopverkefni.vidmot {
    requires javafx.controls;
    requires javafx.fxml;


    opens hopverkefni.vidmot to javafx.fxml;
    exports hopverkefni.vidmot;
}