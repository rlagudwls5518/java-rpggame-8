package main.model.unit;

import main.model.unit.character.CharacterJob;
import main.model.unit.character.job.firstClass.SwordMan;
import main.model.unit.character.skill.SkillInfo;

public class PlayerCharacter extends Unit {
    private int level;
    private int exp;
    private int gold;
    private int statPoints;

    private int baseStr;
    private int baseInt;

    private CharacterJob currentJob;
    private int baseVit;

    public PlayerCharacter(String name) {
        super(name, 100, 50, 100);
        this.level = 1;
        this.currentJob = new SwordMan();
        updateStats();
    }

    public void advanceJob(CharacterJob newJob) {
        this.currentJob = newJob;
        System.out.println(newJob.getJobName() + "(으)로 전직했습니다!");
        updateStats();
    }


    public void updateStats() {
        int addAttackDamage = this.baseStr * 2 + this.currentJob.getAttackBonus();
        int addHp = 100 + this.baseVit * 10 + this.currentJob.getHpBonus();

        addAttackDamage(addAttackDamage);
        addMaxHP(addHp);
    }

    public void displayStatusWindow() {
        System.out.println("===============================");
        System.out.println(" 이름: " );
        System.out.println(" 레벨: " + this.level);


        System.out.println(" 직업: " + this.currentJob.getJobName());

        System.out.println(" HP: " + this.getHp() + " / " + this.getMaxHp());


        System.out.println("[ 스킬 목록 ]");
        int i = 1;
        for (SkillInfo skill : this.currentJob.getSkillList()) {
            System.out.println(i + ". " + skill.getName() + " (MP " + skill.getMpCost() + ")");
            i++;
        }
        System.out.println("===============================");
    }
}
