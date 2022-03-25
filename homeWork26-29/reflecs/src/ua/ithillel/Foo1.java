package ua.ithillel;

import anotation.Start;

@Start(priority = 1)
public class Foo1 {

    public void run() {
        System.out.println("Class Foo1 initialize");
    }

}
