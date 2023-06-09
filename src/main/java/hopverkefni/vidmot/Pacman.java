package hopverkefni.vidmot;

import javafx.scene.image.ImageView;

public class Pacman extends ImageView {
    public Pacman() {
        FXML_Lestur.lesa(this, "pacman-view.fxml");
    }

    /**
     * Færir pacman áfram samkvæmt áttinni sem hann snýr í.
     */
    public void afram() {
        PacmanBord p = (PacmanBord) this.getParent();
        if (getRotate() == 90) {
            setY((int) (getY() + p.getHeight() + (int) Math.sin(Math.toRadians(90)) * 10) % (int) p.getHeight());
        } else if (getRotate() == 180) {
            setX((int) (getX() + p.getWidth() + (int) Math.cos(Math.toRadians(180)) * 10) % (int) p.getWidth());
        } else if (getRotate() == 0) {
            setX((int) (getX() + p.getWidth() + (int) Math.cos(Math.toRadians(0)) * 10) % (int) p.getWidth());
        } else if (getRotate() == 270) {
            setY((int) (getY() + p.getHeight() + (int) Math.sin(Math.toRadians(getRotate())) * 10) % (int) p.getHeight());
        }
    }

    /**
     * Stillir staðsetningu pacmans á leikborði.
     */
    public void stillumPacman(){
        setY(424);
        setX(285);
    }




}
