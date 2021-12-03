import java.io.IOException;
import java.util.Arrays;

public class Employee {
    private final Day[] days = FileReader.readFile();

    public Employee() throws IOException {
    }

    private int[] intRepresentation(String event) {
        int[] array = new int[4];
        for (Day day : days) {
            if (!(Arrays.asList(day.getEvents()).contains(event)) && !(day.isSquirrel())) {
                array[0] += 1;
            }
            if (Arrays.asList(day.getEvents()).contains(event) && !(day.isSquirrel())) {
                array[1] += 1;
            }
            if (!(Arrays.asList(day.getEvents()).contains(event)) && (day.isSquirrel())) {
                array[2] += 1;
            }
            if (Arrays.asList(day.getEvents()).contains(event) && (day.isSquirrel())) {
                array[3] += 1;
            }
        }
        return array;
    }

    private String[] arrayOfEvents() {
        String[] arrayOfEvents = new String[days.length];
        int count = 0;
        for (Day day : days) {
            for (int i = 0; i < day.getEvents().length; i++) {
                if (!(Arrays.asList(arrayOfEvents).contains(day.getEvents()[i]))) {
                    arrayOfEvents[count++] = day.getEvents()[i];
                }
            }
        }
        return Arrays.copyOf(arrayOfEvents, count);
    }

    private double phi(int[] array) {
        return (array[3] * array[0] - array[2] * array[1]) /
                Math.sqrt((array[2] + array[3]) *
                        (array[0] + array[1]) *
                        (array[1] + array[3]) *
                        (array[0] + array[2]));
    }

    public void print() {
        String[] arrayOfEvents = arrayOfEvents();
        for (String arrayOfEvent : arrayOfEvents) {
            if (phi(intRepresentation(arrayOfEvent)) > 0.1 || phi(intRepresentation(arrayOfEvent)) < -0.1)
                System.out.println(arrayOfEvent + ":" + String.format("%.5f", phi(intRepresentation(arrayOfEvent))));
        }

    }

    public void changeEvents() {
        for (int i = 0; i < days.length; i++) {
            String line = Arrays.toString(days[i].getEvents());
            if (line.contains("ел арахис") && !line.contains("чистил зубы")) {
                days[i].setEvents(new String[]{"арахис-зубы"});
            }
        }
        System.out.println("..................................");
        printSingleEvent("арахис-зубы");

    }

    public void printSingleEvent(String event) {
        String[] arrayOfEvents = arrayOfEvents();
        for (int index = 0; index < arrayOfEvents.length; index++) {
            if (arrayOfEvents[index].equals(event)) {
                System.out.println(arrayOfEvents[index] + " : " + phi(intRepresentation(event)));        }
        }

    }
}
