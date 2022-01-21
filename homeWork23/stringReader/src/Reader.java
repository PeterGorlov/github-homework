import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


public class Reader {
    public List<String> readFile() throws IOException {
        return Files.lines(Paths.get("text.Txt"))
                .map(str -> str.split(" "))
                .map(List::of)
                .flatMap(Collection::stream)
                .map(String::toLowerCase)
                .map(letter -> letter.replaceAll("[^A-Za-zА-Яа-я]", ""))
                .filter(letter -> letter.length() > 0)
                .collect(Collectors.toList());
    }
}
