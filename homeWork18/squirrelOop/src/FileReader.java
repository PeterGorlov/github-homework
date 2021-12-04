import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileReader {
    private static final String path = "journalEvents.txt";

    public static int counterArrayLength() throws IOException {
        return (int) Files.lines(Path.of(path)).count();
    }

    public static Day[] readFile() throws IOException {
        BufferedReader bf = new BufferedReader(new java.io.FileReader(path));
        int counter = 0;
        String line;
        String[] tempLine;
        Day[] arrayOfDays = new Day[counterArrayLength()];

        while ((line = bf.readLine()) != null) {
            tempLine = line.split(",");
            Day day = new Day(Arrays.copyOf(tempLine, tempLine.length - 1),
                    Boolean.parseBoolean(tempLine[tempLine.length - 1]));
            arrayOfDays[counter++] = day;
        }
        return arrayOfDays;
    }

}
