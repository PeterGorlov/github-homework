import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyPhoneBook myPhoneBook = new MyPhoneBook(new ArrayList<>());
        myPhoneBook.addPhoneNumber("peter", "+380952527873");
        myPhoneBook.addPhoneNumber("yana", "+3809912345678");
        myPhoneBook.addPhoneNumber("saha", "33333333333333");
        myPhoneBook.addPhoneNumber("saha", "22222222222222");
        myPhoneBook.addPhoneNumber("saha", "+3801111111111");

        myPhoneBook.printPhoneBook();
        myPhoneBook.sortByName();
        myPhoneBook.printPhoneBook();
        myPhoneBook.sortByPhoneNumber();
        myPhoneBook.printPhoneBook();

    }
}
