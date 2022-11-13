package 난이도2.연속부분수열합의개수;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    private static int solution(int[] elements) {
        int[] Circular = new int[elements.length * 2];

        for (int i = 0; i < elements.length; i++) {
            Circular[i] = Circular[i + elements.length] = elements[i];
        }

        Set<Integer> result = new HashSet<>();
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                result.add(Arrays.stream(Circular, j, j + i).sum());
            }
        }

        System.out.println(Arrays.toString(Circular));
        return result.size();
    }

    public static void main(String[] args) {
        int[] elements = {7, 9, 1, 1, 4};
        int result = 18;
        if (solution(elements) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}