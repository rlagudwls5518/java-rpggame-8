package main.model.unit.character.skill;

import main.model.unit.Unit;

public interface SkillInfo {

    String getName();

    int getMpCost();
    
    int use(Unit user, Unit target);
}
