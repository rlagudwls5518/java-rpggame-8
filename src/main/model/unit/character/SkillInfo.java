package main.model.unit.character;

import main.model.unit.Unit;

public interface SkillInfo {

    String getName();

    String getDescription();

    int getMpCost();

    void use(Unit user, Unit target);
}
