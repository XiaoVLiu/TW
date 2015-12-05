package test;

import main.Player;
import main.Soldier;
import main.Weapon;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by lxw on 15-12-3.
 */
public class PlayerTest {
    @Test
    public void shouldCreatePlayerSuccessfully(){
        Player player = new Player("大神", 100, 10);

        assertThat(player.getName(), is("大神"));
        assertThat(player.getBlood(), is(100));
        assertThat(player.getAttack(), is(10));
    }

    @Test
    public void shouldAttackOtherPlayer() {
        Player attacker = new Player("大神", 100, 10);
        Player victim = new Player("学渣", 100, 20);

        attacker.attack(victim);
        assertThat(victim.getBlood(), is(90));
    }

    @Test
    public void shouldPrintWhoAttackWho() {
        Player attacker = new Player("大神", 100, 10);
        Player victim = new Player("学渣", 100, 20);

        assertThat(attacker.attack(victim), is("普通人大神攻击了普通人学渣，学渣受到了10点伤害，学渣剩余生命值：90"));
    }

    @Test
    public void testshouldAliveWhenBloodIs0() {
        Player player = new Player("大神", 0, 0);

        assertThat(player.isAlive(), is(true));
    }

    @Test
    public void testshouldAliveWhenBloodMoreThan0() {
        Player player = new Player("大神", 5, 1);

        assertThat(player.isAlive(), is(true));
    }

    @Test
    public void testshouldNotAliveWhenBloodLessThan0() {
        Player player = new Player("大神", -5, 1);

        assertThat(player.isAlive(), is(false));
    }
}
