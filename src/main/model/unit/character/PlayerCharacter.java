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

    private final List<SkillInfo> skills = new ArrayList<>();

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
        List<SkillInfo> skillsToLearn = newJob.getSkillList();
        for(SkillInfo skills : skillsToLearn){
            this.learnSkill(skills);
        }
    }

    public void storeExp(int addExp){
        if((this.exp + addExp) >= this.maxExp){
            int dummyExp = (this.exp + addExp) - maxExp;
            levelUp();
            this.exp += dummyExp;
        }
        else{
            this.exp += addExp;
        }
    }

    public void learnSkill(SkillInfo skillToAdd) {
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

    private void levelUp(){
        this.level++;
        this.exp = 0;
        levelUpHp(levelUpPlusMaxHP);
        levelUpAttackDamage(levelUpPlusStr);
        levelUpDefense(levelUpPlusDfs);
        if(this.currentJob.getJobName().equals("성기사") || this.currentJob.getJobName().equals("성검사")){
            levelUpMagicForce(levelUpPlusInt);
        }
    }
}
