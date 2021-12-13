package fortyNine;

interface X {
    void methodOne(String s);

    void methodTwo(String s);
}

abstract class Y implements X {
    String s = "ONE";

    public void methodOne(String s) {
        System.out.println(this.s + s);
    }
}

