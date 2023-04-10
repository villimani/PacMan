package hopverkefni.vidmot;

import javafx.scene.image.ImageView;

public class Pacman extends ImageView {
    public Pacman() {
        FXML_Lestur.lesa(this, "pacman-view.fxml");
    }

    public void afram() {
        PacmanBord p = (PacmanBord) this.getParent();
        setX((int) (getX() + p.getWidth() + (int) Math.cos(Math.toRadians(getRotate())) * 10) % (int) p.getWidth());
    }
}
