package main.model.unit.monster;

import main.model.unit.Unit;

public class WorldBossInfo extends Unit {

    private static final int EXP = 10;
    private int gold;
    private String description;
    private int attackDamage;
    private int magicForce;
    private int defense;
    private int hp;
    private int mp;
    private int maxHp;
    private int maxMp;

    public WorldBossInfo(String name, int hp, int mp, int maxHp, int maxMp, int attackDamage, int defense, int gold,
                         String description) {
        super(name, hp, mp, maxHp, maxMp, attackDamage, 0, defense);

        this.gold = gold;
        this.description = description;
    }
    public WorldBossInfo(WorldBossInfo other) {
        super(other);
        this.gold = other.gold;
        this.description = other.description;
    }
}
