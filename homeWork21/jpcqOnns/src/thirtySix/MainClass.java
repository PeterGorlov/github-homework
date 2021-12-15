package thirtySix;

public class MainClass {
    public static void main(String[] args) {
        OuterClass.InnerClassOne one = new OuterClass.InnerClassOne();

        System.out.println(one.getI());

        one = new OuterClass.InnerClassTwo();

        System.out.println(one.getI());
    }
}
