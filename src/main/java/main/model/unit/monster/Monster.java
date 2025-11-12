package main.model.unit.monster;

import main.model.unit.Unit;

public abstract class Monster extends Unit {

    private int exp;
    private int gold;
    private String description;
    private String asciiArt;


    public Monster(Monster original) {
        super(original);
        this.exp = original.exp;
        this.gold = original.gold;
        this.asciiArt = original.asciiArt;
        this.description = original.description;
    }

    public Monster(String name, int hp, int mp, int maxHp, int maxMp, int attackDamage, int magicForce, int defense,
                   int gold, String description, String asciiArt) {
        super(name, hp, mp, maxHp, maxMp, attackDamage, magicForce, defense);
        this.gold = gold;
        this.description = description;
        this.asciiArt = asciiArt;
    }

    public int giveExp() {
        return this.exp;
    }

    public String getAsciiArt() {
        return this.asciiArt;
    }

    public int giveGold() {
        return this.gold;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
