package main.model.unit.character.skill;

import main.model.unit.Unit;

public interface SkillInfo {

    String getName();

    String getExplanation();

    int getMpCost();

    void use(Unit user, Unit target);
}
