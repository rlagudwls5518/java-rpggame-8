package main.view.OutputView;

import java.util.List;
import main.model.unit.character.CharacterJob;

public class JobChoiceOutView {

    public static void jobChoice(List<CharacterJob> jobList) {
        System.out.println("--------------------------------------------------");
        System.out.println("\n            ★★★  2차 전직 완료 ★★★\n");
        System.out.println("--------------------------------------------------");
        System.out.println("  [기사]의 길을 걸어온 당신,");
        System.out.println("  이제 '성능'과 '안정성'이라는 두 가지 길 중");
        System.out.println("  하나의 전문가로 나아갈 때가 되었습니다.\n");
        System.out.println("--------------------------------------------------");
        for(int i=0;i<jobList.size();i++) {
            jobDescription(jobList.get(i), i);
        }

        System.out.println("--------------------------------------------------");
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
            System.out.println("  \"거대한 대검을 휘둘러 전장을 가르는 전사.");
            System.out.println("   압도적인 일격으로 적을 제압하는 공격의 화신입니다.\"\n");
        }
        else if(job.getJobName().equals("성기사")){
            System.out.println("  \"성스러운 힘을 두른 방패이자 검.");
            System.out.println("   치유와 보호의 힘으로 아군을 지키는 수호자의 길입니다.\"\n");
        }
    }

    private static void jobTendency(CharacterJob job){
        if(job.getJobName().equals("대검사")){
            System.out.println("  ▶ 성향: 강력한 공격, 폭발적인 한 방, 근접 전투 중심");
        }
        else if(job.getJobName().equals("성기사")){
            System.out.println("  ▶ 성향: 방어, 보호, 생존력, 지원 능력");
        }
    }
}
