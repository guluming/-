package 난이도2.구명보트;

import java.util.*;

public class Solution {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int first = 0;
        for (int second = people.length - 1; first <= second; second--) {
            if (people[first] + people[second] <= limit) {
                first++;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] people = {30, 40, 50, 60};
        int limit = 100;
        int result = 2;
        if (solution(people, limit) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}