package ua.ithillel;

import anotation.Start;

@Start(priority = 4, method = "initialized")
public class Foo4 {

    public void run() {
        throw new IllegalStateException("This method should not be called");
    }

    public void initialized() {
        System.out.println("Class Foo4 initialize");

    }
}
