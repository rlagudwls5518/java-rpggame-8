package main.model.unit.monster;

import main.model.unit.Unit;

public class MidBossMonsterInfo extends Unit {

    private static final int EXP = 10;
    private int gold;
    private String description;
    private String name;
    private int hp;
    private int mp;
    private int maxHp;
    private int maxMp;
    private int attackDamage;
    private int magicForce;
    private int defense;

    MidBossMonsterInfo(String name, int hp, int mp, int maxHp, int maxMp, int attackDamage, int magicForce, int defense, int gold,
                       String description) {

        super(name, hp, mp, maxHp, maxMp, attackDamage, 0, defense);
        this.gold = gold;
        this.description = description;

    }
    public MidBossMonsterInfo(MidBossMonsterInfo other) {
        super(other);
        this.gold = other.gold;
        this.description = other.description;
    }
}
