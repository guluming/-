package 난이도2.이곱하기n타일링;

import java.util.*;

public class Solution {
    private static int solution(int n) {
        if (n <= 2) {
            return n;
        }

        int answer = 0;
        int count = 3;
        int n1 = 1;
        int n2 = 2;
        while (count < n) {
            answer = (n1 + n2) % 1000000007;
            n1 = n2;
            n2 = answer;
            count++;
        }

        answer = (n1 + n2) % 1000000007;
        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        int result = 5;
        if (solution(n) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}