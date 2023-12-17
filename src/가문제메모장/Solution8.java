package 가문제메모장;

public class Solution8 {
    public static int solution(int n, int m, int[] section) {
        int start = section[0];
        int end = section[0] + (m-1);
        int ans = 1;

        for(int i : section){
            if(i>=start && i<=end) {
                continue;
            }
            else{
                start = i;
                end = i + (m-1);
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 8;
        int m = 4;
        int[] section = {2,3,6};
        int result = 2;
        if (solution(n, m, section) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}