import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class GsonParser {
    public List<DayJournal> parser() {
        Gson gson = new Gson();
        String patch = "journal_ru.json";
        try {
            List<DayJournal> journal =
                    gson.fromJson(new FileReader(patch), new TypeToken<ArrayList<DayJournal>>() {
                    }.getType());
            return journal;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
