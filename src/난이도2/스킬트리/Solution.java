package 난이도2.스킬트리;

import java.util.*;

public class Solution {
    private static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {
            String temp = skill_tree;

            for (int i = 0; i < skill_tree.length(); i++) {
                String user_skill = skill_tree.substring(i, i + 1);
                if (!skill.contains(user_skill)) {
                    temp = temp.replace(user_skill, "");
                }
            }

            if (skill.indexOf(temp) == 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        int result = 2;
        if (solution(skill, skill_trees) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}