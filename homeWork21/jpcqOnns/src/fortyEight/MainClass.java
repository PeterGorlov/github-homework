package fortyEight;

public class MainClass {
    public static void main(String[] args) {
        A a = new C();

        a.methodA();

        C.D d = new A().new B();

        d.methodD();
    }
}
