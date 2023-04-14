package vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Leikur {

    private final ObservableList<Integer> stigatafla = FXCollections.observableArrayList();

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
        stigatafla.add(stiginProperty.get());
    }

    public void missirlif() {
        setlivesProperty(getLivesProperty()-1);
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



    public ObservableList<Integer> getStigin() {
        return stigatafla;
    }

}
