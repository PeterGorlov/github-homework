package sixth;

class A {
    String s = "AAA";

    //    static void methodA() {
    void methodA() {
        System.out.println(s);
    }

    //    static class B
    class B {
        void methodB() {
            methodA();
        }
    }
}
