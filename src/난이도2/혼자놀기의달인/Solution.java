package 난이도2.혼자놀기의달인;

import java.util.*;

public class Solution {
    public static int solution(int[] cards) {
        int[] answer = {-1, -1};

        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == -1) {
                continue;
            }

            int boxSize = box(cards, i);
            if (answer[0] < boxSize) {
                answer[1] = answer[0];
                answer[0] = boxSize;
            } else if (answer[1] < boxSize) {
                answer[1] = boxSize;
            }
        }

        if (answer[0] == cards.length) {
            return 0;
        } else {
            return answer[0] * answer[1];
        }
    }

    public static int box(int[] cards, int index) {
        if (cards[index] == -1) {
            return 0;
        }

        int nextIndex = cards[index] - 1;
        cards[index] = -1;

        return box(cards, nextIndex) + 1;
    }

    public static void main(String[] args) {
        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};
        int result = 12;
        if (solution(cards) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}