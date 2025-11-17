package main.model.unit.character;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import main.model.unit.Unit;
import main.model.unit.character.job.firstClass.SwordMan;
import main.util.Clear;
import main.view.AdvancedJobOutView;
import main.view.JobChoiceOutView;

public class PlayerCharacter extends Unit {
    private int level;
    private int exp;
    private final int maxExp;
    private int gold;
    private CharacterJob currentJob;
    private final int levelUpPlusStr;
    private final int levelUpPlusInt;
    private final int levelUpPlusMaxHP;
    private final int levelUpPlusDfs;
    private List<Skill> skills = new ArrayList<>();

    public PlayerCharacter(String name) {
        super(name, 100, 50, 100, 0, 10);
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
        skills = new ArrayList<>(currentJob.getSkillList());
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
        this.exp += addExp;
        while (this.exp >= this.maxExp) {
            int expUsedForLevelUp = this.maxExp;
            this.exp -= expUsedForLevelUp;
            levelUp();
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
        int addAttackDamage = newJob.getAttackBonus();
        addAttackDamage(addAttackDamage);
        int addMaxHp = newJob.getHpBonus();
        addMaxHp(addMaxHp);
    }

    private void levelUp() {
        level++;
        levelUpHp(levelUpPlusMaxHP);
        levelUpAttackDamage(levelUpPlusStr);
        levelUpDefense(levelUpPlusDfs);
    }

    public int caculateLevel(int monsterExp) {
        return (monsterExp + getCurrentExp()) % maxExp;
    }

    private boolean checkAdvancement() {
        return currentJob.canAdvance(this.level);
    }

    public void ProcessAdvancement() {
        Scanner sc = new Scanner(System.in);

        if (!checkAdvancement()) {
            return;
        }

        // 전직이 가능하다면, '현재 직업'에게 다음 전직 옵션들을 받아옴
        List<CharacterJob> advancementOptions = currentJob.getAdvancementOptions();

        if (advancementOptions.isEmpty()) {
            return;
        }

        // 3. 전직 옵션이 1개일 경우 (김형진님의 '2차 전직')
        if (advancementOptions.size() == 1) {
            CharacterJob nextJob = advancementOptions.get(0);
            advanceJob(nextJob);
            AdvancedJobOutView.showJobAdvanceScreen(currentJob);
        } else {
            JobChoiceOutView.jobChoice(advancementOptions);

            int choice = sc.nextInt();

            CharacterJob nextJob = currentJob.advance(choice);
            advanceJob(nextJob);
            Clear.clearScreen();
            AdvancedJobOutView.showJobAdvanceScreen(currentJob);
        }
    }

    public int getCurrentExp() {
        return exp;
    }

    public int getMaxExp() {
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
