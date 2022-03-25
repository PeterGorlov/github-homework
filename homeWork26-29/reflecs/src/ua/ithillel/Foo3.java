package ua.ithillel;

import anotation.Start;

@Start(priority = 3)
public class Foo3 {

    public void run() {
        System.out.println("Class Foo3 initialize");
    }


}
