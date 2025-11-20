package main.model.unit.monster;

public enum MonsterType {
    MINI,
    MID_BOSS,
    FINAL_BOSS,
    TRUE_FINAL_BOSS;

    @Override
    public String toString() {
        return this.name();
    }
}
