package orderOfOperations;

public class LoopForWithIfThree {
    public static void main(String[] args) {
        int line = 6;
        int symbol = 11;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < symbol; j++) {
                if ((symbol / 2 == j && i == 0) || (((symbol / 2) - i) == j || (((symbol / 2) + i) == j))
                        || (i == line - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
