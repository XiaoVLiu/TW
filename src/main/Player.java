package main;

import main.speciality.Speciality;

import static java.lang.String.format;
import static main.Utility.*;

/**
 * Created by lxw on 15-12-3.
 */
public class Player {
    private String name;
    private int blood;
    private int attack;
    private int stopAttackTimes = 0;
    private String status = STATE_FORMAL;

    public Player(String name, int blood, int attack) {
        this.name = name;
        this.blood = blood;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public int getBlood() {
        return blood;
    }

    public int getAttack() {
        return attack;
    }

    public String attack(Player victim) {
        String result = "";

        if (stopAttackTimes>0) {
            stopAttackTimes--;
            return format("%s无法攻击，还剩：%d轮", getStatus(), stopAttackTimes);
        }

        if (Utility.specialityFactory.getSpeciality(status)!=null && Utility.specialityFactory.getSpeciality(status).getAttack()>0) {
            int specialityAttack = Utility.specialityFactory.getSpeciality(status).getAttack();
            this.blood -= specialityAttack;
            result = format("%s受到了%d点%s，%s剩余生命值：%d\n", this.name, specialityAttack, status, this.name, this.blood);

            if (!isAlive())
                return result;
        }
            return result+format("%s攻击了%s，%s", attackInfo(), victim.beAttackedInfo(), victim.beAttacked(this));
       }

    private String beAttackedInfo() {
        return format("%s%s", getRole(), this.name);
    }

    protected String attackInfo() {
        return format("%s%s", getRole(), this.name);
    }

    private String beAttacked(Player attacker) {
        int damage = calculateDamage(attacker.getAttack());

        String damageType = attacker.getAttackType();
        status = damageType;

        Speciality speciality = Utility.specialityFactory.getSpeciality(status);
        if (speciality!=null) {
            speciality.affect(this);
            damage = speciality.calculateSpecialDamage(damage);
        }

        this.blood -= damage;
        return format("%s受到了%d点伤害，%s%s剩余生命值：%d", this.name, damage, getStatus(), this.name, this.blood);
    }

    public String getAttackType() {
        return SPECIALITY_NONE;
    }

    public int calculateDamage(int attack) {
        return attack>0 ? attack : 0;
    }

    public String getRole() {
        return "普通人";
    }

    public boolean isAlive() {
        return this.blood>=0;
    }

    public String getStatus() {
        if (status==Utility.SPECIALITY_NONE)
            return "";

        return format("%s%s，", name, Utility.specialityFactory.getSpeciality(status).getDamageStatus());
    }

    public void setStopAttackTimes(int stopAttackTimes) {
        this.stopAttackTimes = stopAttackTimes;
    }

    public int getStopAttackTimes() {
        return stopAttackTimes;
    }
}
