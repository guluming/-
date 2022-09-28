package 난이도2.JadenCase문자열만들기;

import java.util.*;

public class Solution {
    public static String solution(String s) {
        String[] saar1 = s.split(" ");
        for (int i=0; i< saar1.length; i++) {
            String[] saar2 = saar1[i].split("");
            

            if (!saar2[i].matches("\\d")) {
                saar2[i] = saar2[i].toLowerCase();
            }
        }
        String answer = "";
        return answer;
    }

    public static void main(String[] args) {
        String s = "3people unFollowed me";
        String result = "3people Unfollowed Me";
        if (solution(s).equals(result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}