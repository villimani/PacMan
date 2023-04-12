package vinnsla;

public enum Stefna {

    VINSTRI(180),
    HAEGRI(0),
    UPP(270),
    NIDUR(90);

    private final int gradur;


    Stefna(int s) {
        gradur = s;
    }

    public int getGradur() {
        return gradur;
    }

}
