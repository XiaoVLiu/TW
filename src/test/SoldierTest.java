package test;

import main.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by lxw on 15-12-4.
 */
public class SoldierTest {
    private Soldier soldier;
    private Player player;
    private Weapon weapon;
    private Armor armor;

    @Before
    public  void setUp() {
        this.soldier = new Soldier("大神", 100, 10);
        this.player = new Player("学渣", 100, 10);
        this.weapon = new Weapon("屠龙刀", 10);
        this.armor = new Armor("软猬甲", 5);
    }
    @Test
    public void testshouldSoldierUseWeaponImproveAttack() {
        soldier.equipWeapon(weapon);

        assertThat(soldier.getAttack(), is(20));
    }

    @Test
    public void testshouldSoldierCanDefendAttackUseArmor() {
        soldier.wearArmor(armor);

        assertThat(player.attack(soldier), is("普通人学渣攻击了战士大神，大神受到了5点伤害，大神剩余生命值：95"));
    }

    @Test
    public void testshouldSoldierAttackOtherByWeapon() {
        soldier.equipWeapon(weapon);

        assertThat(soldier.attack(player), is("战士大神用屠龙刀攻击了普通人学渣，学渣受到了20点伤害，学渣剩余生命值：80"));
    }

    @Test
    public void testshouldSoldierEquipSpeialWeapon() {
        SpecialWeapon specialWeapon = new SpecialWeapon("倚天剑", 20);

        soldier.equipWeapon(specialWeapon);
        assertThat(soldier.getWeapon(), is(specialWeapon));
    }
}
