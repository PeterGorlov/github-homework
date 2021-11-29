import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        Translator myTranslator = new Translator(map);
        myTranslator.addWords("hello", "привет");
        myTranslator.addWords("i", "я");
        myTranslator.addWords("human", "человек");


        myTranslator.translate("hello i human");
    }
}