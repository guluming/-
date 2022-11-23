package 난이도2.소수찾기;

import java.util.*;

public class Solution {
    public static int solution(String numbers) {
        HashSet<Integer> result = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        String[] numberArr = numbers.split("");

        dfs("", 0, numberArr, visited, result);

        return result.size();
    }

    public static void dfs(String str, int index, String[] numberArr, boolean[] visited, HashSet<Integer> result) {
        int number;
        if (!str.equals("")) {
            number = Integer.parseInt(str);
            if (isPrime(number)) {
                result.add(number);
            }
        }

        if (index == numberArr.length) {
            return;
        }

        for (int i = 0; i < numberArr.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(str + numberArr[i], index + 1, numberArr, visited, result);
            visited[i] = false;
        }
    }

    public static boolean isPrime(int number) {
        if (number == 0 || number == 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String numbers = "17";
        int result = 3;
        if (solution(numbers) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}