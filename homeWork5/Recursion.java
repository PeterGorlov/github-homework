public class Recursion {
    private static int helpInt = 0;

    public static void main(String[] args) {

        int[] array = new int[]{3, 2, 4, 8};
        System.out.println(arraySum(array, array.length - 1) + " ArraySum");
        System.out.println(arrayMaxNumber(array, helpInt) + " ArrayMaxNumber");
        System.out.println(sumNumbers(152) + " sumNumbers");
        System.out.println(numberBack(123) + " numberBack");
    }

    public static int arraySum(int[] array, int index) {
        if (index == 0) {
            return array[0];
        } else {
            return array[index] + arraySum(array, index - 1);
        }
    }

    public static int arrayMaxNumber(int[] array, int max) {
        if (array.length > max) {
            int next = arrayMaxNumber(array, max + 1);
            return (array[max] > next) ? array[max] : next;
        } else {
            return array[0];
        }
    }

    public static int sumNumbers(int input) {
        if (input > 0) {
            final int lastDigit = input % 10;
            helpInt += lastDigit;
            input /= 10;
            sumNumbers(input);

        }

        return helpInt;
    }

    public static int numberBack(int input) {
        if (input < 10) {
            return input;
        } else {
            System.out.print(input % 10);
            return numberBack(input / 10);
        }
    }
}

