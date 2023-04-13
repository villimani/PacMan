package hopverkefni.vidmot;

import javafx.scene.image.ImageView;

public class Draugur extends ImageView {
    public Draugur () {
        FXML_Lestur.lesa(this, "draugur-view.fxml");
    }
    public void afram() {
        PacmanBord p = (PacmanBord) this.getParent();
        if (p.stopPacman()){
            int y = (int) (getY() + p.getWidth() * Math.cos(Math.toRadians(getRotate())));
            int x = (int) (getX() + p.getWidth() * Math.sin(Math.toRadians(getRotate())));
        }else
            setX((int) (getX() + p.getWidth() + (int) Math.cos(Math.toRadians(getRotate())) * 10) % (int) p.getWidth());
    }
}
