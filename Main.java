public class Main {
    public static void main(String[] args) {
        print("Hello World!", 2);
    }

    public static void print(String word) {
        System.out.println(word);
    }

    public static void print(String word, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(word);
        }
    }
}