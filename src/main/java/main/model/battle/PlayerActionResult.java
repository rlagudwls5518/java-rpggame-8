package main.model.battle;

public enum PlayerActionResult {
    TURN_END,       // 턴 정상 종료
    RETRY_ACTION   // 스킬 취소 → 행동 다시 선택 필요
}
