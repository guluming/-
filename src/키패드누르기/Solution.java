package 키패드누르기;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    static String solution(int[] numbers, String hand) {
        String answer = "";
        int leftfig = 10;
        int rightfig = 12;

        for (int i = 0; i < numbers.length; i++) {
            int tmp = numbers[i];
            if (tmp == 1 || tmp == 4 || tmp == 7) {
                answer += "L";
                leftfig = tmp;
            } else if (tmp == 3 || tmp == 6 || tmp == 9) {
                answer += "R";
                rightfig = tmp;
            } else {
                if (tmp == 0) tmp = 11;
                int leftfigdist = Math.abs(tmp - leftfig) / 3 + Math.abs(tmp - leftfig) % 3;
                int righfigtdist = Math.abs(tmp - rightfig) / 3 + Math.abs(tmp - rightfig) % 3;

                if (leftfigdist < righfigtdist) {
                    answer += "L";
                    leftfig = tmp;
                } else if (leftfigdist > righfigtdist) {
                    answer += "R";
                    rightfig = tmp;
                } else {
                    if (hand.equals("left")) {
                        answer += "L";
                        leftfig = tmp;
                    } else {
                        answer += "R";
                        rightfig = tmp;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String result = "LRLLLRLLRRL";
        if (solution(numbers, hand).equals(result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}