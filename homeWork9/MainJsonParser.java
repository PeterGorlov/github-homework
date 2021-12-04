import java.util.List;

public class MainJsonParser {
    public static void main(String[] args) {
        GsonParser gsp = new GsonParser();
        List<DayJournal> dayJournal = gsp.parser();
        System.out.println(dayJournal.toString());
    }

}

