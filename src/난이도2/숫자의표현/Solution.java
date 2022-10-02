package 난이도2.숫자의표현;

import java.util.*;

public class Solution {
    public static int solution(int n) {
        int i=1;
        Queue<Integer> list = new LinkedList<>();
        while (n != 0) {
            list.add(i);
            n = n - i;
            i++;
        }


        System.out.println(list);
        int answer = 2;
        return answer;
    }

    public static void main(String[] args) {
        int n = 15;
        int result = 4;
        if (solution(n) == 4) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}