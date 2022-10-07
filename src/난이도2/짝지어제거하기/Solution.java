package 난이도2.짝지어제거하기;

import java.util.*;

public class Solution {
    public static int solution(String s) {
        Stack<Character> check_s = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (i == 0) {
                check_s.push(s.charAt(i));
            } else {
                if (check_s.empty()) {
                    check_s.push(s.charAt(i));
                } else if (check_s.peek().equals(s.charAt(i))) {
                    check_s.pop();
                } else {
                    check_s.push(s.charAt(i));
                }
            }
        }

        if (check_s.empty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        String s = "baabaa";
        int result = 1;
        if (solution(s) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}