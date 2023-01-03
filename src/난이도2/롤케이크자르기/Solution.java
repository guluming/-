package 난이도2.롤케이크자르기;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public static int solution(int[] topping) {
        int answer = 0;
        int size = topping.length;

        HashSet<Integer> first = new HashSet<>();
        HashMap<Integer, Integer> second = new HashMap<>();

        first.add(topping[0]);
        for (int i = 1;i < size; i++) {
            second.put(topping[i], second.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = 1;i < size; i++) {
            first.add(topping[i]);
            second.put(topping[i], second.get(topping[i]) - 1);
            if (second.get(topping[i]) == 0) {
                second.remove(topping[i]);
            }
            if (first.size() == second.size()) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        int result = 2;
        if (solution(topping) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}