package 난이도2.타겟넘버;

import java.util.*;

public class Solution {
    static int answer = 0;

    public static int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);

        return answer;
    }

    // 깊이 우선 탐색
    public static void dfs(int[] numbers, int depth, int target, int sum){
        if(depth == numbers.length){ // 마지막 노드 까지 탐색한 경우
            if(target == sum) answer++;
        } else {
            dfs(numbers, depth + 1, target, sum + numbers[depth]); // 해당 노드의 값을 더하고 다음 깊이 탐색
            dfs(numbers, depth + 1, target, sum - numbers[depth]); // 해당 노드의 값을 빼고 다음 깊이 탐색
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        int result = 5;
        if (solution(numbers, target) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}