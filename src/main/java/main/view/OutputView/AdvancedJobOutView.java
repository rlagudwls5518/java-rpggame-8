package main.view.OutputView;

import main.model.unit.character.CharacterJob;
import main.model.unit.character.Skill;

public class AdvancedJobOutView {

    public static void showJobAdvanceScreen(CharacterJob job) {
        // 전직 완료 화면 텍스트 출력
        System.out.println("==================================================");
        System.out.println();
        System.out.println("              ★☆ "+job.getJobAdvancementTier()+" 차 전직 완료 ☆★");
        System.out.println("                    ("+ job.getJobName() +")");
        System.out.println();
        System.out.println("==================================================");
        System.out.println();
        System.out.println("  \"축하합니다! 전직을");
        System.out.println("   성공적으로 완료했습니다!\"");
        System.out.println();
        System.out.println("  당신은 정의의 길을 맹세하고");
        System.out.println("  [ "+ job.getJobName() +" ]로 전직했습니다!");
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("                  [ 성장 결과 ]");
        System.out.println();
        System.out.println("  ▶ 직업: ["+ job.getJobName() +"]");
        System.out.println();
        viewNewSkill(job);
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.println("  \"이제 당신의 신념은 견고한 갑옷이 되어 당신을 지킵니다.\"");
        System.out.println();
        System.out.println();

        System.out.print("[ Enter 키를 눌러 마을로 돌아가기... ]");
    }

    private static void viewNewSkill(CharacterJob job) {
        System.out.println("  ▶ 새로운 스킬을 습득했습니다!");
        for(Skill skill : job.getSkillList()){
            System.out.println("   ▶ 공격스킬 : "+skill.getName());
        }
    }
}
