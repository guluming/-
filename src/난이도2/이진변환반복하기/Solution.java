package 난이도2.이진변환반복하기;

import java.util.*;

public class Solution {
    public static int[] solution(String s) {
        int zero_count = 0;
        int change_count = 0;
        while (!s.equals("1")) {
            zero_count = zero_count + s.length() - s.replace("0", "").length();
            s = Integer.toBinaryString(s.replace("0", "").length());
            change_count++;
        }
        return new int[]{change_count, zero_count};
    }

    public static void main(String[] args) {
        String s = "110010101001";
        int[] result = {3, 8};
        if (Arrays.equals(solution(s), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}