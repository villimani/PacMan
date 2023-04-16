package hopverkefni.vidmot;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {
    @FXML
    private Button fxstart;




    public void fxleikur() {
        ViewSwitcher.switchTo(View.LEIKUR);
    }


}
