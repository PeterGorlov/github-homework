import java.util.HashMap;

public class Translator {
    private final HashMap<String, String> map;

    public Translator(HashMap<String, String> map) {
        this.map = map;
    }

    public void addWords(String englishWord, String russianWord) {
        map.put(englishWord, russianWord);
    }

    public void translate(String str) {
        String[] subString = str.split(" ");

        System.out.print("English: ");
        for (String s : subString) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.print("Russian: ");
        for (String s : subString) {
            System.out.print(map.get(s) + " ");
        }
        System.out.println();
    }
}