package 난이도2.다음큰숫자;

import java.util.*;

public class Solution {
    public static int solution(int n) {
        String bn = Integer.toBinaryString(n);
        char[] bn_aar = bn.toCharArray();
        int one_count = 0;
        int s_one_count = 0;

        for (int i=0; i<bn_aar.length; i++) {
            if (bn_aar[i] == '1') {
                one_count++;
            }
        }

        while (one_count != s_one_count) {
            int result = 0;
            n = n+1;
            String sbn = Integer.toBinaryString(n);
            char[] sbn_aar = sbn.toCharArray();

            for (int i=0; i<sbn_aar.length; i++) {
                if (sbn_aar[i] == '1') {
                    result++;
                }
            }
            s_one_count = result;
        }

        return n;
    }

    public static void main(String[] args) {
        int n = 78;
        int result =83;
        if (solution(n) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}