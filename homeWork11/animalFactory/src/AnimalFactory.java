public class AnimalFactory {
    public static Animal getAnimalByKey(String key) {
        return switch (key) {
            case "da" -> new Dog("Арамис");
            case "db" -> new Dog("Блек");
            case "dc" -> new Dog("Спайки");
            case "ca" -> new Cat("Амадей");
            case "cb" -> new Cat("Баксик");
            case "cc" -> new Cat("Снежок");
            default -> null;
        };
    }
}