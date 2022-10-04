package 난이도2.피보나치수;

import java.util.*;

public class Solution {
    public static int solution(int n) {
        int count = 0;
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while (n >= count) {
            if (count == 0) {
                list.add(0);
                count++;
                i++;
            } else if (count == 1) {
                list.add(1);
                count++;
                i++;
            } else {
                list.add((list.get(i - 1) + list.get(i - 2)) % 1234567);
                count++;
                i++;
            }
        }

        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        int n = 3;
        int result = 2;
        if (solution(n) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}