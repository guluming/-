package 난이도2.일이사나라의숫자;

import java.util.*;

public class Solution {
    public static String solution(int n) {
        String[] numberPoint = {"4", "1", "2"};
        String answer = "";

        while (n > 0) {
            int num = n % 3;
            n = n / 3;

            if (num == 0) {
                n--;
            }

            answer = numberPoint[num] + answer;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 10;
        String result = "41";
        if (solution(n).equals(result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}