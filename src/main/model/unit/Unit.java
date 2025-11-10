package main.model.unit;

import java.util.ArrayList;
import java.util.List;
import main.model.unit.character.skill.SkillInfo;

public abstract class Unit {

    private int attackDamage;
    private int magicForce;
    private int defense;
    private int hp;
    private int mp;
    private int maxHp;
    private final String name;

    public Unit(String name, int hp, int mp, int maxHp, int attackDamage, int magicForce, int defense) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.maxHp = maxHp;
        this.attackDamage = attackDamage;
        this.magicForce = magicForce;
        this.defense = defense;
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

    public void addMaxHP(int add) {
        this.maxHp += add;
    }

    public void addAttackDamage(int add) {
        this.attackDamage += add;
    }

    public void addMagicForce(int add) {
        this.magicForce += add;
    }

    public int getHp() {
        return this.hp;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    public int getMp() {
        return this.mp;
    }

    public int getAd() {
        return this.attackDamage;
    }

    public int getAp() {
        return this.magicForce;
    }

    public void decreaseMp(int useMp) {
        this.mp -= useMp;
    }
}
