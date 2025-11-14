package main.model.unit.monster;

import main.model.unit.Unit;

public class Monster extends Unit {

    private int exp;
    private int gold;
    private String description;
    private String asciiArt;
    private MonsterType type;


    public Monster(Monster original) {
        super(original);
        this.exp = original.exp;
        this.gold = original.gold;
        this.asciiArt = original.asciiArt;
        this.description = original.description;
    }

    public Monster(MonsterType type, String name, int hp, int mp, int maxHp, int maxMp, int attackDamage, int magicForce, int defense,
                   int gold, int exp, String description, String asciiArt) {
        super(name, hp, mp, maxHp, maxMp, attackDamage, magicForce, defense);
        this.gold = gold;
        this.description = description;
        this.asciiArt = asciiArt;
        this.exp = exp;
        this.type = type;
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
}
