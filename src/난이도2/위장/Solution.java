package 난이도2.위장;

import java.util.*;

public class Solution {
    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> result = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String clothe = clothes[i][1];
            int temp = 0;
            for (int j = 0; j < clothes.length; j++) {
                if (clothe.equals(clothes[j][1])) {
                    temp++;
                }
            }
            result.put(clothe, temp);
        }

        if (result.size() == 1) {
            return clothes.length;
        }

        for (int key : result.values()) {
            answer = answer * (key + 1);
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int result = 5;
        if (solution(clothes) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}