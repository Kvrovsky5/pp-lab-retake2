import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatisticalOperationsImpl implements StatisticalOperations {
    //lista przechowujaca zbiór
    private List<DataSet> dataSets;

    //utworzenie pustej listy zbiorow 
    public StatisticalOperationsImpl() {
        this.dataSets = new ArrayList<>();
    }
    //metoda dodajaca zbior z listy 
    public void addDataSet(DataSet dataSet) {
        dataSets.add(dataSet);
    }
    //metoda usuwajaca zbior z lisyt
    public void removeDataSet(DataSet dataSet) {
        dataSets.remove(dataSet);
    }
    //metoda zwracajaca liste zbiorów
    public List<DataSet> getDataSets() {
        return dataSets;
    }

    @Override //obliczanie średniej arytmetycznej
    public double mean(List<Double> data) {
        if (data.isEmpty()) return 0;
        double sum = 0;
        for (double num : data) {
            sum += num;
        }
        return sum / data.size();
    }

    @Override   //obliczanie mediany 
    public double median(List<Double> data) {
        if (data.isEmpty()) return 0;
        Collections.sort(data);
        int middle = data.size() / 2;
        if (data.size() % 2 == 0) {
            return (data.get(middle - 1) + data.get(middle)) / 2.0;
        } else {
            return data.get(middle);
        }
    }

    @Override   //obliczanie odchylenia standardowego 
    public double standardDeviation(List<Double> data) {
        if (data.isEmpty()) return 0;
        double mean = mean(data);
        double sum = 0;
        for (double num : data) {
            sum += Math.pow(num - mean, 2);
        }
        return Math.sqrt(sum / data.size());
    }
}