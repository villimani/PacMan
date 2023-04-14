package hopverkefni.vidmot;

import javafx.scene.image.ImageView;

public class Pacman extends ImageView {
    public Pacman() {
        FXML_Lestur.lesa(this, "pacman-view.fxml");
    }

    public void afram() {
        PacmanBord p = (PacmanBord) this.getParent();
            if (getRotate() == 180) {
                setX((int) (getX() + p.getWidth() + (int) Math.cos(Math.toRadians(getRotate())) * 10) % (int) p.getWidth());
            } else if (getRotate() == 90) {
                setY((int) (getY() + p.getHeight() + (int) Math.sin(Math.toRadians(getRotate())) * 10) % (int) p.getHeight());
            } else if (getRotate() == 0) {
                setX((int) (getX() + p.getWidth() + (int) Math.cos(Math.toRadians(getRotate())) * 10) % (int) p.getWidth());
            } else {
                setY((int) (getY() + p.getHeight() + (int) Math.sin(Math.toRadians(getRotate())) * 10) % (int) p.getHeight());
            }

    }

    public void stillumPacman(){
        setY(100);
        setX(100);
    }



}
