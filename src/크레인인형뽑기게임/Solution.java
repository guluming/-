package 크레인인형뽑기게임;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    static int solution(int[][] board, int[] moves) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> resultStack = new Stack<>();
        int a = 0;
        int answer = 0;

        for (int i=0; i< moves.length; i++) {
            for (int j=0; j< board.length; j++) {
                if (board[j][moves[i]-1] != 0) {
                    resultStack.push(board[j][moves[i]-1]);

                    if (a == resultStack.peek() && !resultStack.empty()) {
                        resultStack.pop();
                        resultStack.pop();
                        answer = answer + 2;
                    }

                    if (!resultStack.empty()) {
                        a = resultStack.peek();
                    } else {
                        a = 0;
                    }

                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }

        System.out.println(resultStack);

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int result = 4;
        if (solution(board, moves) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}