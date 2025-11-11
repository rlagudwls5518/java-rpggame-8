package main.model.unit;


public abstract class Unit {

    private int attackDamage;
    private int magicForce;
    private int defense;
    private int hp;
    private int mp;
    private int maxHp;
    private int maxMp;
    private String name;

    public Unit(String name, int hp, int mp, int maxHp, int maxMp, int attackDamage, int magicForce, int defense) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.maxHp = maxHp;
        this.maxMp = maxMp;
        this.attackDamage = attackDamage;
        this.magicForce = magicForce;
        this.defense = defense;
    }

    public Unit(Unit other) {//복사 생성자
        this.name = other.name;
        this.hp = this.maxHp;
        this.mp = other.mp;
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

    public double basicAttack(Unit target) {
        int myAttack = this.attackDamage;
        double actualDamage = target.takeDamage(myAttack);
        return actualDamage;
    }

    public boolean isDead() {
        return this.hp <= 0;
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

    public void decreaseMp(int useMp) {
        this.mp -= useMp;
    }
}
