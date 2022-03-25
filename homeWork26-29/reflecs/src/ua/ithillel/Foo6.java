package ua.ithillel;

import anotation.Start;

@Start(priority = 5, method = "initialized")
public class Foo6 {

    public void run() {
        throw new IllegalStateException("This method should not be called");
    }

    public void initialized() {
        System.out.println("Class Foo6 initialize");

    }
}
