package ua.ithillel.task3;

import java.util.Random;

public class MyMixer<T> {
    private T[] array;

    public MyMixer(T[] array) {
        this.array = array;
    }

    public void shuffle() {
        Random gen = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = gen.nextInt(i + 1);
            T a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
    }

    public T[] getArray() {
        return array;
    }
}
