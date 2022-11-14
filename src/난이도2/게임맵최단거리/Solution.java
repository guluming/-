package 난이도2.게임맵최단거리;

import java.util.*;

public class Solution {
    private static int solution(int[][] maps) {
        int[][] visited_maps = new int[maps.length][maps[0].length];

        bfs(maps, visited_maps);
        int answer = visited_maps[maps.length - 1][maps[0].length - 1];

        if (answer == 0) {
            return -1;
        } else {
            return answer;
        }
    }

    public static void bfs(int[][] maps, int[][] visited_maps) {
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        visited_maps[0][0] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] way = queue.remove();
            int sx = way[0];
            int sy = way[1];

            for (int i = 0; i < 4; i++) {
                int nx = sx + move[i][0];
                int ny = sy + move[i][1];

                if (nx < 0 || nx > maps.length - 1 || ny < 0 || ny > maps[0].length - 1) {
                    continue;
                }

                if (visited_maps[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited_maps[nx][ny] = visited_maps[sx][sy] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
//        int result = 11;

        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
        int result = -1;
        if (solution(maps) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}