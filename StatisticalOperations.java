import java.util.List;

public interface StatisticalOperations {
    double mean(List<Double> data);
    double median(List<Double> data);
    double standardDeviation(List<Double> data);
}