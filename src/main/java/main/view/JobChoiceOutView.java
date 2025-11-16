package main.view;

import java.util.List;
import main.model.unit.character.CharacterJob;

public class JobChoiceOutView {

    public static void jobChoice(List<CharacterJob> jobList) {
        System.out.println("==================================================");
        System.out.println("\n            ★★★ 2차 전직 완료 ★★★\n");
        System.out.println("==================================================");
        System.out.println("  [기사]의 길을 걸어온 당신,");
        System.out.println("  이제 '성능'과 '안정성'이라는 두 가지 길 중");
        System.out.println("  하나의 전문가로 나아갈 때가 되었습니다.\n");
        System.out.println("--------------------------------------------------");
        for(int i=0;i<jobList.size();i++) {
            jobDescription(jobList.get(i), i);
        }

        System.out.println("==================================================");
        System.out.print("\n  당신의 신념을 선택하세요 (1 또는 2): ");
    }

    private static void jobDescription(CharacterJob job, int index) {
        System.out.println(" [ 선택 "+(index+1)+": "+job.getJobName()+"  ]\n");
        jobCharacteristics(job);
        System.out.println("  ▶ 특화: [공격 스킬 1개] 추가 획득 (총 공격 2)");
        jobTendency(job);
        System.out.println("  ▶ 3차 전직: "+job.getJobName()+" \n");
        System.out.println("--------------------------------------------------");
    }

    private static void jobCharacteristics(CharacterJob job){
        if(job.getJobName().equals("대검사")){
            System.out.println("  \"대검이 거대한 트래픽을 가르듯,");
            System.out.println("   성능의 극한을 추구하는 공격적인 코드로 전장을 지배합니다.\"\n");
        }
        if(job.getJobName().equals("성검사")){
            System.out.println("  \"성스러운 테스트 코드가 버그를 막아내듯,");
            System.out.println("   견고한 아키텍처로 동료들을 보호하고 서비스를 수호합니다.\"\n");
        }
    }
    private static void jobTendency(CharacterJob job){
        if(job.getJobName().equals("대검사")){
            System.out.println("  ▶ 성향: 공격 / 성능 최적화");
        }
        if(job.getJobName().equals("성검사")){
            System.out.println("  ▶ 성향: 방어 / 안정성 / 아키텍처");
        }
    }
}
