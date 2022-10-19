package 난이도2.기능개발;

import java.util.*;

public class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> work_day_list = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int work_day = 0;
            if ((100 - progresses[i]) % speeds[i] != 0) {
                work_day = (100 - progresses[i]) / speeds[i] + 1;
            } else {
                work_day = (100 - progresses[i]) / speeds[i];
            }
            work_day_list.add(work_day);
        }

        List<Integer> result = new ArrayList<>();
        int completion = work_day_list.peek();
        work_day_list.remove();
        int completion_day = 1;
        while (true) {
            if (work_day_list.isEmpty()) {
                result.add(completion_day);
                break;
            } else if (completion >= work_day_list.peek()) {
                completion_day++;
                work_day_list.remove();
            } else if (completion < work_day_list.peek()) {
                result.add(completion_day);
                completion_day = 1;
                completion = work_day_list.peek();
                work_day_list.remove();
            }
        }

        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] result = {2, 1};
        if (Arrays.equals(solution(progresses, speeds), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}