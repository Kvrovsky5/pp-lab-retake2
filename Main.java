import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Tworzenie obiektu Scanner do odczytywania danych wejściowych z konsoli
        StatisticalOperationsImpl statistics = new StatisticalOperationsImpl();

        // dodanie poczatkowych zbiorów
        DataSet ds1 = new DataSet();
        ds1.addData(1.0);
        ds1.addData(2.0);
        ds1.addData(3.0);
        ds1.addData(20.0);

        DataSet ds2 = new DataSet();
        ds2.addData(4.0);
        ds2.addData(5.0);
        ds2.addData(6.0);

        DataSet ds3 = new DataSet();
        ds3.addData(7.0);
        ds3.addData(8.0);
        ds3.addData(9.0);

        statistics.addDataSet(ds1);
        statistics.addDataSet(ds2);
        statistics.addDataSet(ds3);

        while (true) {
            System.out.println("1. Dodaj zbiór ");
            System.out.println("2. usuń zbiór");
            System.out.println("3. wyświetl zbiory");
            System.out.println("4. wyświetl dane zbioru");
            System.out.println("5. wykonaj operacje statystyczne");
            System.out.println("6. Exit");
            int choice = scanner.nextInt(); //oczekiwanie na wybór uzytownika

            switch (choice) {   //wybor za pomoca case
                case 1:
                    DataSet newDataSet = new DataSet();
                    System.out.println("Wpisz numery które zostaną dodane do nowego zbioru (aby zakończyć napisz 'Done')");
                    while (scanner.hasNextDouble()) {
                        newDataSet.addData(scanner.nextDouble());
                    }
                    scanner.next();
                    statistics.addDataSet(newDataSet);
                    break;
                case 2:
                    System.out.println("Podaj index zbioru który chcesz usunąć");
                    int indexToRemove = scanner.nextInt();
                    if (indexToRemove >= 0 && indexToRemove < statistics.getDataSets().size()) {
                        statistics.removeDataSet(statistics.getDataSets().get(indexToRemove));
                    } else {
                        System.out.println("Nieprawidłowy index zbioru, wyświetl zbiory wpisując '3'");
                    }
                    break;
                case 3:
                    displayDataSets(statistics);
                    break;
                case 4:
                    System.out.println("Podaj index zbioru którego dane chcesz wyświetlić:");
                    int indexToDisplay = scanner.nextInt();
                    if (indexToDisplay >= 0 && indexToDisplay < statistics.getDataSets().size()) {
                        displayDataSet(statistics.getDataSets().get(indexToDisplay));
                    } else {
                        System.out.println("Nieprawidłowy index");
                    }
                    break;
                case 5:
                    System.out.println("Podaj index zbioru na którym chcesz wykonać operacje statystyczne:");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < statistics.getDataSets().size()) {
                        DataSet dataSet = statistics.getDataSets().get(index);
                        System.out.println("Wybierz operację: 1. średnia 2. Mediana 3. Odchylenie standardowe");
                        int operation = scanner.nextInt();
                        switch (operation) {
                            case 1:
                                System.out.println("średnia: " + statistics.mean(dataSet.getData()));
                                break;
                            case 2:
                                System.out.println("Mediana: " + statistics.median(dataSet.getData()));
                                break;
                            case 3:
                                System.out.println("odchylenie standardowe: " + statistics.standardDeviation(dataSet.getData()));
                                break;
                            default:
                                System.out.println("Nieprawdłowa operacja");
                        }
                    } else {
                        System.out.println("Nieprawidłowy index");
                    }
                    break;
                case 6:
                    scanner.close();
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór");
            }
        }

    }

    private static void displayDataSets(StatisticalOperationsImpl statistics) {
        System.out.println("Zbiory danych: ");
        for (int i = 0; i < statistics.getDataSets().size(); i++) {
            System.out.println("index zbioru: " + i + " zbiór danych: " + statistics.getDataSets().get(i).getData());
        }
    }
    private static void displayDataSet(DataSet dataSet) {
        System.out.println("Data points in the selected data set: " + dataSet.getData());
    }
}
