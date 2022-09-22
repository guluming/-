package 난이도3.코딩테스트공부;

public class Solution {

    static int solution(int alp, int cop, int[][] problems) {
        int target_alp = 0;
        int target_cop = 0;
        for (int i = 0; i < problems.length; i++) {
            target_alp = Math.max(problems[i][0], target_alp);
            target_cop = Math.max(problems[i][1], target_cop);
        }

        if (target_alp <= alp && target_cop <= cop) {
            return 0;
        }

        if (target_alp <= alp) {
            alp = target_alp;
        }
        if (target_cop <= cop) {
            cop = target_cop;
        }

        int[][] dp = new int[target_alp + 2][target_cop + 2];

        for (int i = alp; i <= target_alp; i++) {
            for (int j = cop; j <= target_cop; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[alp][cop] = 0;

        for (int i = alp; i <= target_alp; i++) {
            for (int j = cop; j <= target_cop; j++) {
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);

                for (int[] p :problems) {
                    if(i>=p[0]&&j>=p[1]){
                        if(i+p[2]>target_alp&&j+p[3]>target_cop){
                            dp[target_alp][target_cop]=Math.min(dp[target_alp][target_cop],dp[i][j]+p[4]);
                        }
                        else if(i+p[2]>target_alp){
                            dp[target_alp][j+p[3]]=Math.min(dp[target_alp][j+p[3]],dp[i][j]+p[4]);
                        }
                        else if(j+p[3]>target_cop){
                            dp[i+p[2]][target_cop]=Math.min(dp[i+p[2]][target_cop],dp[i][j]+p[4]);
                        }
                        else if(i+p[2]<=target_alp&&j+p[3]<=target_cop){
                            dp[i+p[2]][j+p[3]]=Math.min(dp[i+p[2]][j+p[3]],dp[i][j]+p[4]);
                        }
                    }
                }
            }
        }
        return dp[target_alp][target_cop];
    }

    public static void main(String[] args) {
        int alp = 10;
        int cop = 10;
        int[][] problems = {{10, 15, 2, 1, 2}, {20, 20, 3, 3, 4}};
        int result = 15;
        if (solution(alp, cop, problems) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}