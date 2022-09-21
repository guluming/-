package 난이도2.피로도;

import java.util.*;

public class Solution {
    static int answer=0;
    static boolean[] visit;

    public static int solution(int k, int[][] dungeons) {
        visit=new boolean[dungeons.length];
        dfs(0,k,dungeons);
        return answer;
    }

    public static void dfs(int depth, int k, int[][] dungeons){
        for (int i=0; i<dungeons.length; i++) {
            if(!visit[i] && dungeons[i][0] <= k){
                visit[i] = true;
                dfs(depth+1, k-dungeons[i][1], dungeons);
                visit[i] = false;
            }
        }

        answer = Math.max(answer, depth);
    }

    public static void main(String[] args) {
        int k=80;
        int[][] dungeons={{80,20},{50,40},{30,10}};
        int result = 3;
        if (solution(k, dungeons) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}