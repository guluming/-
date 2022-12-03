package 난이도2.삼각달팽이;

import java.util.*;

public class Solution {
    public static int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] triangle = new int[n][n];

        int x = -1;
        int y = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else {
                    x--;
                    y--;
                }

                triangle[x][y] = num;
                num++;
            }
        }

        int triangleNumber = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (triangle[i][j] == 0) {
                    break;
                }
                answer[triangleNumber] = triangle[i][j];
                triangleNumber++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] result = {1,2,9,3,10,8,4,5,6,7};
        if (Arrays.equals(solution(n), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}