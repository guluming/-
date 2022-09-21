package 난이도2.전력망을둘로나누기;

import java.util.*;

public class Solution {
    static int[][] map;

    public static int solution(int n, int[][] wires) {
        int answer = n;

        map = new int[n + 1][n + 1];

        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            map[a][b] = 1;
            map[b][a] = 1;

        }
        System.out.println(Arrays.deepToString(map));

        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            map[a][b] = 0;
            map[b][a] = 0;

            answer = Math.min(answer, bfs(n, i + 1));

            map[a][b] = 1;
            map[b][a] = 1;
        }

        return answer;
    }

    private static int bfs(int n, int start) {
        int cnt = 1;
        Queue<Integer> que = new LinkedList<>();
        boolean[] check = new boolean[n + 1];
        que.add(start);
        check[start] = true;
        while (!que.isEmpty()) {
            int now = que.poll();
            for (int i = 1; i <= n; i++) {
                if (map[now][i] == 1 && !check[i]) {
                    que.add(i);
                    check[i] = true;
                    cnt++;
                }
            }
        }

        return (int) Math.abs(n - 2 * cnt);
    }

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int result = 3;
        if (solution(n, wires) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}