package main.speciality;

import main.Player;

/**
 * Created by lxw on 15-12-5.
 */
public class StunSpecial extends Speciality {
    @Override
    public void affect(Player player) {
        player.setStopAttackTimes(player.getStopAttackTimes()+2);
    }

    @Override
    public String getDamageStatus() {
        return "晕倒了";
    }
}
