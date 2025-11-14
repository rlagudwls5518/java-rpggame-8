package main.model.unit.character;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
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
    private List<Skill> skills = new ArrayList<>();

    public PlayerCharacter(String name) {
        super(name, 100, 50, 10, 0, 10);
        levelUpPlusDfs = 10;
        level = 1;
        exp = 0;
        maxExp = 100;
        levelUpPlusInt = 10;
        levelUpPlusMaxHP = 10;
        levelUpPlusStr = 5;
        gold = 0;
        currentJob = new SwordMan();
        updateStats(currentJob);
        skills = currentJob.getSkillList();
    }

    public void advanceJob(CharacterJob newJob) {
        currentJob = newJob;
        updateStats(newJob);
        skills.clear();
        List<Skill> skillsToLearn = newJob.getSkillList();
        for (Skill skills : skillsToLearn) {
            learnSkill(skills);
        }
    }

    public void storeGold(int addGold) {
        gold += addGold;
    }

    public void storeExp(int addExp) {
        if ((exp + addExp) >= maxExp) {
            int dummyExp = (exp + addExp) - maxExp;
            levelUp();
            exp += dummyExp;
        } else {
            exp += addExp;
        }
    }

    public void showSkillList() {
        IntStream.range(0, skills.size())
                .forEach(i -> {
                    Skill skill = skills.get(i);
                    System.out.println((i + 1) + ". " + skill.getName() +
                            " (MP : " + skill.getMpCost() + ")");
                });
    }

    public String showSkillName(int skillNum) {
        return skills.get(skillNum).getName();
    }

    public void useSkill(Unit target, int skillNumber) {
        int indexNumber = skillNumber - 1;
        Skill selectedSkill = skills.get(indexNumber);
        if (this.getMp() < selectedSkill.getMpCost()) {
            System.out.println("MP가 부족하여 '" + selectedSkill.getName() + "'을(를) 사용할 수 없습니다!");
            return;
        }
        this.decreaseMp(selectedSkill.getMpCost());
        selectedSkill.use(this, target);
    }

    public void learnSkill(Skill skillToAdd) {
        skills.add(skillToAdd);
    }

    private void updateStats(CharacterJob newJob) {
        if (newJob.getJobName().equals("기사") || newJob.getJobName().equals("대검사") || newJob.getJobName()
                .equals("용기사")) {
            int addAttackDamage = currentJob.getAttackBonus();
            addAttackDamage(addAttackDamage);
        }

        int addMagicForce = currentJob.getAttackBonus();
        int addMaxHp = currentJob.getHpBonus();
        addMagicForce(addMagicForce);
        addMaxHp(addMaxHp);
    }

    private void levelUp() {
        level++;
        exp = 0;
        levelUpHp(levelUpPlusMaxHP);
        levelUpAttackDamage(levelUpPlusStr);
        levelUpDefense(levelUpPlusDfs);
        if (currentJob.getJobName().equals("성기사") || currentJob.getJobName().equals("성검사")) {
            levelUpMagicForce(levelUpPlusInt);
        }
    }
    public int getCurrentExp(){
        return exp;
    }
    public int getMaxExp(){
        return maxExp;
    }

    public String getJobName() {
        return currentJob.getJobName();
    }

    public int getGold() {
        return gold;
    }

    public int getLevel() {
        return level;
    }
}
