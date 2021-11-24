import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MainListerator {
    private static List<String> arrayList = new ArrayList<>();
    private static List<String> linkedList = new LinkedList<>();
    private final static int SIZE = 10;

    public static void main(String[] args) {
        initializationList();
        taskFirst(arrayList, linkedList);
        taskSecond(arrayList, linkedList);
    }

    public static void initializationList() {
        for (int i = 0; i < SIZE; i++) {
            arrayList.add("ar_" + i);
            linkedList.add(randomNumber(i), "li_" + i);
        }
        System.out.println(linkedList);
        System.out.println(arrayList);
    }

    private static int randomNumber(int maxValue) {
        return (int) (Math.random() * (maxValue));
    }

    public static void taskFirst(List<String> listArray, List<String> listLink) {
        List<String> arrayListTask1 = new ArrayList<>(listArray);
        List<String> linkListTask1 = new LinkedList<>(listLink);
        ListIterator<String> iterator = arrayListTask1.listIterator(listArray.size());
        int count = 0;
        for (int i = 0; i < arrayListTask1.size(); i++) {
            linkListTask1.add(count, iterator.previous());
            count += 2;
        }
        System.out.println(linkListTask1);
    }

    public static void taskSecond(List<String> listArray, List<String> listLink) {
        List<String> arrayListTask2 = new ArrayList<>(listArray);
        List<String> linkListTask2 = new LinkedList<>(listLink);
        ListIterator<String> iterator = arrayListTask2.listIterator(listArray.size());
        int count = 0;
        for (int i = 0; i < arrayListTask2.size(); i++) {
            if (count < linkListTask2.size()) {
                linkListTask2.add(count, iterator.previous());
                count += 3;
            } else {
                linkListTask2.add(iterator.previous());
                count++;
            }

        }
        System.out.println(linkListTask2);

    }
}
