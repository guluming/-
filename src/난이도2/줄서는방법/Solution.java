package 난이도2.줄서는방법;

import java.util.*;

public class Solution {
    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();

        long f = 1;
        for(int i=1; i<=n; i++) {
            list.add(i);
            f *= i;
        }

        k--;
        int idx = 0;
        while(idx < n) {
            f /= n - idx;
            answer[idx++] = list.remove((int) (k / f));
            k %= f;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        long k = 5;
        int[] result = {3,1,2};
        if (Arrays.equals(solution(n, k), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}