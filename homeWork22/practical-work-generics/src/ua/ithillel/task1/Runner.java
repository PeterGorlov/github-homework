package ua.ithillel.task1;

import java.util.Arrays;

import static ua.ithillel.task1.MyTestMethod.calcNum;
import static ua.ithillel.task1.MyTestMethod.calcSum;

public class Runner {
    private final int ARRAYLENGTH = 10;

    public void run() {
        Integer[] arrayInt = new Integer[ARRAYLENGTH];
        Double[] arrayDouble = new Double[ARRAYLENGTH];
        for (int i = 0; i < ARRAYLENGTH; i++) {
            arrayInt[i] = ARRAYLENGTH * 4 + i;
            arrayDouble[i] = ((Math.random() + 15) - 2) * 3.4;
        }
        System.out.println(Arrays.toString(arrayInt));
        calcNum(arrayInt, 44);
        System.out.println(Arrays.toString(arrayDouble));
        calcNum(arrayDouble, 44.0);
        calcSum(arrayInt, 44);
        calcSum(arrayDouble, 44.5);

    }
}
