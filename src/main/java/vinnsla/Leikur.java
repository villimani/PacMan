package vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Leikur {

    private final ObservableList<String> stigatafla = FXCollections.observableArrayList();

    public IntegerProperty stiginPropertyProperty() {
        return stiginProperty;
    }

    private int fjoldiTilrauna = 1;

    public int getStiginProperty() {
        return stiginProperty.get();
    }

    private IntegerProperty stiginProperty=new SimpleIntegerProperty();//stigin sem á að birta á leikborðinu

    public String getNafnProperty() {
        return nafnProperty.get();
    }

    public StringProperty nafnPropertyProperty() {
        return nafnProperty;
    }

    private StringProperty nafnProperty=new SimpleStringProperty();//nafn sem á að birta á leikborðinu

    public int getLivesProperty() {
        return livesProperty.get();
    }

    public void setnafnProperty(String nafn) {
        nafnProperty.set(nafn);
    }

    public IntegerProperty livesPropertyProperty() {
        return livesProperty;
    }

    private IntegerProperty livesProperty=new SimpleIntegerProperty();//lífin sem á að birta á leikborðinu


    /**
     * leikurinn er búinn þannig upphafstilla stiginProperty
     */
    public void leiklokid() {
        stigatafla.add(+ fjoldiTilrauna +" " + getNafnProperty() + " "+ stiginProperty.get() + " ");
        fjoldiTilrauna++;
        stiginProperty.set(0);
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



    public ObservableList<String> getStigin() {
        return stigatafla;
    }

}
