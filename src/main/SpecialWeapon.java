package main;

import java.util.Random;

/**
 * Created by lxw on 15-12-4.
 */
public class SpecialWeapon extends Weapon{
    private String specialityType;
    private int attack;

    public SpecialWeapon(String name, int attack) {
        super(name, attack);
    }

    public SpecialWeapon(String name, int attack, String specialityType) {
        super(name, attack);
        this.specialityType = specialityType;
    }

    public void setSpecialityType(String specialityType) {
        this.specialityType = specialityType;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String getSpecialityType() {
        Random random = new Random();
        int probability = random.nextInt(100);

        if (probability<=Utility.specialityFactory.getProbability(specialityType))
            return specialityType;
        else
            return Utility.SPECIALITY_NONE;
    }
}
