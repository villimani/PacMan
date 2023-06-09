package hopverkefni.vidmot;

import javafx.scene.image.ImageView;

public class Draugur extends ImageView {

    public Draugur () {
        FXML_Lestur.lesa(this, "draugur-view.fxml");
    }

    /**
     * Færir drauginn áfram samkvæmt hvaða átt hann snýr í.
     */
    public void afram() {
        PacmanBord p = (PacmanBord) this.getParent();
        if (getRotate() == 0) {
            setY((int) (getY() + p.getHeight() + (int) Math.sin(Math.toRadians(90)) * 10) % (int) p.getHeight());
        } else if (getRotate() == 180) {
            setX((int) (getX() + p.getWidth() + (int) Math.cos(Math.toRadians(180)) * 10) % (int) p.getWidth());
        } else if (getRotate() == 90) {
            setX((int) (getX() + p.getWidth() + (int) Math.cos(Math.toRadians(0)) * 10) % (int) p.getWidth());
        } else if (getRotate() == 270) {
            setY((int) (getY() + p.getHeight() + (int) Math.sin(Math.toRadians(getRotate())) * 10) % (int) p.getHeight());
        }
    }

    /**
     * Stillir staðsetningu draugs á leikborði.
     */
    public void stillumDraug(){
        setY(225);
        setX(275);
    }


}
