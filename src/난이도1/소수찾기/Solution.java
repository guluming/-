package 난이도1.소수찾기;

public class Solution {
    static int solution(int n) {
        int answer = 0;
        int[] arr = new int[n+1];

        for (int i=0; i<=n; i++) {
            arr[i]=i;
        }
        arr[1]=0;

        for (int i=2; i<=n; i++) {
            if (arr[i]==0) {
                continue;
            }

            for (int j=i*2; j<=n; j=j+i) {
                arr[j]=0;
            }
        }

        for (int i=0; i<arr.length; i++) {
            if (arr[i]!=0) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 10;
        int result = 4;
        if (solution(n) == result ) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}