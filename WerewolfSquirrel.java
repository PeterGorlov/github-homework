import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class WerewolfSquirrel {
    private static final String PATH = "/Users/hoho/Documents/IdeaProjects/JournalOfEvents/journalEvents_ru.csv";

    private static boolean[] booleanArray = null;
    private static String[][] actionsArray = null;


    private static int countActions = 0;
    private static String[] uniqueActions = new String[countActions];
    private static String[] newUniqueActions = new String[30];
    private static int[][] statisticalVariables = new int[4][];
    private static double[] correlationArray = new double[0];

    public static void main(String[] args) {
        addArray();
        addArrayActionDistinct(actionsArray);
        addSortAction();
        statisticalVariablesArray(actionsArray, booleanArray, newUniqueActions);
        calculateCorrelation();
        printSignificantCorrelation();

        System.out.println("......................");

        changeEvents("ел арахис", "чистил зубы", "арахис-зубы");
        statisticalVariablesArray(actionsArray, booleanArray, newUniqueActions);
        calculateCorrelation();
        printSingleEvent("арахис-зубы");

    }

    public static int counterArrayLength(String strings) {
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(strings));
            while ((strings = br.readLine()) != null) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return count;
    }

    public static void addArray() {
        int countLine = 0;
        String line = "";
        int lengthArray = counterArrayLength(PATH);
        actionsArray = new String[lengthArray][];
        booleanArray = new boolean[lengthArray];
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH));
            while ((line = br.readLine()) != null) {
                String[] arrayLine = line.split(",");
                actionsArray[countLine] = Arrays.copyOf(arrayLine, arrayLine.length - 1);
                booleanArray[countLine] = Boolean.parseBoolean(arrayLine[arrayLine.length - 1]);
                countLine++;
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

    }


    public static void statisticalVariablesArray(String[][] line, boolean[] action, String[] uniqAction) {
        statisticalVariables = Arrays.copyOf(statisticalVariables, newUniqueActions.length);
        int counter = 0;
        for (int unAction = 0; unAction < uniqAction.length; unAction++) {

            int noSquirrelNoAction = 0;
            int noSquirrelAction = 0;
            int squirrelNoAction = 0;
            int squirrelAction = 0;
            for (int index = 0; index < action.length; index++) {
                if (action[index]) {
                    if (isActionPresent(line[index], uniqAction[unAction])) {
                        squirrelAction++;
                    } else {
                        squirrelNoAction++;
                    }
                } else if (!action[index]) {
                    if (isActionPresent(line[index], uniqAction[unAction])) {
                        noSquirrelAction++;
                    } else {
                        noSquirrelNoAction++;
                    }
                }
            }

            statisticalVariables[counter] = new int[]{noSquirrelNoAction, noSquirrelAction,
                    squirrelNoAction, squirrelAction};
            counter++;

        }
    }

    public static boolean isActionPresent(String[] array, String elements) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(elements)) {
                return true;
            }
        }
        return false;
    }


    public static void addArrayActionDistinct(String[][] array) {
        int count = 0;
        for (int outerArray = 0; outerArray < array.length; outerArray++) {
            uniqueActions = Arrays.copyOf(uniqueActions, uniqueActions.length + array[outerArray].length);
            for (int rowArray = 0; rowArray < array[outerArray].length; rowArray++) {
                uniqueActions[count] = array[outerArray][rowArray];
                count++;
            }
        }

    }


    public static void addSortAction() {
        int count = 0;
        Arrays.sort(uniqueActions);
        for (int index = 1; index < uniqueActions.length; index++) {
            if (!uniqueActions[index - 1].equals(uniqueActions[index])) {
                newUniqueActions[count] = uniqueActions[index];
                count++;
            }

        }
        newUniqueActions = Arrays.copyOf(newUniqueActions, count);
    }

    public static void calculateCorrelation() {
        correlationArray = Arrays.copyOf(correlationArray, newUniqueActions.length);
        int counter = 0;
        for (int[] statVars : statisticalVariables) {
            double phi = (statVars[3] * statVars[0] - statVars[2] * statVars[1])
                    / Math.sqrt((statVars[2] + statVars[3])
                    * (statVars[0] + statVars[1])
                    * (statVars[1] + statVars[3])
                    * (statVars[0] + statVars[2]));
            correlationArray[counter] = phi;
            counter++;
        }

    }

    public static void printSignificantCorrelation() {
        for (int index = 0; index < correlationArray.length; index++) {
            if (correlationArray[index] > 0.1 || correlationArray[index] < -0.1) {
                System.out.println(newUniqueActions[index] + ": "
                        + BigDecimal.valueOf(correlationArray[index]).setScale(9, RoundingMode.HALF_UP));
            }
        }
    }

    public static void changeEvents(String include, String exclude, String newEvent) {
        for (int i = 0; i < actionsArray.length; i++) {
            String line = Arrays.toString(actionsArray[i]);
            if (line.contains(include) && !line.contains(exclude)) {
                actionsArray[i] = new String[]{newEvent};
            }
        }
        newUniqueActions = Arrays.copyOf(newUniqueActions, newUniqueActions.length + 1);
        newUniqueActions[newUniqueActions.length - 1] = newEvent;
    }

    public static void printSingleEvent(String event) {
        for (int index = 0; index < newUniqueActions.length; index++) {
            if (newUniqueActions[index].equals(event)) {
                System.out.println(newUniqueActions[index] + ": "
                        + BigDecimal.valueOf(correlationArray[index]).setScale(9, RoundingMode.HALF_UP));
            }
        }
    }
}
