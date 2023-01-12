package 난이도2.숫자블록;

import java.util.*;

public class Solution {
    public static int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];
        for (int i = (int) begin; i < (int) end + 1; i++) {
            answer[i - (int) begin] = 1;

            for (int j = 2; j <= Math.floor(Math.sqrt(i)); j++) {
                if (i % j == 0 && i / j <= 10000000) {
                    answer[i - (int) begin] = i / j;
                    break;
                }
            }
        }

        if (begin == 1) {
            answer[0] = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        long begin = 1;
        long end = 10;
        int[] result = {0, 1, 1, 2, 1, 3, 1, 4, 3, 5};
        if (Arrays.equals(solution(begin, end), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}