package 난이도2.점프와순간이동;

import java.util.*;

public class Solution {
    public static long solution(int N) {
        int answer = 0;

        while (N > 0) {
            if (N % 2 == 1) {
                N = N - 1;
                N = N / 2;
                answer++;
            } else {
                N = N / 2;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int N = 5000;
        int result = 5;
        if (solution(N) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}