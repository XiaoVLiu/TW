package main;

import static java.lang.String.format;

/**
 * Created by lxw on 15-12-4.
 */
public class Game {
    private ConsolePrinter consolePrinter;

    public Game(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public void fight(Player playerA, Player playerB) {
        Player attacker = playerA;
        Player victim = playerB;
        Player loser = attacker;

        while (attacker.isAlive()) {
            consolePrinter.print(format("%s\n", attacker.attack(victim)));

            loser = victim;
            victim = attacker;
            attacker = loser;
        }

        consolePrinter.print(format("%s被打败了！", loser.getName()));
    }
}
