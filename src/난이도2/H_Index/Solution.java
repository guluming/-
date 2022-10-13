package 난이도2.H_Index;

import java.util.*;

public class Solution {
    public static int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        int h = 0;
        for (int i = 0; i <= citations[citations.length - 1]; i++) {
            int high_count = 0;
            for (int j = 0; j < citations.length; j++) {
                if (i <= citations[j]) {
                    high_count++;
                }
            }
            if (i <= high_count) {
                h = i;
            }
            answer = Math.max(answer, h);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] citations = {0,1,1};
        int result = 1;
        if (solution(citations) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}