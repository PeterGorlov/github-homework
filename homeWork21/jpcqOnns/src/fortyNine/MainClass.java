package fortyNine;

public class MainClass {
    public static void main(String[] args) {
        X x = new Y() {
            {
                s = s + s;
            }

            public void methodTwo(String s) {
                System.out.println(this.s + s);
            }
        };

        x.methodOne("1");

        x.methodTwo("2");
    }
}
