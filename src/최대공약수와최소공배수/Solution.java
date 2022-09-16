package 최대공약수와최소공배수;

import java.util.Arrays;

public class Solution {
    static int[] solution(int n, int m) {
        int[] answer = {0,0};

        for (int i=1; i<=n && i<=m; i++) {
            if(n%i==0 && m%i==0) {
                answer[0] = i;
            }
        }

        answer[1]=(n*m)/answer[0];

        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 12;
        int[] result = {3,12};
        if (Arrays.equals(solution(n,m), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}