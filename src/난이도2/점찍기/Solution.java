package 난이도2.점찍기;

import java.util.*;

public class Solution {

    public static long solution(int k, int d) {
        long answer = 0;
        for (int i = 0; i <= d; i = i + k) {
            long roundD = (long) d * d;
            long roundI = (long) i * i;
            int top = (int) Math.sqrt(roundD - roundI);
            answer = answer + (top / k) + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 2;
        int d = 4;
        long result = 6;
        if (solution(k, d) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}