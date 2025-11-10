package main.model.unit;

public abstract class Unit {

    protected String name;
    protected int hp;
    protected int maxHp;
    protected int mp;
    protected int attackDamage;
    protected int abilityPower;
    protected int defense;
    protected int magicDefense;

    public int takeDamage(int incomingDamage) {
        int finalDamage = incomingDamage - this.defense;
        if (finalDamage < 0) {
            finalDamage = 0;
        }
        this.hp -= finalDamage;
        return finalDamage;
    }


    public int basicAttack(Unit target) {
        int myAttack = this.attackDamage;
        int actualDamage = target.takeDamage(myAttack);
        return actualDamage;
    }

    public boolean isDead() {
        return this.hp <= 0;
    }

    public int getHp() {
        return this.hp;
    }


}
