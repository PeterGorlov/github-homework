package ua.ithillel;

import anotation.Start;

@Start(priority = 2, method = "initialized")
public class Foo2 {

    public void run() {
        throw new IllegalStateException("This method should not be called");
    }

    public void initialized() {
        System.out.println("Class Foo2 initialize");
    }
}
