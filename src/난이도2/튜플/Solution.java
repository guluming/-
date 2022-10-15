package 난이도2.튜플;

import java.util.*;
import java.util.stream.Stream;

public class Solution {
    public static ArrayList<Integer> solution(String s) {
        String[] nums = s.split("},");
        for (int i = 0; i < nums.length; i++) {
            String ss = nums[i].replace("{", "").replace("}", "");
            nums[i] = ss;
        }
        // sort array by string size of each element
        Arrays.sort(nums, (a, b) -> Integer.compare(a.length(), b.length()));
        HashSet<Integer> dupCheck = new HashSet<Integer>();
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int[] elem = Stream.of(nums[i].split(",")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < elem.length; j++) {
                if (!dupCheck.contains(elem[j]))
                    answer.add(elem[j]);
                dupCheck.add(elem[j]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        ArrayList<Integer> result = new ArrayList<>();
        result.add(3);
        result.add(2);
        result.add(4);
        result.add(1);
        if (solution(s).equals(result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}