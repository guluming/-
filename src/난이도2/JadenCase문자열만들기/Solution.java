package 난이도2.JadenCase문자열만들기;

import java.util.*;

public class Solution {
    public static String solution(String s) {
        String answer = "";
        String[] saar1 = s.split("");

        for (int i=0; i< saar1.length; i++) {
            if (i==0 && !saar1[i].matches("\\d")) {
                saar1[i] = saar1[i].toUpperCase();
            }

            if (i!=0) {
                if (saar1[i-1].equals(" ")) {
                    saar1[i] = saar1[i].toUpperCase();
                } else {
                    saar1[i] = saar1[i].toLowerCase();
                }
            }

            answer = answer + saar1[i];
        }
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