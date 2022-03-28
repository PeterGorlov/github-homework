package ua.ithillel.testfoo;

import anotation.Start;

@Start(priority = 7)
public class Foo7 {

    public void run() {
        System.out.println("Class Foo7 initialize");
    }

}
