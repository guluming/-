package 난이도1.약수의합;

public class Solution {
    static int solution(int n) {
        int answer = 0;
        for (int i=1; i<=n; i++) {
            if (n%i == 0) {
                answer = answer+i;
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        int n = 12;
        int result = 28;
        if (solution(n) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}
