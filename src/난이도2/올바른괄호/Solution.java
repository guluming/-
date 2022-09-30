package 난이도2.올바른괄호;

import java.util.*;

public class Solution {
    public static boolean solution(String s) {
        Stack<Character> stringStack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
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

    public static void main(String[] args) {
        String s = "()()";
        boolean result = true;
        if (solution(s) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}