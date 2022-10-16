package 난이도2.괄호회전하기;

import java.util.*;
import java.util.stream.Stream;

public class Solution {
    private static Map<Character, Character> hm = new HashMap<>();

    public static int solution(String s) {
        int ret = 0;
        if(s.length()%2 == 1) return ret;
        hm.put(')','(');
        hm.put('}','{');
        hm.put(']','[');
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<s.length() ; i++) {
            sb.append(s.charAt(i));
        }
        for(int i=0 ; i<s.length() ; i++) {
            if(helper(sb)) ret++;
            char c = sb.charAt(0);
            sb.deleteCharAt(0).append(c);
        }
        return ret;
    }

    public static boolean helper(StringBuilder sb) {
        Stack<Character> s = new Stack<>();
        for(int i=0 ; i<sb.length() ; i++) {
            char c = sb.charAt(i);
            if(hm.containsKey(c)) {
                if(s.isEmpty() || s.pop()!=hm.get(c)) return false;
            } else {
                s.push(c);
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[](){}";
        int result = 3;
        if (solution(s) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}