package 난이도2.하노이의탑;

import java.util.*;

public class Solution {
    static int index = 0;

    public static int[][] solution(int n) {
        int[][] answer = new int[(int) Math.pow(2, n) - 1][2];

        hanoi(n, 1, 3, 2, answer);

        return answer;
    }

    public static void hanoi(int n, int start, int dest, int waypoint, int[][] answer) {
        if (n == 1)
            answer[index++] = new int[]{start, dest};
        else {
            hanoi(n - 1, start, waypoint, dest, answer);
            answer[index++] = new int[]{start, dest};
            hanoi(n - 1, waypoint, dest, start, answer);
        }
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] result = {{1, 2}, {1, 3}, {2, 3}};
        if (Arrays.deepEquals(solution(n), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}