package 난이도2.최솟값만들기;

import java.util.*;

public class Solution {
    public static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer = answer + A[i] * B[B.length - i - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        int result = 29;
        if (solution(A, B) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}