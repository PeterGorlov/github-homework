import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        NumberGenerator ng = new NumberGenerator(10, -5, 10);
        List<Integer> list = ng.generateList();
        Set<Integer> list2 = ng.generateSet();
        System.out.println(list.toString());
        System.out.println(list2.toString());
    }
}
