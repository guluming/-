package 체육복;

import java.util.Arrays;

public class Solution {
    static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i=0; i<lost.length; i++) {
            for (int j=0; j< reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = 0;
                    reserve[j] = 0;
                }
            }
        }

        for (int i=0; i<lost.length; i++) {
            for (int j=0; j<reserve.length; j++) {
                if (reserve[j] != 0 && lost[i] != 0 && (lost[i] == reserve[j]+1 || lost[i] == reserve[j]-1)) {
                    answer++;
                    lost[i] = 0;
                    reserve[j] = 0;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {4,2};
        int[] reserve = {3,5};
        int result = 5;
        if (solution(n, lost, reserve) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}