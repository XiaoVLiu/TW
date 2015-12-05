package main.speciality;

/**
 * Created by lxw on 15-12-5.
 */
public class FullAttackSpecial extends Speciality {

    @Override
    public int calculateSpecialDamage(int damage) {
        return damage*3;
    }
}
