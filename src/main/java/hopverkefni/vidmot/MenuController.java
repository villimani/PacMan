package hopverkefni.vidmot;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import vinnsla.Leikur;

public class MenuController {
    @FXML
    private Button fxstart;

    private Leikur leikur;





    public void fxleikur() {
        ViewSwitcher.switchTo(View.LEIKUR);
    }


}
