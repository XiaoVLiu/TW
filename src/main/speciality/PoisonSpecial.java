package main.speciality;

/**
 * Created by lxw on 15-12-5.
 */
public class PoisonSpecial extends Speciality {

    @Override
    public String getDamageStatus() {
        return "中毒了";
    }

    @Override
    public int getAttack() { return 2; }
}
