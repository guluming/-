package 난이도2.카펫;

import java.util.*;

public class Solution {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int searhlen = (int) Math.sqrt(yellow);
        int row;
        int col;

        for (row = 1; row <= searhlen; row++) {
            if (yellow%row != 0) {
                continue;
            }
            col = yellow/row;

            if ((row+col)*2+4 == brown) {
                answer[0] = Math.max(col, row)+2;
                answer[1] = Math.min(col, row)+2;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int brown = 14;
        int yellow = 4;
        int[] result = {6, 3};
        if (Arrays.equals(solution(brown, yellow), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}