package 난이도2.다리를지나는트럭;

import java.util.*;

public class Solution {
    private static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int check_weight = 0;
        Queue<Integer> crossing_truck = new LinkedList<>();
        for (int i : truck_weights) {
            while (true) {
                if (crossing_truck.isEmpty()) {
                    crossing_truck.add(i);
                    check_weight = check_weight + i;
                    answer++;
                    break;
                } else if (crossing_truck.size() == bridge_length) {
                    check_weight = check_weight - crossing_truck.poll();
                } else {
                    if (check_weight + i <= weight) {
                        crossing_truck.add(i);
                        check_weight = check_weight + i;
                        answer++;
                        break;
                    } else {
                        crossing_truck.add(0);
                        answer++;
                    }
                }
            }
        }

        return answer + bridge_length;
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        int result = 8;

//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10};
//        int result = 101;
        if (solution(bridge_length, weight, truck_weights) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}