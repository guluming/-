package 난이도2.멀쩡한사각형;

import java.math.BigInteger;

public class Solution {
    public static long solution(int w, int h) {
        int box = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();

        return ((long) w * (long) h) - ((((long) w / box) + ((long) h / box) - 1) * box);
    }

    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        long result = 80;
        if (solution(w, h) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}