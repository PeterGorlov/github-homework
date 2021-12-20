package ua.ithillel.task1;

import java.util.Arrays;

public class MyTestMethod {
    public static <E extends Comparable<E>> void calcNum(E[] array, E value) {
        int count = 0;
        for (E elem : array) {
            if (elem.compareTo(value) < 0) {
                count++;
            }
        }
        System.out.println("Value : " + value + " > in array : " + count);
    }

    public static <E extends Number> void calcSum(E[] array, E value) {
        double count = Arrays.stream(array)
                .filter(x -> x.doubleValue() < value.doubleValue())
                .mapToDouble(e -> e.doubleValue())
                .reduce(0, (a, b) -> a + b);
        System.out.println("Value : " + value + " > in array sum: " + count);
    }


}
