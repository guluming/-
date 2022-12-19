package 난이도2.행렬테두리회전하기;

import java.util.*;

public class Solution {
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = i * columns + j + 1;
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(arr, queries[i]);
        }

        return answer;
    }

    public static int rotate(int[][] arr, int[] query) {
        int r1 = query[0] - 1;
        int c1 = query[1] - 1;
        int r2 = query[2] - 1;
        int c2 = query[3] - 1;

        int temp = arr[r1][c1];
        int min = temp;
        for (int i = r1; i < r2; i++) {
            arr[i][c1] = arr[i + 1][c1];
            if (min > arr[i][c1]) {
                min = arr[i][c1];
            }
        }

        for (int i = c1; i < c2; i++) {
            arr[r2][i] = arr[r2][i + 1];
            if (min > arr[r2][i]) {
                min = arr[r2][i];
            }
        }

        for (int i = r2; i > r1; i--) {
            arr[i][c2] = arr[i - 1][c2];
            if (min > arr[i][c2]) {
                min = arr[i][c2];
            }
        }

        for (int i = c2; i > c1; i--) {
            arr[r1][i] = arr[r1][i - 1];
            if (min > arr[r1][i]) {
                min = arr[r1][i];
            }
        }

        arr[r1][c1 + 1] = temp;

        return min;
    }

//    public static int rotate(int[][] arr, int[] query) {
//        int result = 0;
//        Deque<Integer> temp = new ArrayDeque<>();
//        int tempLen = (query[2] - query[0] + 1) * 2 + (query[3] - query[1] + 1) * 2 - 4;
//        for (int i = 0; i < tempLen; i++) {
//            temp.add(arr[query[0]][query[1]]);
//        }
//        return result;
//    }

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[] result = {8, 10, 25};
        if (Arrays.equals(solution(rows, columns, queries), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}