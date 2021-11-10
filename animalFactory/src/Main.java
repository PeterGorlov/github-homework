import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sk = new Scanner(System.in);
        while (true) {
            System.out.println("Введите : da или db или dc или ca или cb или cc");
            String scanner = sk.nextLine();
            if (AnimalFactory.getAnimalByKey(scanner) == null) {
                System.out.println("Не могу создать Animal");
            } else {
                Animal animal = AnimalFactory.getAnimalByKey(scanner);
                System.out.println(animal.getName());
                break;
            }

        }
    }
}



