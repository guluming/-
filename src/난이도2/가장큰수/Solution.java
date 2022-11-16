package 난이도2.가장큰수;

import java.util.*;

public class Solution {
    public static String solution(int[] numbers) {
        String[] number = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);

        Arrays.sort(number, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if (number[0].equals("0")) {
            return "0";
        }

        String answer = "";
        for (String s : number) {
            answer = answer + s;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        String result = "6210";
        if (solution(numbers).equals(result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}