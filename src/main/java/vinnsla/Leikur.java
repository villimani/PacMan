package vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Leikur {

    public IntegerProperty stiginPropertyProperty() {
        return stiginProperty;
    }

    private IntegerProperty stiginProperty=new SimpleIntegerProperty();//stigin sem á að birta á leikborðinu

    public int getLivesProperty() {
        return livesProperty.get();
    }

    public IntegerProperty livesPropertyProperty() {
        return livesProperty;
    }

    private IntegerProperty livesProperty=new SimpleIntegerProperty();//lífin sem á að birta á leikborðinu


    /**
     * leikurinn er búinn þannig upphafstilla stiginProperty
     */
    public  void leiklokid() {
        stiginProperty.set(0);
    }



    public  IntegerProperty stig(){
        return stiginProperty;
    }

    public  IntegerProperty lives(){
        return livesProperty;
    }



    public void setStiginProperty(int stiginProperty) {
        this.stiginProperty.set(stiginProperty);
    }

    public void setlivesProperty(int lifProperty) {this.livesProperty.set(lifProperty);}


    /**
     * Hækkar stigin
     */
    public void haekkaStigin(int fjoldistiga) {
        setStiginProperty(stiginProperty.get() + fjoldistiga);
    }

    public void faekkaLif(int lif) {
        setlivesProperty(livesProperty.get() + lif);
    }


}
