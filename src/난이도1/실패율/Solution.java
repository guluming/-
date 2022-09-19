package 난이도1.실패율;

import java.util.*;

public class Solution {
    static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> rate = new HashMap<>();
        int total = stages.length;


        for (int i=1; i<=N; i++) {
            int count=0;
            double rating=0.0;

            for (int j=0; j<stages.length; j++) {
                if (i == stages[j]) {
                    count++;
                }
            }

            if (count == 0) {
                rating=0.0;
            } else {
                rating = count/(double)total;
            }

            rate.put(i, rating);
            total = total-count;
        }

        System.out.println(rate);

        List<Integer> list = new ArrayList<>(rate.keySet());
        list.sort((stage, rating) -> rate.get(rating).compareTo(rate.get(stage)));

        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        System.out.println(list);

        return answer;
    }

    public static void main(String[] args) {
//        int N = 5;
//        int[] stages = {2,1,2,6,2,4,3,3};
//        int[] result = {3,4,2,1,5};

        int N = 3;
        int[] stages = {1,1,1};
        int[] result = {1,2,3};
        if (Arrays.equals(solution(N, stages), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}