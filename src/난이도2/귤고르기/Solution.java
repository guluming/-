package 난이도2.귤고르기;

import java.util.*;

public class Solution {
    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> checkTangerine = new HashMap<>();

        for (int i : tangerine) {
            checkTangerine.put(i, checkTangerine.getOrDefault(i, 0) + 1);
        }

        List<Integer> tangerineList = new ArrayList<>(checkTangerine.keySet());
        tangerineList.sort((o1, o2) -> checkTangerine.get(o2) - checkTangerine.get(o1));

        for (Integer i : tangerineList) {
            k = k - checkTangerine.get(i);
            answer++;
            if (k <= 0) {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int result = 3;
        if (solution(k, tangerine) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}