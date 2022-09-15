package 약수의개수와덧셈;

public class Solution {
    static int solution(int left, int right) {
        int answer = 0;

        for (int i=left; i<=right; i++) {
            int count = 0;

            for (int j=1; j<=i; j++) {
                if (i%j==0) {
                    count++;
                }
            }

            if (count%2==0) {
                answer = answer + i;
            } else {
                answer = answer - i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int left = 13;
        int right = 17;
        int result = 43;
        if (solution(left, right) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}