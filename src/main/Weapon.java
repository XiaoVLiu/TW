package main;


import static java.lang.String.format;

/**
 * Created by lxw on 15-12-4.
 */
public class Weapon {
    private String name;
    private int attack;

    public Weapon(String name, int attack) {
        this.name = name;
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public String useInfo() {
        if (this.name=="")
            return null;

        return format("用%s", this.name);
    }

    public boolean isSpecial() {
        return false;
    }

    public String getSpecialityType() {
        return Utility.SPECIALITY_NONE;
    }
}
