package main.speciality;

/**
 * Created by lxw on 15-12-5.
 */
public class FireSpecial extends Speciality {
    @Override
    public int getAttack() {
        return 3;
    }

    @Override
    public String getDamageStatus() {
        return "被点着了";
    }
}
