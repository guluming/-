package 난이도2.영어끝말잇기;

import java.util.*;

public class Solution {
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int people = 0;
        int num = 0;

        Stack<String> word = new Stack<>();
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                word.push(words[i]);
                people++;
                num++;
            } else {
                people++;
                if (people == n+1) {
                    people = 1;
                    num++;
                }

                if (word.peek().charAt(word.peek().length() - 1) == words[i].charAt(0)) {
                    if (word.contains(words[i])) {
                        answer[0] = people;
                        answer[1] = num;
                        break;
                    } else {
                        word.push(words[i]);
                    }
                } else {
                    break;
                }
            }
        }

        if (words.length == word.size()) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }

        answer[0] = people;
        answer[1] = num;
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] result = {3, 3};
        if (Arrays.equals(solution(n, words), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}