import java.util.ArrayList;
import java.util.List;

public class DataSet {
    //lista kotra przechowuje liczby rzeczywiste w zbiorze
    private List<Double> data;

    public DataSet() {
        this.data = new ArrayList<>();//tworzenie listy pustej 
    }

    public void addData(double value) { //metoda dodajaca liczbe do zbioru
        data.add(value);
    }

    public void removeData(double value) { //metoda usuwajaca liczbe ze zbioru
        data.remove(value);
    }

    public List<Double> getData() { //metoda zwracajaca liste liczbb 
        return data;
    }
}