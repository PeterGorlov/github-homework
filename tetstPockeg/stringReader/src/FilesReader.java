import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;


public class FilesReader {
    private final HashSet<String> hashSet = new HashSet();

    public HashSet run() {
        try {
            File file = new File("Text.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                split(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashSet;
    }

    private void split(String line) {
        String[] subStr = line.split(" ");
        for (String s : subStr) {
            hashSet.add(s.replaceAll("\\p{Punct}|«|»|—", ""));
        }
    }


}
