package 난이도2.택배상자;

import java.util.*;

public class Solution {
    public static int solution(int[] order) {
        int answer = 0;

        Stack<Integer> saveOrder = new Stack<Integer>();

        int defaultOrder = 1;
        int wantOrderIdx = 0;

        while (true) {
            if (!saveOrder.isEmpty() && order[wantOrderIdx] == saveOrder.peek()) {
                answer++;

                wantOrderIdx++;
                saveOrder.pop();

                continue;
            }

            if (defaultOrder > order.length) {
                break;
            }

            if (order[wantOrderIdx] == defaultOrder) {
                answer++;

                wantOrderIdx++;
                defaultOrder++;

                continue;
            }

            saveOrder.push(defaultOrder);
            defaultOrder++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] order = {4, 3, 1, 2, 5};
        int result = 2;
        if (solution(order) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}