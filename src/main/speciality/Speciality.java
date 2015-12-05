package main.speciality;

import main.Player;

/**
 * Created by lxw on 15-12-5.
 */
public class Speciality {

    public int getAttack() { return 0; }

    public void affect(Player player) {}

    public String getDamageStatus() { return ""; }
    public int calculateSpecialDamage(int damage) {
        return damage;
    }
}
