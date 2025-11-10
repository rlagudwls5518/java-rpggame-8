package main.model.unit;

import java.util.ArrayList;
import java.util.List;
import main.model.unit.character.CharacterJob;
import main.model.unit.character.job.firstClass.SwordMan;
import main.model.unit.character.skill.SkillInfo;

public class PlayerCharacter extends Unit {
    private int level;
    private int exp;
    private int gold;
    private int statPoints;
    private CharacterJob currentJob;
    private int baseStr;
    private int baseInt;
    private int baseVit;
    private List<SkillInfo> skills = new ArrayList<>();

    public PlayerCharacter(String name) {
        super(name, 100, 50, 100, 10, 10, 0);
        this.level = 1;
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

    public void learnSkill(SkillInfo skillToAdd) {
        this.skills.add(skillToAdd);
    }

    public void updateStats(CharacterJob newJob) {
        if (newJob.getJobName().equals("기사") || newJob.getJobName().equals("대검사") || newJob.getJobName()
                .equals("용기사")) {
            int addAttackDamage = this.baseStr * 2 + this.currentJob.getAttackBonus();
            addAttackDamage(addAttackDamage);
        }

        int addMagicForce = this.baseInt * 2 + this.currentJob.getAttackBonus();
        int addHp = 100 + this.baseVit * 10 + this.currentJob.getHpBonus();
        addMagicForce(addMagicForce);
        addMaxHP(addHp);
    }
}
