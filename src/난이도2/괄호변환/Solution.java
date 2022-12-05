package 난이도2.괄호변환;

import java.util.*;

public class Solution {
    public static String solution(String p) {
        if (check(p)) {
            return p;
        } else {
            return changeString(p);
        }
    }

    public static boolean check(String p) {
        Stack<Character> stringStack = new Stack<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == ')') {
                if (stringStack.empty()) {
                    return false;
                }
                stringStack.pop();
            } else {
                stringStack.push('(');
            }
        }

        return stringStack.empty();
    }

    public static String changeString(String p) {
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        if (p.length() == 0) {
            return "";
        }

        int checkString = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                checkString++;
            } else {
                checkString--;
            }

            if (checkString == 0) {
                u.append(p.substring(0, i + 1));
                v.append(p.substring(i + 1, p.length()));

                if (check(u.toString())) {
                    u.append(changeString(v.toString()));
                } else {
                    StringBuilder w = new StringBuilder();
                    w.append("(");
                    w.append(changeString(v.toString()));
                    w.append(")");
                    w.append(reverse(u.toString()));

                    return w.toString();
                }
                break;
            }
        }

        return u.toString();
    }

    public static String reverse(String u) {
        StringBuilder s = new StringBuilder();

        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                s.append(")");
            } else {
                s.append("(");
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String p = "()))((()";
        String result = "()(())()";
        if (solution(p).equals(result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}