package 난이도1.폰켓몬;

import java.util.HashSet;

public class Solution {
    static int solution(int[] nums) {
        int total = nums.length/2;
        int answer = 0;

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            hashSet.add(nums[i]);
        }

        if (total < hashSet.size()) {
            answer = total;
        } else {
            answer = hashSet.size();
        }

        System.out.println(total);
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        int result = 2;
        if (solution(nums) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}