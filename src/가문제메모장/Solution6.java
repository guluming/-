package 가문제메모장;

import java.util.Arrays;

public class Solution6 {
    public static int solution(String s) {
        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int findstr = 0;
        String str = "";

        for (int i = 0; i < number.length; i++) {
            findstr = i;
            str = Integer.toString(findstr);

            s = s.replace(number[i],str);
        }

        int answer = Integer.parseInt(s);
        return answer;
    }

    public static void main(String[] args) {
        String s = "one4seveneight";
        int result = 1478;
        if (solution(s) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}