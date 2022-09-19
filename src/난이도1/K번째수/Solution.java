package 난이도1.K번째수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int [commands.length];

        for (int i=0; i<commands.length; i++) {
            int number = 0;
            List<Integer> list = new ArrayList<>();

            for (int j = (commands[i][0])-1; j<=(commands[i][1])-1; j++) {
                list.add(array[j]);
            }

            Collections.sort(list);
            number = list.get((commands[i][2])-1);

            answer[i] = number;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        int[] result = {5,6,3};
        if (Arrays.equals(solution(array,commands), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}