package 가문제메모장;

import java.util.*;

public class Solution5 {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int high_win = 7;
        int low_win = 7;

        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                high_win--;
            }

            for (int j = 0; j < 6; j++) {
                if(win_nums[j] == lottos[i]) {
                    high_win--;
                    low_win--;
                }
            }

        }

        if (high_win == 7) {
            high_win = 6;
        }

        if (low_win == 7) {
            low_win = 6;
        }

        int[] answer = {high_win, low_win};
        return answer;
    }

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] result = {3, 5};
        if (Arrays.equals(solution(lottos, win_nums), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}