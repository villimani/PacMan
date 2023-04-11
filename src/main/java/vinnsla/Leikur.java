package vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Leikur {

    public IntegerProperty stiginPropertyProperty() {
        return stiginProperty;
    }

    private IntegerProperty stiginProperty=new SimpleIntegerProperty();//stigin sem á að birta á leikborðinu

    /**
     * leikurinn er búinn þannig upphafstilla stiginProperty
     */
    public  void leiklokid() {
        stiginProperty.set(0);
    }



    public  IntegerProperty stig(){
        return stiginProperty;
    }



    public void setStiginProperty(int stiginProperty) {
        this.stiginProperty.set(stiginProperty);
    }

    /**
     * Hækkar stigin
     */
    public void haekkaStigin(int fjoldistiga) {
        setStiginProperty(stiginProperty.get() + fjoldistiga);
    }

}
