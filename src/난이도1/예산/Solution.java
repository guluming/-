package 난이도1.예산;

import java.util.Arrays;

public class Solution {
    static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for (int i=0; i<d.length; i++) {
            budget = budget - d[i];
            if (budget >= 0) {
                answer++;
            } else if (budget < 0) {
                break;
            }
        }
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        int budget = 9;
        int result = 3;
        if (solution(d, budget) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}
