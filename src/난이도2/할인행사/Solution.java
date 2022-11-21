package 난이도2.할인행사;

import java.util.*;

public class Solution {
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for (int k = 0; k <= discount.length - 10; k++) {
            List<String> finish_want = new ArrayList<>();
            for (int i = 0; i < want.length; i++) {
                int check = 0;
                int count = 0;
                for (int j = k; j < k + 10; j++) {
                    check = discount[j].indexOf(want[i]);

                    if (check == 0) {
                        count++;
                    }
                }

                if (number[i] == count) {
                    finish_want.add(want[i]);
                }
            }

            if (finish_want.size() == want.length) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int result = 3;
        if (solution(want, number, discount) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}