package 가문제메모장;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Solution9 {
    public static final int MOD = 1000000007;

    public static int solution(int n) {
        long[] dp = new long[n + 1];
        long[] dp4 = new long[n + 1];
        long[] dp5 = new long[n + 1];
        long[] dp6 = new long[n + 1];
        dp[0] = 1;
        //가로 1 -> 1가지
        //가로 2 -> 2가지
        //가로 3 -> 5가지
        //가로 4, 7, 10... -> 2가지
        //가로 5, 8, 11... -> 2가지
        //가로 6, 9, 12... -> 4가지
        for (int i = 1; i <= n; i++) {
            if (i - 1 >= 0) dp[i] = (dp[i] + dp[i - 1]) % MOD;
            if (i - 2 >= 0) dp[i] = (dp[i] + dp[i - 2] * 2) % MOD;
            if (i - 3 >= 0) dp[i] = (dp[i] + dp[i - 3] * 5) % MOD;
            if (i - 4 >= 0) {
                long diff = (dp[i - 4] * 2) % MOD;
                dp4[i] = (dp4[i-3] + diff) % MOD;
                dp[i] = (dp[i] + dp4[i]) % MOD;
            }

            if (i - 5 >= 0) {
                long diff = (dp[i - 5] * 2) % MOD;
                dp5[i] = (dp5[i-3] + diff) % MOD;
                dp[i] = (dp[i] + dp5[i]) % MOD;
            }

            if (i - 6 >= 0) {
                long diff = (dp[i - 6] * 4) % MOD;
                dp6[i] = (dp6[i-3] + diff) % MOD;
                dp[i] = (dp[i] + dp6[i]) % MOD;
            }
        }

        return Math.toIntExact(dp[n]);
    }

    public static void main(String[] args) {
//        int n = 1;
//        int result = 1;
//        int n = 2;
//        int result = 3;
        int n = 3;
        int result = 10;
        if (solution(n) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}