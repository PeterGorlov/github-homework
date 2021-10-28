import java.util.List;

public class DayJournal {

    private List<String> events;
    private boolean squirrel;

    public List<String> getEvents() {
        return events;
    }

    public boolean isSquirrel() {
        return squirrel;
    }


    @Override
    public String toString() {
        return "DayJournal{" +
                "events=" + events +
                ", squirrel=" + squirrel +
                '}';
    }
}
