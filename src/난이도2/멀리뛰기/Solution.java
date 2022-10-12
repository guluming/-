package 난이도2.멀리뛰기;

import java.util.*;

public class Solution {
    public static long solution(int n) {
        int count = 1;
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while (n >= count) {
            if (count == 1) {
                list.add(1);

            } else if (count == 2) {
                list.add(2);

            } else {
                list.add((list.get(i - 1) + list.get(i - 2)) % 1234567);

            }
            count++;
            i++;
        }

        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        int n = 4;
        int result = 5;
        if (solution(4) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}