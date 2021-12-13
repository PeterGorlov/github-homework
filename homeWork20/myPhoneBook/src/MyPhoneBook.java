import java.util.ArrayList;
import java.util.Comparator;

public class MyPhoneBook {
    private final ArrayList<PhoneRecord> phoneNumbers;

    public MyPhoneBook(ArrayList<PhoneRecord> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    class PhoneRecord {
        private String name;
        private String phone;

        public PhoneRecord(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "PhoneRecord{" +
                    "name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }

    }


    public void addPhoneNumber(String name, String phone) {
        phoneNumbers.add(new PhoneRecord(name, phone));
    }

    public void printPhoneBook() {
        System.out.println(phoneNumbers.toString());
    }

    public void sortByName() {
        phoneNumbers.sort(new Comparator<>() {
            @Override
            public int compare(PhoneRecord o1, PhoneRecord o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

    }

    public void sortByPhoneNumber() {
        phoneNumbers.sort((o1, o2) -> {
            int result = o1.getName().compareTo(o2.getName());
            if (result == 0) {
                return o1.getPhone().compareTo(o2.getPhone());
            }
            return result;
        });
    }
}
