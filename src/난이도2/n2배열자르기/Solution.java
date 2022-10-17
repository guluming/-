package 난이도2.n2배열자르기;

import java.util.*;

public class Solution {
    public static int[] solution(int n, long left, long right) {
        List<Long> result = new ArrayList<>();
        for (long i = left; i < right + 1; i++) {
            result.add(Math.max(i / n, i % n) + 1);
        }
        int[] answer = new int[(int) (right - left) + 1];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).intValue();
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        long left = 2;
        long right = 5;
        int[] result = {3, 2, 2, 3};
        if (Arrays.equals(solution(n, left, right), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}