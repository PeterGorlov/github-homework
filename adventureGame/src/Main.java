import weapon.BowAndArrowBehavior;
import weapon.KnifeBehavior;
import сharacters.*;
import сharacters.Character;

public class Main {
    public static void main(String[] args) {
        Character queen = new Queen("Queen");
        Character kinght = new Knight("Knight");
        Character king = new King("King");
        Character troll = new Troll("Troll");

        kinght.fight();
        king.fight();
        troll.fight();
        queen.fight();
        queen.setWeapon(new BowAndArrowBehavior());
        queen.fight();
    }

}
