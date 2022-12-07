package 가문제메모장;

import java.util.*;

public class Solution4 {
    public static int[] solution(int[] balance, int[][] transaction, int[] abnormal) {
        int[] answer = new int[balance.length];
        System.arraycopy(balance, 0, answer, 0, balance.length);

        int pllog = 0;
        int dellog = 0;
        for (int[] ints : transaction) {
            //주는연산
            answer[ints[0] - 1] = answer[ints[0] - 1] - ints[2];

            //받는연산
            answer[ints[1] - 1] = answer[ints[1] - 1] + ints[2];

            for (int j = 0; j < abnormal.length; j++) {
                if (ints[0] == abnormal[j]) {
                    dellog = ints[0];
                } else if (ints[1] == abnormal[j]) {
                    pllog = ints[1];
                }
            }
        }

        


        System.out.println(dellog);
        System.out.println(pllog);

//        for (int i = 0; i < abnormal.length; i++) {
//            int temp = balance[abnormal[i]];
//
//            if (temp > answer[abnormal[i]]) {
//                temp = temp - answer[abnormal[i]];
//                answer[abnormal[i]] = 0;
//            } else if (temp <= answer[abnormal[i]]) {
//                answer[abnormal[i]] = answer[abnormal[i]] - temp;
//            }
//        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }

    public static void main(String[] args) {
        int[] balance = {30, 30, 30, 30};
        int[][] transaction = {{1, 2, 10}, {2, 3, 20}, {3, 4, 5}, {3, 4, 30}};
        int[] abnormal = {1};
        int[] result = {0, 20, 15, 55};
        if (Arrays.equals(solution(balance, transaction, abnormal), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}