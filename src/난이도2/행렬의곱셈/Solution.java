package 난이도2.행렬의곱셈;

import java.util.*;

public class Solution {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < arr2.length; k++) {
                    sum = sum + arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1, 2}, {3, 4}};
        int[][] arr2 = {{1, 2}, {3, 4}};
        int[][] result = {{7, 10}, {15, 22}};
        if (Arrays.deepEquals(solution(arr1, arr2), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}