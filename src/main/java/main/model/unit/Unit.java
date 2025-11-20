package main.model.unit;


import static main.model.unit.UnitValidator.validateCopyUnit;
import static main.model.unit.UnitValidator.validateUnit;

public abstract class Unit {

    private int attackDamage;
    private int defense;
    private int hp;
    private int mp;
    private int maxHp;
    private int maxMp;
    public String name;

    public Unit(String name, int maxHp, int maxMp, int attackDamage, int defense) {
        validateUnit(name, maxHp, maxMp, attackDamage, defense);
        this.name = name;
        this.hp = maxHp;
        this.mp = maxMp;
        this.maxHp = maxHp;
        this.maxMp = maxMp;
        this.attackDamage = attackDamage;
        this.defense = defense;
    }

    public Unit(Unit other) {
        validateCopyUnit(other);
        validateUnit(other.name, other.maxHp, other.maxMp, other.attackDamage, other.defense);

        this.name = other.name;
        this.maxHp = other.maxHp;
        this.maxMp = other.maxMp;

        this.hp = this.maxHp;
        this.mp = this.maxMp;
        this.attackDamage = other.attackDamage;
        this.defense = other.defense;
    }

    public void takeDamage(double incomingDamage) {
        double finalDamage = incomingDamage - this.defense;
        if (finalDamage < 0) {
            finalDamage = 0;
        }
        this.hp -= finalDamage;
    }

    public void takeIgnoreDefenseDamage(double incomingDamage) {
        if (incomingDamage < 0) {
            incomingDamage = 0;
        }
        this.hp -= incomingDamage;
    }

    public void attack(Unit target) {
        int damage = this.attackDamage;
        target.takeDamage(damage);
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public void addMaxHp(int add) {
        this.maxHp += add;
        this.hp = this.maxHp;
    }

    public void addAttackDamage(int add) {
        this.attackDamage += add;
    }

    public void levelUpHp(int add) {
        this.maxHp += add;
    }

    public void levelUpAttackDamage(int add) {
        this.attackDamage += add;
    }


    public void levelUpDefense(int add) {
        this.defense += add;
    }

    public int getMp() {
        return this.mp;
    }

    public int getAd() {
        return this.attackDamage;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    public int getHp() {
        return this.hp;
    }

    public int getMaxMp() {
        return this.maxMp;
    }
    public void refillHpMp(){
        this.hp = this.maxHp;
        this.mp = this.maxMp;
    }

    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }

    public void decreaseMp(int useMp) {
        this.mp -= useMp;
    }
}
