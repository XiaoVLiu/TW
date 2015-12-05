package main.speciality;

import main.Player;

/**
 * Created by lxw on 15-12-5.
 */
public class FrozenSpecial extends Speciality {

    @Override
    public String getDamageStatus() {
        return "冻僵了";
    }

    @Override
    public void affect(Player player) {
        player.setStopAttackTimes(player.getStopAttackTimes()+1);
    }
}
