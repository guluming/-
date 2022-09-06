package 신고결과받기;

import java.util.Arrays;

public class Main {
    public static void main(String[] ars) {
        Solution s = new Solution();

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        int[] answer = s.solution(id_list, report, k);
        int[] result = {2,1,1,0};

        if (Arrays.equals(answer, result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("일치하지 않습니다.");
        }
    }
}
