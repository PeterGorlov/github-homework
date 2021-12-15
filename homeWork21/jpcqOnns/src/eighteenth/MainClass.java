package eighteenth;

public class MainClass {
    public static void main(String[] args) {
        One one = new One();

        One.Two two = one.new Two();

        One.Three three = new One.Three();
    }
}
