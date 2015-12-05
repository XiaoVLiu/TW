package main;

/**
 * Created by lxw on 15-12-4.
 */
public class Armor {
    private final String name;
    private final int defend;

    public Armor(String name, int defend) {
        this.name = name;
        this.defend = defend;
    }

    public int getDefend() {
        return defend;
    }
}
