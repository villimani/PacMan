package hopverkefni.vidmot;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;


public class AdvorunDialog extends Alert {  // Erfir frá Alert
    private static final String I_LAGI = "Aftur í menu";
    public static final ButtonType BTYPE = new ButtonType(I_LAGI,
            ButtonBar.ButtonData.OK_DONE);



    /**
     * Smiður sem setur titil, haus og spurningu í Alert dialog
     *
     * @param titill   titillinn
     * @param haus     hausinn
     * @param spurning spurning sem borin er upp
     */
    public AdvorunDialog(String titill, String haus, String spurning) {
        super(AlertType.NONE, spurning, BTYPE);  // kallar á smið yfirklasans
        setTitle(titill);
        setHeaderText(haus);
    }
}

