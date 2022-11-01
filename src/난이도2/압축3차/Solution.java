package 난이도2.압축3차;

import java.util.*;

public class Solution {
    public static int[] solution(String msg) {
        HashMap<String, Integer> Dictionary = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char ch = (char) (65 + i);
            String spell = ch + "";
            Dictionary.put(spell, i + 1);
        }

        List<Integer> result = new ArrayList<>();

        int index = 0;
        while (index < msg.length()) {
            String w = "";
            while (index < msg.length()) {
                if (!Dictionary.containsKey(w + msg.charAt(index))) {
                    break;
                } else {
                    w = w + msg.charAt(index);
                }
                index++;
            }

            result.add(Dictionary.get(w));
            if (index < msg.length()) {
                Dictionary.put(w + msg.charAt(index), Dictionary.size() + 1);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String msg = "KAKAO";
        int[] result = {11, 1, 27, 15};
        if (Arrays.equals(solution(msg), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}