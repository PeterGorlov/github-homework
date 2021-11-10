import java.util.Arrays;

public class Test {
    private static int defNum;
    private static int numInt1 = 25;
    private static int numInt2 = -20;
    private static short numShort1 = 9991;
    private static short numShort2 = 991;
    private static int lngShortNum1;
    private static int lngShortNum2;
    private static int[][] numArray = new int[5][1];


    public static void main(String[] args) {
        addArrayNumInt1NumInt2();
        lngShortNum1 = lngShortNum(numShort1);
        addArrayShortNum(numShort1, lngShortNum1, defNum);
        lngShortNum2 = lngShortNum(numShort2);
        addArrayShortNum(numShort2, lngShortNum2, defNum);
        System.out.println(Arrays.toString(sumNumber(numArray)));

    }

    public static void addArrayNumInt1NumInt2() {
        numArray[0][0] = numInt1;
        numArray[1][0] = numInt2;
    }

    public static int lngShortNum(short num) {
        int lng = 0;
        while (num > 0) {
            num = (short) (num / 10);
            lng++;
        }
        defNum++;
        return lng;
    }

    public static void addArrayShortNum(short num, int lng, int defNum) {
        int rowArray;
        if (defNum == 1) {
            numArray[2] = new int[lng];
            rowArray = 2;
        } else {
            numArray[3] = new int[lng];
            rowArray = 3;
        }
        for (int i = 0; i < lng; i++) {
            int lastNum = (short) (num % 10);
            num = (short) (num / 10);
            numArray[rowArray][lng - i - 1] = lastNum;
        }
    }

    public static int[] sumNumber(int[][] arrayNum) {
        int indexLengthUseMin = findingMinLengthShort(lngShortNum1, lngShortNum2);
        int indexLengthUseMax = findingMaxLengthShort(lngShortNum1, lngShortNum2);
        int countLengthMin = indexLengthUseMin;
        int countLengthMax = indexLengthUseMax;
        int residualAmount = 0;
        int[] arraySumShort = new int[indexLengthUseMin];
        int[] arraySumShortMax = new int[countLengthMax];
        arrayNum[4][0] = residualAmount + (arrayNum[0][0] + arrayNum[1][0]);
        if (lngShortNum1 < lngShortNum2 && numInt1 < 0 | numInt2 < 0) {
            for (int arrayColum = 0; arrayColum < indexLengthUseMin; arrayColum++) {
                arraySumShort[arrayColum] = residualAmount + arrayNum[3][countLengthMin - 1] - arrayNum[2][countLengthMin - 1];
                residualAmount = 0;
                countLengthMin--;
                if (arraySumShort[arrayColum] < 0) {
                    arraySumShort[arrayColum] = (arraySumShort[arrayColum] + 10);
                    if (numInt1 < 0) {
                        residualAmount = -1;
                    } else
                        residualAmount = 1;
                }

                arrayNum[4][0] = residualAmount + (arrayNum[0][0] + arrayNum[1][0]);
            }

        } else if (lngShortNum1 > lngShortNum2 && numInt1 < 0 | numInt2 < 0) {
            numArray[3] = Arrays.copyOf(numArray[3], countLengthMax);
            for (int index = 0; index < indexLengthUseMax; index++) {
                arraySumShortMax[index] = arrayNum[3][countLengthMax - 1] - arrayNum[2][countLengthMax - 1];
                countLengthMax--;
                if (arraySumShortMax[index] <= 0) {
                    arraySumShortMax[index] = (arraySumShortMax[index] + 10);
                    if (countLengthMax == 0) {
                        if (numInt1 < 0 ) {
                            residualAmount = -1;
                        } else if (numInt1 > 0) {
                            residualAmount = 1;
                        } else if (numInt2 < 0) {
                            residualAmount = 1;
                        } else if (numInt2 > 0) {
                            residualAmount = 1;
                        }
                    } else {
                        arrayNum[3][countLengthMax - 1] = arrayNum[3][countLengthMax - 1] - 1;
                    }
                    arrayNum[4][0] = residualAmount + arrayNum[4][0];
                }
                arraySumShort = Arrays.copyOf(arraySumShortMax, indexLengthUseMax);

            }

        } else {

            for (int arrayColum = 0; arrayColum < indexLengthUseMin; arrayColum++) {
                arraySumShort[arrayColum] = residualAmount + arrayNum[2][countLengthMin - 1] + arrayNum[3][countLengthMin - 1];
                residualAmount = 0;
                countLengthMin--;
                if (arraySumShort[arrayColum] >= 10) {
                    arraySumShort[arrayColum] = (arraySumShort[arrayColum] - 10);
                    residualAmount = 1;
                }
                arrayNum[4][0] = residualAmount + arrayNum[0][0] + arrayNum[1][0];
            }

        }


        for (int i = 0; i < arraySumShort.length / 2; i++) {
            int tmp = arraySumShort[i];
            arraySumShort[i] = arraySumShort[arraySumShort.length - i - 1];
            arraySumShort[arraySumShort.length - i - 1] = tmp;
        }


        arrayNum[4] = Arrays.copyOf(arrayNum[4], findingMaxLengthShort(lngShortNum1, lngShortNum2) + 1);
        if (numInt1 < numInt2) {
            System.arraycopy(arraySumShort, 0, arrayNum[4], 1, indexLengthUseMax);
        } else {
            System.arraycopy(arraySumShort, 0, arrayNum[4], 1, indexLengthUseMax - 1);
        }


        if (numArray[2].length < numArray[3].length) {
            System.arraycopy(numArray[3], findingMinLengthShort(lngShortNum1, lngShortNum2)
                    , arrayNum[4], findingMinLengthShort(lngShortNum1, lngShortNum2) + 1
                    , numArray[3].length - findingMinLengthShort(lngShortNum1, lngShortNum2));
        } else if (numArray[2].length > numArray[3].length) {
            System.arraycopy(numArray[2], findingMinLengthShort(lngShortNum1, lngShortNum2)
                    , arrayNum[4], findingMinLengthShort(lngShortNum1, lngShortNum2) + 1
                    , numArray[2].length - findingMinLengthShort(lngShortNum1, lngShortNum2));

        }
        return sumShort(numArray[4]);
    }

    public static int[] sumShort(int[] array) {
        int[] finishNum = new int[2];

        switch (array.length) {
            case (6) -> {
                array[1] = array[1] * 10000;
                array[2] = array[2] * 1000;
                array[3] = array[3] * 100;
                array[4] = array[4] * 10;
            }
            case (5) -> {
                array[1] = array[1] * 1000;
                array[2] = array[2] * 100;
                array[3] = array[3] * 10;
            }
            case (4) -> {
                array[1] = array[1] * 100;
                array[2] = array[2] * 10;
            }
            case (3) -> array[1] = array[1] * 10;


        }

        int startSum = 0;
        for (int i = 1; i < array.length; i++) {
            startSum = startSum + array[i];
        }
        if (array[0] < 0) {
            array[1] = startSum * -1;
        } else {
            array[1] = startSum;
        }
        System.arraycopy(array, 0, finishNum, 0, 2);
        return finishNum;
    }

    public static int findingMinLengthShort(int numLen, int numLen2) {
        return Math.min(numLen, numLen2);
    }

    public static int findingMaxLengthShort(int numLen, int numLen2) {
        return Math.max(numLen, numLen2);
    }

}
