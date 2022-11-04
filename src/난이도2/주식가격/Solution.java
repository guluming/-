package 난이도2.주식가격;

import java.util.*;

public class Solution {
    private static int[] solution(int[] prices) {
        int count = 0;
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    count++;
                } else if (i == prices.length - 1) {
                    answer[i] = 0;
                } else {
                    count++;
                    answer[i] = count;
                    count = 0;
                    break;
                }

                if (j == prices.length - 1) {
                    answer[i] = count;
                    count = 0;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] result = {4, 3, 1, 1, 0};
        if (Arrays.equals(solution(prices), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}