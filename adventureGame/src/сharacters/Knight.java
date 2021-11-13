package сharacters;

import weapon.BowAndArrowBehavior;

public class Knight extends Character {
    public Knight(String name) {
        super(new BowAndArrowBehavior(), name);
    }

}
