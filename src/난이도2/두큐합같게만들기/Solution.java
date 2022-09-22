package 난이도2.두큐합같게만들기;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long q1sum = 0L;
        long q2sum = 0L;
        for (int i = 0; i < queue1.length; i++) {
            q1sum = q1sum + (long) queue1[i];
            q1.offer(queue1[i]);
            q2sum = q2sum + (long) queue2[i];
            q2.offer(queue2[i]);
        }

        int answer = 0;
        while (q1sum != q2sum) {
            answer++;
            if (q1sum > q2sum) {
                int value = q1.poll();
                q1sum = q1sum - value;
                q2sum = q2sum + value;
                q2.offer(value);
            } else {
                int value = q2.poll();
                q1sum = q1sum + value;
                q2sum = q2sum - value;
                q1.offer(value);
            }

            if (answer > (queue1.length + queue2.length) * 2) return -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] queue1 = {1, 2, 1, 2};
        int[] queue2 = {1, 10, 1, 2};
        int result = 7;
        if (solution(queue1, queue2) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}