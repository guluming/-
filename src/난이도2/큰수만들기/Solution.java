package 난이도2.큰수만들기;

import java.util.*;

public class Solution {
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int index = 0;
        for (int i = 0; i < number.length() - k; i++) {
            int maxNumber = 0;
            for (int j = index; j <= k + i; j++) {
                if (maxNumber < number.charAt(j) - '0') {
                    maxNumber = number.charAt(j) - '0';
                    index = j + 1;
                }
            }
            answer.append(maxNumber);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        String number = "1924";
        int k = 2;
        String result = "94";
        if (solution(number, k).equals(result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}