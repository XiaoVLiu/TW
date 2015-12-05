package main;

import static java.lang.String.format;

/**
 * Created by lxw on 15-12-4.
 */
public class Soldier extends Player {

    private Weapon weapon = new Weapon("", 0);
    private Armor armor = new Armor("", 0);
    private int blood;
    private int attack;
    private String name;

    public Soldier(String name, int blood, int attack) {
        super(name, blood, attack);
    }

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public int getAttack() {
        return super.getAttack() + weapon.getAttack();
    }

    @Override
    public String getRole() {
        return "战士";
    }

    public void wearArmor(Armor armor) {
        this.armor = armor;
    }

    @Override
    public int calculateDamage(int attack) {
        int damage = attack - armor.getDefend();

        return damage>0 ? damage : 0;
    }

    @Override
    protected String attackInfo() {
        return format("%s%s", super.attackInfo(), this.weapon.useInfo());
    }

    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public String getAttackType() {
        if (weapon.isSpecial()) {
            return weapon.getSpecialityType();
        }
        else
            return Utility.SPECIALITY_NONE;
    }
}