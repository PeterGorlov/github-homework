import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String[] userAnswer = userAnswer();
        Fraction num1 = new Fraction(userAnswer[0]);
        Fraction num2 = new Fraction(userAnswer[2]);
        switch (userAnswer[1]) {
            case "plus":
                System.out.println(Arrays.toString(Fraction.addition(num1, num2)));
                break;
            case "minus":
                System.out.println(Arrays.toString(Fraction.subtraction(num1, num2)));
                break;
            default:
                System.out.println("Не коретный оператор");
        }
    }

    public static String[] userAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите : 'Число оператор число'    (оператор: plus/minus), (число через: *,*)");
        String answer = scanner.nextLine();
        String[] userAnswer = answer.split(" ");
        if (userAnswer.length != 3) {
            throw new IllegalArgumentException("Ведите в верном формате , Число оператор число! ");
        }
        return userAnswer;
    }
}