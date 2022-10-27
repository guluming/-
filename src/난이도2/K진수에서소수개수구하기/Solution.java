package 난이도2.K진수에서소수개수구하기;

import java.util.*;

public class Solution {
    public static int solution(int n, int k) {
        int answer = 0, i, j;
        String s = change_number(n,k);
        for(i = 0; i < s.length(); i = j) {
            for(j = i + 1; j < s.length() && s.charAt(j) != '0'; j++);
            if(isprime(Long.parseLong(s.substring(i,j))))
                answer++;
        }
        return answer;
    }
    public static boolean isprime(long n){
        if(n <= 1) return false;
        else if(n == 2) return true;
        for(int i = 2; i <= Math.sqrt(n); i++)
            if(n % i == 0)
                return false;
        return true;
    }
    public static String change_number(int n, int k) {
        String res = "";
        while(n > 0) {
            res = n % k + res;
            n /= k;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 110011;
        int k = 10;
        int result = 2;
        if (solution(n, k) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}