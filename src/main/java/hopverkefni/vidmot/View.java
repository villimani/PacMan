package hopverkefni.vidmot;

public enum View {
    LEIKUR("adal-view.fxml"),
    MENU("menu-view.fxml");

    private String fileName;

    /**
     * Constructor fyrir View.
     *
     * @param fileName tekur inn skráar nafn.
     */
    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
