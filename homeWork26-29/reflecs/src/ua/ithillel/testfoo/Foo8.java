package ua.ithillel.testfoo;

import anotation.Start;

@Start(priority = 8, method = "initialized")
public class Foo8 {

    public void run() {
        throw new IllegalStateException("This method should not be called");
    }

    public void initialized() {
        System.out.println("Class Foo8 initialize");

    }
}
