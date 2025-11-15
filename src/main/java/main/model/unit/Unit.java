package main.model.unit;


public abstract class Unit {

    private int attackDamage;
    private int magicForce;
    private int defense;
    private int hp;
    private int mp;
    private int maxHp;
    private int maxMp;
    public String name;

    public Unit(String name, int maxHp, int maxMp, int attackDamage, int magicForce, int defense) {
        this.name = name;
        this.hp = maxHp;
        this.mp = maxMp;
        this.maxHp = maxHp;
        this.maxMp = maxMp;
        this.attackDamage = attackDamage;
        this.magicForce = magicForce;
        this.defense = defense;
    }

    public Unit(Unit other) {//복사 생성자
        this.name = other.name;
        this.maxHp = other.maxHp;
        this.maxMp = other.maxMp;

        this.hp = this.maxHp;
        this.mp = this.maxMp;
        this.attackDamage = other.attackDamage;
        this.magicForce = other.magicForce;
        this.defense = other.defense;
    }

    public double takeDamage(double incomingDamage) {
        double finalDamage = incomingDamage - this.defense;
        if (finalDamage < 0) {
            finalDamage = 0;
        }
        this.hp -= finalDamage;
        return finalDamage;
    }

    public double takeIgnoreDefenseDamage(double incomingDamage) {
        if (incomingDamage < 0) {
            incomingDamage = 0;
        }
        this.hp -= incomingDamage;
        return incomingDamage;
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
    }

    public void addAttackDamage(int add) {
        this.attackDamage += add;
    }

    public void addMagicForce(int add) {
        this.magicForce += add;
    }

    public void levelUpHp(int add) {
        this.maxHp += add;
    }

    public void levelUpAttackDamage(int add) {
        this.attackDamage += add;
    }

    public void levelUpMagicForce(int add) {
        this.magicForce += add;
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

    public void decreaseMp(int useMp) {
        this.mp -= useMp;
    }
}
