package 난이도2.방문길이;

import java.util.*;

public class Solution {
    private static int solution(String dirs) {
        int x = 0;
        int y = 0;
        List<String> xy_point_list = new ArrayList<>();

        for (int i = 0; i < dirs.length(); i++) {
            int next_x = x;
            int next_y = y;

            char point = dirs.charAt(i);
            if (point == 'U') {
                y = y + 1;
                if (y == 6) {
                    y = 5;
                }

            } else if (point == 'D') {
                y = y - 1;
                if (y == -6) {
                    y = -5;
                }

            } else if (point == 'R') {
                x = x + 1;
                if (x == 6) {
                    x = 5;
                }

            } else if (point == 'L') {
                x = x - 1;
                if (x == -6) {
                    x = -5;
                }
            }

            String xy = Integer.toString(x);
            xy = xy + Integer.toString(y);
            String next_xy = Integer.toString(next_x);
            next_xy = next_xy + Integer.toString(next_y);
            String se = xy + next_xy;
            String es = next_xy + xy;

            if (!xy_point_list.contains(se) && !xy_point_list.contains(es) && !se.equals(es)) {
                xy_point_list.add(se);
                xy_point_list.add(es);
            }
        }

        return xy_point_list.size() / 2;
    }

    public static void main(String[] args) {
        String dirs = "LULLLLLLU";
        int result = 7;
        if (solution(dirs) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}