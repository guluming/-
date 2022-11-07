package 난이도2.프렌즈4블록;

import java.util.*;

public class Solution {
    static boolean check_block[][];

    private static int solution(int m, int n, String[] board) {
        int answer = 0;

        char board_copy[][] = new char[m][n];
        for (int i = 0; i < m; i++) {
            board_copy[i] = board[i].toCharArray();
        }

        boolean flag = true;
        while (flag) {
            check_block = new boolean[m][n];
            flag = false;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (board_copy[i][j] == '0') {
                        continue;
                    }

                    if (check(i, j, board_copy)) {
                        check_block[i][j] = true;
                        check_block[i][j + 1] = true;
                        check_block[i + 1][j] = true;
                        check_block[i + 1][j + 1] = true;
                        flag = true;
                    }
                }
            }
            answer = answer + delete(m, n, board_copy);
            check_block = new boolean[m][n];
        }

        return answer;
    }

    public static boolean check(int i, int j, char[][] board_copy) {
        char ch = board_copy[i][j];
        if (ch == board_copy[i][j + 1] && ch == board_copy[i + 1][j] && ch == board_copy[i + 1][j + 1]) {
            return true;
        }

        return false;
    }

    public static int delete(int m, int n, char[][] board_copy) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check_block[i][j]) {
                    board_copy[i][j] = '@';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Queue<Character> q = new LinkedList<>();
            for (int j = m - 1; j >= 0; j--) {
                if (board_copy[j][i] == '@') {
                    count++;
                } else {
                    q.add(board_copy[j][i]);
                }
            }

            int index = m - 1;
            while (!q.isEmpty()) {
                board_copy[index--][i] = q.poll();
            }

            for (int j = index; j >= 0; j--) {
                board_copy[j][i] = '0';
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        int result = 14;
        if (solution(m, n, board) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}