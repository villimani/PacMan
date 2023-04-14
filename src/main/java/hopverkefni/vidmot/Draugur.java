package hopverkefni.vidmot;

import javafx.scene.image.ImageView;

public class Draugur extends ImageView {
    public Draugur () {
        FXML_Lestur.lesa(this, "draugur-view.fxml");
    }
    public void afram() {
        PacmanBord p = (PacmanBord) this.getParent();
            setX((int) (getX() + p.getWidth() + (int) Math.cos(Math.toRadians(getRotate())) * 10) % (int) p.getWidth());
    }

    public void stillumDraug(){
        setY(100);
        setX(300);
    }


}
