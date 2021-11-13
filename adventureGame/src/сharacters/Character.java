package сharacters;

import weapon.WeaponBehavior;

public abstract class Character {
    private WeaponBehavior weapon;
    private String name;

    public Character(WeaponBehavior weapon, String name) {
        this.name = name;
        this.weapon = weapon;
    }

    public void fight() {
        System.out.print(name + " : ");
        weapon.useWeapon();
    }

    public void setWeapon(WeaponBehavior w) {
        this.weapon = w;
    }
}
