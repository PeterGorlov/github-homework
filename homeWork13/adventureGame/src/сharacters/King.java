package сharacters;

import weapon.SwordBehavior;

public class King extends Character {
    public King(String name) {
        super(new SwordBehavior(), name);
    }
}
