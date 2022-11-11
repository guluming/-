package 난이도2.모음사전;

import java.util.*;

public class Solution {
    private static int solution(String word) {
        String dir_word = "AEIOU";
        int[] word_index = {781, 156, 31, 6, 1};
        int answer = word.length();

        for (int i = 0; i < word.length(); i++) {
            answer = answer + (word_index[i] * dir_word.indexOf(word.charAt(i)));
        }

        return answer;
    }

    public static void main(String[] args) {
        String word = "I";
        int result = 1563;
        if (solution(word) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}