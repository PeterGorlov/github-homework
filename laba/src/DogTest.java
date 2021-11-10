public class DogTest {
    public static void main(String[] args) {
        Labrador labrador = new Labrador("Tor", "yellow");
        System.out.println(labrador.getName() + " says " + labrador.speak());
        System.out.println(labrador.avgBreedWeight());
        Yorkshire yorkshire = new Yorkshire("Lola");
        System.out.println(yorkshire.getName() + " says " + yorkshire.speak());
        System.out.println(yorkshire.avgBreedWeight());

    }
}