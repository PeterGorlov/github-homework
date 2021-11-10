public class Yorkshire extends Dog {
    private int breedWeight = 15;
    public Yorkshire(String name) {
        super(name);
    }

    public String speak() {
        return "woof";
    }

    public int avgBreedWeight() {
        return breedWeight;
    }
}