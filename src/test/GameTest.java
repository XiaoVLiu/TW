package test;

import main.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {
    private Game game;

    @Mock
    private ConsolePrinter consolePrinter;
    InOrder inOrder;

    @Before
    public void setUp() throws Exception {
        inOrder = inOrder(consolePrinter);
        game = new Game(consolePrinter);
    }

    @Test
    public void testshouldOnePlayerWinAnotherOne() {
        Player winer = new Player("春花", 10, 10);
        Player loser = new Player("秋月", 9, 10);

        game.fight(winer, loser);

        inOrder.verify(consolePrinter, times(1)).print("普通人春花攻击了普通人秋月，秋月受到了10点伤害，秋月剩余生命值：-1\n");
        inOrder.verify(consolePrinter, times(1)).print("秋月被打败了！");
    }

    @Test
    public void testshouldSoldierFightWithPlayer() {
        Soldier soldier = new Soldier("superman", 100, 20);
        Player player = new Player("people", 50, 10);

        Weapon weapon = new Weapon("屠龙刀", 10);
        soldier.equipWeapon(weapon);

        game.fight(soldier, player);

        inOrder.verify(consolePrinter, times(1)).print("战士superman用屠龙刀攻击了普通人people，people受到了30点伤害，people剩余生命值：20\n");
        inOrder.verify(consolePrinter, times(1)).print("普通人people攻击了战士superman，superman受到了10点伤害，superman剩余生命值：90\n");
        inOrder.verify(consolePrinter, times(1)).print("战士superman用屠龙刀攻击了普通人people，people受到了30点伤害，people剩余生命值：-10\n");
        inOrder.verify(consolePrinter, times(1)).print("people被打败了！");
    }

    @Test
    public void testshouldSoldierFightWithPlayerBySpecialWeapon() {
        Soldier soldier = new Soldier("superman", 100, 20);
        Player player = new Player("people", 30, 10);

        SpecialWeapon sweapon = spy(new SpecialWeapon("毒针", 5, Utility.SPECIALITY_POISON));
        soldier.equipWeapon(sweapon);

        when(sweapon.getSpecialityType()).thenReturn(Utility.SPECIALITY_POISON);
        game.fight(soldier, player);

        inOrder.verify(consolePrinter, times(1)).print("战士superman用毒针攻击了普通人people，people受到了25点伤害，people中毒了，people剩余生命值：5\n");
        inOrder.verify(consolePrinter, times(1)).print("people受到2点毒性伤害，people剩余生命值：3\n普通人people攻击了战士superman，superman受到了10点伤害，superman剩余生命值：90\n");
        inOrder.verify(consolePrinter, times(1)).print("战士superman用毒针攻击了普通人people，people受到了25点伤害，people中毒了，people剩余生命值：-22\n");
        inOrder.verify(consolePrinter, times(1)).print("people被打败了！");
    }
}
