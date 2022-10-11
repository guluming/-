package 난이도2.N개의최소공배수;

import java.util.*;

public class Solution {
    public static int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int max = Max(answer, arr[i]);
            answer = answer * arr[i] / max;
        }
        return answer;
    }

    public static int Max(int answer, int arr) {
        int a = Math.max(answer, arr);
        int b = Math.min(answer, arr);

        while (a % b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }

        return b;
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};
        int result = 168;
        if (solution(arr) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}