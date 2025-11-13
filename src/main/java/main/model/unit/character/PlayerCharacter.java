package main.model.unit.character;

import java.util.ArrayList;
import java.util.List;
import main.model.unit.Unit;
import main.model.unit.character.job.firstClass.SwordMan;

public class PlayerCharacter extends Unit {
    private int level;
    private int exp;
    private int maxExp;
    private int gold;
    private CharacterJob currentJob;
    private final int levelUpPlusStr;
    private final int levelUpPlusInt;
    private final int levelUpPlusMaxHP;
    private final int levelUpPlusDfs;
    private final List<Skill> skills = new ArrayList<>();

    public PlayerCharacter(String name) {
        super(name, 100, 50, 100, 10, 10, 0, 10);
        this.levelUpPlusDfs = 10;
        this.level = 1;
        this.exp = 0;
        this.maxExp = 100;
        this.levelUpPlusInt = 10;
        this.levelUpPlusMaxHP = 10;
        this.levelUpPlusStr = 5;
        this.currentJob = new SwordMan();
        updateStats(currentJob);
    }

    public void advanceJob(CharacterJob newJob) {
        this.currentJob = newJob;
        updateStats(newJob);
        List<Skill> skillsToLearn = newJob.getSkillList();
        for (Skill skills : skillsToLearn) {
            this.learnSkill(skills);
        }
    }

    public void storeExp(int addExp) {
        if ((this.exp + addExp) >= this.maxExp) {
            int dummyExp = (this.exp + addExp) - maxExp;
            levelUp();
            this.exp += dummyExp;
        } else {
            this.exp += addExp;
        }
    }
    public void showSkillList(){
        List<Skill> skills = currentJob.getSkillList();

        for(int i=0; i<skills.size(); i++){
            Skill skill = skills.get(i);
            System.out.println((i + 1) + ". " + skill.getName() +
                    " (MP 소모: " + skill.getMpCost() + ")");
        }
    }

    public void useSkill(Unit target, int skilNumber) {
        List<Skill> skills = currentJob.getSkillList();

        Skill selectedSkill = skills.get(skilNumber);
        if (this.getMp() < selectedSkill.getMpCost()) {
            System.out.println("MP가 부족하여 '" + selectedSkill.getName() + "'을(를) 사용할 수 없습니다!");
            return;
        }
        this.decreaseMp(selectedSkill.getMpCost());
        selectedSkill.use(this,target);
    }

    public void learnSkill(Skill skillToAdd) {
        this.skills.add(skillToAdd);
    }

    private void updateStats(CharacterJob newJob) {
        if (newJob.getJobName().equals("기사") || newJob.getJobName().equals("대검사") || newJob.getJobName()
                .equals("용기사")) {
            int addAttackDamage = this.currentJob.getAttackBonus();
            addAttackDamage(addAttackDamage);
        }

        int addMagicForce = this.currentJob.getAttackBonus();
        int addMaxHp = this.currentJob.getHpBonus();
        addMagicForce(addMagicForce);
        addMaxHp(addMaxHp);
    }

    private void levelUp() {
        this.level++;
        this.exp = 0;
        levelUpHp(levelUpPlusMaxHP);
        levelUpAttackDamage(levelUpPlusStr);
        levelUpDefense(levelUpPlusDfs);
        if (this.currentJob.getJobName().equals("성기사") || this.currentJob.getJobName().equals("성검사")) {
            levelUpMagicForce(levelUpPlusInt);
        }
    }
}
