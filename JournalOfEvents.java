import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class JournalOfEvents {
    private static final String PATH = "C:\\journalEvents_ru.csv";

    public static void main(String[] args) {
        int countLine = 0;
        String line = "";
        int lengthArray = counterArrayLength(PATH);
        String[][] events = new String[lengthArray][];
        boolean[] squirrels = new boolean[lengthArray];
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH));
            while ((line = br.readLine()) != null) {
                String[] arrayLine = line.split(",");
                events[countLine] = Arrays.copyOf(arrayLine, arrayLine.length - 1);
                squirrels[countLine] = Boolean.parseBoolean(arrayLine[arrayLine.length - 1]);
                countLine++;

            }
        } catch (IOException e) {
            e.printStackTrace();

        }

        System.out.println(Arrays.deepToString(events));
        System.out.println(Arrays.toString(squirrels));
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
}
