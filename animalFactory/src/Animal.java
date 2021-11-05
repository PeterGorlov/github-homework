public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
        System.out.println(getName());
    }

    public String getName() {
        return name;
    }

}
