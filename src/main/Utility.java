package main;

/**
 * Created by lxw on 15-12-4.
 */
public class Utility {
    public static final String SPECIALITY_NONE   = "正常伤害";
    public static final String SPECIALITY_POISON = "毒性伤害";
    public static final String SPECIALITY_FIRE   = "火焰伤害";
    public static final String SPECIALITY_FROZEN = "冰冻伤害";
    public static final String SPECIALITY_STUN   = "击晕伤害";
    public static final String SPECIALITY_FULL_ATTACK = "全力一击";

    public static final String STATE_FORMAL = "";
    public static final String STATE_FAINT  = "晕倒了";
    public static final String STATE_FROZEN = "冻住了";
    public static final String STATE_POISON = "中毒了";
    public static final String STATE_FIRE   = "着火了";

    public static final SpecialityFactory specialityFactory = new SpecialityFactory();

}
