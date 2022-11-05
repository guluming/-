package 난이도2.n진수게임;

import java.util.*;

public class Solution {
    private static String solution(int n, int t, int m, int p) {
        String answer = "";
        String convert = "";

        for (int i = 0; convert.length() < t * m; i++) {
            convert = convert + Integer.toString(i, n);
        }

        for (int i = p - 1; answer.length() < t; i = i + m) {
            answer = answer + convert.charAt(i);
        }

        return answer.toUpperCase();
    }

    public static void main(String[] args) {
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;
        String result = "0111";
        if (solution(n, t, m, p).equals(result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}