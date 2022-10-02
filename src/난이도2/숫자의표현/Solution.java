package 난이도2.숫자의표현;

import java.util.*;

public class Solution {
    public static int solution(int n) {
        int answer = 0;
        for (int i=1; i<=n; i++) {
            int sum=0;
            for (int j=i; j<=n; j++) {
                sum = sum + j;
                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }
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