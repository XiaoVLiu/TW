package main;

import main.speciality.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxw on 15-12-4.
 */
public class SpecialityFactory {
    private Map<String, Speciality> specialityMap = new HashMap<>();

    private Map<String, Integer> specialityProbability = new HashMap<>();

    public SpecialityFactory() {
        specialityProbability.put(Utility.SPECIALITY_FIRE, 50);
        specialityProbability.put(Utility.SPECIALITY_FROZEN, 60);
        specialityProbability.put(Utility.SPECIALITY_FULL_ATTACK, 60);
        specialityProbability.put(Utility.SPECIALITY_POISON, 80);
        specialityProbability.put(Utility.SPECIALITY_STUN, 50);

        specialityMap.put(Utility.SPECIALITY_FULL_ATTACK, new FullAttackSpecial());
        specialityMap.put(Utility.SPECIALITY_STUN, new StunSpecial());
        specialityMap.put(Utility.SPECIALITY_FROZEN, new FrozenSpecial());
        specialityMap.put(Utility.SPECIALITY_FIRE, new FireSpecial());
        specialityMap.put(Utility.SPECIALITY_POISON, new PoisonSpecial());
    }

    public int getProbability(String speciality) {
        if (specialityProbability.get(speciality)==null)
            return 0;

       return specialityProbability.get(speciality);
    }

    public Speciality getSpeciality(String status) {
        return specialityMap.get(status);
    }
}
