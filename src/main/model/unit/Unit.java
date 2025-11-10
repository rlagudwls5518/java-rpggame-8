package main.model.unit;

import java.util.ArrayList;
import java.util.List;
import main.model.unit.character.skill.SkillInfo;

public abstract class Unit {

    protected int attackDamage;
    protected int defense;

    private final List<SkillInfo> skills;
    private final String name;
    private int hp;
    private int mp;
    private int maxHp;

    public Unit(String name, int hp, int mp, int maxHp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.maxHp = maxHp;
        this.skills = new ArrayList<>();
    }

    public double takeDamage(double incomingDamage) {
        double finalDamage = incomingDamage - this.defense;
        if (finalDamage < 0) {
            finalDamage = 0;
        }
        this.hp -= finalDamage;
        return finalDamage;
    }


    public double basicAttack(Unit target) {
        int myAttack = this.attackDamage;
        double actualDamage = target.takeDamage(myAttack);
        return actualDamage;
    }

    public boolean isDead() {
        return this.hp <= 0;
    }

    public int getHp() {
        return this.hp;
    }

    public int getMaxHp() {
        return this.maxHp;
    }
    public void addMaxHP(int add){
        this.maxHp+=add;
    }
    public void addAttackDamage(int add){
        this.attackDamage+=add;
    }

    public int getMp() {
        return this.mp;
    }

    public int getAd() {
        return this.attackDamage;
    }

    public void decreaseMp(int useMp){
        this.mp-= useMp;
    }
}
