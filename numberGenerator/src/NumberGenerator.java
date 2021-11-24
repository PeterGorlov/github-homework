import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberGenerator {
    private final int numberOfElements;
    private final int minNumber;
    private final int maxNumber;

    public NumberGenerator(int numberOfElements, int minNumber, int maxNumber) {
        if (minNumber < maxNumber) {
            this.numberOfElements = numberOfElements;
            this.minNumber = minNumber;
            this.maxNumber = maxNumber;
        } else {
            throw new InvalidParameterException("The min number can't be bigger than max.");
        }
    }

    public List<Integer> generateList() {
        List<Integer> list = new ArrayList<>(numberOfElements);
        for (int i = 0; i < numberOfElements; i++) {
            list.add(returnRandomNumber());
        }
        return list;
    }

    public Set<Integer> generateSet() {
        Set<Integer> list = new HashSet<>(10);
        if (maxNumber - minNumber >= numberOfElements) {
            while (list.size() != 10) {
                list.add(returnRandomNumber());
            }
        } else {
            throw new InvalidParameterException("Range of min and max - must be bigger than numberOfElements.");
        }
        return list;
    }

    private int returnRandomNumber() {
        return minNumber + (int) (Math.random() * (maxNumber - minNumber));
    }

}
