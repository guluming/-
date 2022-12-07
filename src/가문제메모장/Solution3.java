package 가문제메모장;

import java.util.*;

public class Solution3 {
    public static int solution(int[] preferences, int[] coffees) {
        Arrays.sort(preferences);
        Arrays.sort(coffees);

        int answer = 0;
        for (int i = 0; i < preferences.length; i++) {
            if (coffees[i] - preferences[i] > 0) {
                answer = answer + (coffees[i] - preferences[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] preferences = {1,2,3,4};
        int[] coffees = {5,3,2,3};
        int result = 3;
        if (solution(preferences, coffees) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}