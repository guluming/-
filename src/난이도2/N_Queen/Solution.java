package 난이도2.N_Queen;

import java.util.*;

public class Solution {
    static int answer = 0;

    public static int solution(int n) {
        int[] map = new int[n];
        Backtrack(n, 0, map);
        return answer;
    }

    public static void Backtrack(int n, int rowIndex, int[] map) {
        if (n == rowIndex) {
            answer++;
        } else {
            for (int i = 0; i < n; i++) {
                map[rowIndex] = i;
                if (check(map, rowIndex)) Backtrack(n, rowIndex + 1, map);
            }
        }
    }

    public static boolean check(int[] map, int rowIndex) {
        for (int i = 0; i < rowIndex; i++) {
            if (map[i] == map[rowIndex]) return false;
            if (Math.abs(map[i] - map[rowIndex]) == Math.abs(i - rowIndex)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        int result = 2;
        if (solution(n) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}