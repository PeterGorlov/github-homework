
import java.util.Iterator;

public class DataStructure<E> {
    private final E[] arrayOflnts;

    public DataStructure(E[] arrayOflnts) {
        this.arrayOflnts = arrayOflnts;
    }

    public void printEven() {
        EvenIterator evenIterator = this.new EvenIterator();
        while (evenIterator.hasNext()) {
            System.out.println(evenIterator.next());
        }
    }

    public Iterator<E> evenIterator() {
        return this.new EvenIterator();
    }

    public Iterator<E> evenIterator(int index) {
        return this.new EvenIterator(index);
    }

    private interface ArrayIterator extends Iterator {

    }

    private class EvenIterator implements ArrayIterator {
        int index = 0;

        public EvenIterator() {
        }

        public EvenIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index < arrayOflnts.length;
        }

        @Override
        public E next() {
            E result = arrayOflnts[index];
            index += 2;
            return result;
        }
    }


}
