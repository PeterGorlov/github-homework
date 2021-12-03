public class Day {
    private  String[] events;
    private final boolean squirrel;

    public Day(String[] events, boolean squirrel) {
        this.events = events;
        this.squirrel = squirrel;
    }

    public void setEvents(String[] events) {
        this.events = events;
    }

    public String[] getEvents() {
        return events;
    }

    public boolean isSquirrel() {
        return squirrel;
    }

}
