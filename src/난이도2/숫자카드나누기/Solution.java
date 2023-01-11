package 난이도2.숫자카드나누기;

import java.util.*;

public class Solution {
    public static int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int a = min(arrayA, arrayB);
        int b = min(arrayB, arrayA);

        return Math.max(a, b);
    }

    public static int min(int[] arr1, int[] arr2) {
        List<Integer> divNumber = findDivNumber(arr1[0]);
        divNumber.sort(Collections.reverseOrder());
        int j;
        for (int i = 0; i < divNumber.size() - 1; i++) {
            boolean GCD = false;
            int num = divNumber.get(i);
            for (j = 0; j < arr1.length; j++) {
                if (arr1[j] % num != 0) {
                    break;
                }
            }

            if (j == arr1.length) {
                GCD = true;
            }

            if (GCD) {
                for (j = 0; j < arr2.length; j++) {
                    if (arr2[j] % num == 0) {
                        break;
                    }
                }

                if (j == arr2.length) {
                    return num;
                }
            }
        }

        return 0;
    }

    public static List<Integer> findDivNumber(int number) {
        List<Integer> divNumber = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                divNumber.add(i);
                divNumber.add(number / i);
            }
        }

        return divNumber;
    }

    public static void main(String[] args) {
        int[] arrayA = {10, 20};
        int[] arrayB = {5, 17};
        int result = 10;
        if (solution(arrayA, arrayB) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}