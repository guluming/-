package 난이도2.더맵게;

import java.util.*;

public class Solution {
    private static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scoville_list = new PriorityQueue<>();
        for (int i=0; i<scoville.length; i++) {
            scoville_list.add(scoville[i]);
        }

        int answer = 0;
        while (scoville_list.size() > 1 && scoville_list.peek() < K) {
            int num1 = scoville_list.poll();
            int num2 = scoville_list.poll();
            scoville_list.add(num1 + num2 * 2);
            answer++;
        }

        if (scoville_list.size() <= 1 && scoville_list.peek() < K) {
            return -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = {12, 2, 3, 9, 10, 1};
        int K = 7;
        int result = 2;
        if (solution(scoville, K) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}