package main;


/**
 * Created by lxw on 15-12-4.
 */
public class MainClass {
    public static void main(String args[]) {
        Soldier soldier = new Soldier("superman", 100, 20);
        Player player = new Player("people", 100, 10);

        SpecialWeapon sweapon = new SpecialWeapon("毒针", 5, Utility.SPECIALITY_POISON);
        soldier.equipWeapon(sweapon);

        ConsolePrinter consolePrinter = new ConsolePrinter();
        Game game = new Game(consolePrinter);
        game.fight(soldier, player);
    }
}
