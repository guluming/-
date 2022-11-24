package 난이도2.쿼드압축후개수세기;

import java.util.*;

public class Solution {
    public static int[] solution(int[][] arr) {
        int arrLen = arr.length;
        int[] answer = new int[2];

        DP(0, 0, arr, arrLen, answer);

        return answer;
    }

    public static void DP(int first_x, int first_y, int[][] arr, int size, int[] answer) {
        if (checkNumber(first_x, first_y, size, arr)) {
            answer[arr[first_x][first_y]]++;
            return;
        }

        DP(first_x, first_y, arr, size / 2, answer);
        DP(first_x + size / 2, first_y, arr, size / 2, answer);
        DP(first_x, first_y + size / 2, arr, size / 2, answer);
        DP(first_x + size / 2, first_y + size / 2, arr, size / 2, answer);
    }

    public static boolean checkNumber(int x, int y, int size, int[][] arr) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[x][y] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        int[] result = {4, 9};
        if (Arrays.equals(solution(arr), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}