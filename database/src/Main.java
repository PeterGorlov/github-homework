import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

public class Main {

    static List<String> listOfCustomers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        printMap(fillTreeMap(readFileAndReturnOrderList()));
    }

    private static List<Order> readFileAndReturnOrderList() throws IOException {
        File file = new File("BD.txt");
        FileReader fr = new FileReader(file);

        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();

        List<Order> listOfOrders = new ArrayList<>();
        while (line != null) {
            String[] subStr;
            subStr = line.split(" ");
            if (!listOfCustomers.contains(subStr[0])) {
                listOfCustomers.add(subStr[0]);
            }
            listOfOrders.add(new Order(subStr[0], subStr[1], Integer.parseInt(subStr[2])));
            line = reader.readLine();
        }
        return listOfOrders;
    }

    private static TreeMap<String, TreeMap<String, Integer>> fillTreeMap(List<Order> listOfOrders) {
        TreeMap<String, TreeMap<String, Integer>> data = new TreeMap<>();
        for (String s : listOfCustomers) {
            TreeMap<String, Integer> gudAndCount = new TreeMap<>();
            for (Order o : listOfOrders) {
                if (Objects.equals(o.getCustomer(), s)) {
                    if (!gudAndCount.containsKey(o.getGud())) {
                        gudAndCount.put(o.getGud(), o.getCount());
                    } else {
                        gudAndCount.put(o.getGud(), gudAndCount.get(o.getGud()) + o.getCount());
                    }
                }
            }
            data.put(s, gudAndCount);
        }
        return data;
    }

    private static void printMap(TreeMap<String, TreeMap<String, Integer>> data) {
        data.forEach((K, V) -> {
            System.out.println(K + ":");
            V.forEach((X,Y) -> System.out.println(X + " " + Y));
            System.out.println();
        });
    }
}