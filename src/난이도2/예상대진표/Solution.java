package 난이도2.예상대진표;

import java.util.*;

public class Solution {
    public static int solution(int n, int a, int b) {
        int answer = 0;
        while (a != b) {
            answer++;
            if (a % 2 == 1) {
                a = a + 1;
            }
            if (b % 2 == 1) {
                b = b + 1;
            }
            a = a / 2;
            b = b / 2;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 16;
        int a = 9;
        int b = 12;
        int result = 2;
        if (solution(n, a, b) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}