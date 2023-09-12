package RealTest.Level2;

import java.util.Arrays;
import java.util.Stack;

public class Solution2 {
    public static int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();

        int[] answer = new int[numbers.length];

        stack.push(0);

        for (int i = 1; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {2,3,3,5};
        int[] result = {3,5,5,-1};
        if (Arrays.equals(solution(numbers), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}