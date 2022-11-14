package 난이도2.두개이하로다른비트;

import java.util.*;

public class Solution {
    private static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String check_number = Long.toBinaryString(numbers[i]);
                if (!check_number.contains("0")) {
                    check_number = "10" + check_number.substring(1);
                } else {
                    int last_zero = check_number.lastIndexOf("0");
                    int first_One = check_number.indexOf("1",last_zero);

                    check_number = check_number.substring(0, last_zero) + "10" + check_number.substring(first_One + 1);
                }
                answer[i] = Long.parseLong(check_number, 2);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        long[] numbers = {2, 7, 9};
        long[] result = {3, 11, 10};
        if (Arrays.equals(solution(numbers), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}