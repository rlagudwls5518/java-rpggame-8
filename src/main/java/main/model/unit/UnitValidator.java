package main.model.unit;

public class UnitValidator {

    public static final String ERROR_INVALID_NAME = "[ERROR] 유닛 이름이 올바르지 않습니다.";
    public static final String ERROR_INVALID_MAX_HP = "[ERROR] maxHp는 0보다 커야 합니다.";
    public static final String ERROR_INVALID_MAX_MP = "[ERROR] maxMp는 0 이상이어야 합니다.";
    public static final String ERROR_INVALID_ATTACK_DAMAGE = "[ERROR] 공격력은 음수가 될 수 없습니다.";
    public static final String ERROR_INVALID_DEFENSE = "[ERROR] 방어력은 음수가 될 수 없습니다.";
    public static final String ERROR_NULL_COPY_TARGET = "[ERROR] 복사할 대상이 null입니다.";

    public static void validateUnit(String name, int maxHp, int maxMp, int attackDamage, int defense) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ERROR_INVALID_NAME);
        }
        if (maxHp <= 0) {
            throw new IllegalArgumentException(ERROR_INVALID_MAX_HP);
        }
        if (maxMp < 0) {
            throw new IllegalArgumentException(ERROR_INVALID_MAX_MP);
        }
        if (attackDamage < 0) {
            throw new IllegalArgumentException(ERROR_INVALID_ATTACK_DAMAGE);
        }
        if (defense < 0) {
            throw new IllegalArgumentException(ERROR_INVALID_DEFENSE);
        }
    }

    public static void validateCopyUnit(Unit other) {
        if (other == null) {
            throw new IllegalArgumentException(ERROR_NULL_COPY_TARGET);
        }
    }
}
