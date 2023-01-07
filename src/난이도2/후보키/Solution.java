package 난이도2.후보키;

import java.util.*;

public class Solution {
    static List<String> subKey = new ArrayList<>();

    public static int solution(String[][] relation) {
        for (int i=0; i<relation[0].length; i++) {
            boolean[] visited = new boolean[relation[0].length];
            dfs(visited, 0, 0, i+1, relation);
        }

        return subKey.size();
    }

    public static void dfs(boolean[] visited, int start, int depth, int end, String[][] relation) {
        if (depth == end) {
            List<Integer> list = new ArrayList<>();
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    key.append(String.valueOf(i));
                    list.add(i);
                }
            }

            Map<String, Integer> map = new HashMap<>();

            for (String[] strings : relation) {
                StringBuilder s = new StringBuilder();
                for (Integer j : list) {
                    s.append(strings[j]);
                }

                if (map.containsKey(s.toString())) {
                    return;
                } else {
                    map.put(s.toString(), 0);
                }
            }

            for (String s : subKey) {
                int count = 0;
                for(int i = 0; i < key.length(); i++){
                    String subS = String.valueOf(key.charAt(i));
                    if(s.contains(subS)) count++;
                }
                if (count == s.length()) return;
            }
            subKey.add(key.toString());

            return;
        }

        for (int i = start; i < visited.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(visited, i, depth + 1, end, relation);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},
                {"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        int result = 2;
        if (solution(relation) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}