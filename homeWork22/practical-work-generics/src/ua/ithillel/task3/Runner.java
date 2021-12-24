package ua.ithillel.task3;

import java.util.Arrays;

public class Runner {
    public void run() {
        MyMixer myMixer = new MyMixer(new Integer[]{1, 2, 3, 4});
        MyMixer myMixer2 = new MyMixer(new String[]{"Hello", "Davai", "Kyky", "Zapara"});

        System.out.println(Arrays.toString(myMixer.getArray()));
        myMixer.shuffle();
        System.out.println(Arrays.toString(myMixer.getArray()));
        System.out.println("///////////////////////////////////");
        System.out.println(Arrays.toString(myMixer2.getArray()));
        myMixer2.shuffle();
        System.out.println(Arrays.toString(myMixer2.getArray()));
    }
}
