package 가문제메모장;

import java.util.*;

public class Solution {
    public static int[] parent = new int[2501];
    public static String[] value = new String[2501];

    //UNION-FIND 알고리즘
    public static int find(int a) {
        if (parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parent[b] = a;
    }

    //좌표를 번호로 변환
    public static int convertNum(int x, int y) {
        int result = 50 * (x - 1);
        return result + y;
    }

    public static String[] solution(String[] commands) {
        //초기화
        for (int i = 1; i <= 2500; i++) {
            parent[i] = i;
            value[i] = "";
        }

        //명령어 실행
        List<String> result = new ArrayList<>();
        for (int ind = 0; ind < commands.length; ind++) {
            String line = commands[ind];
            StringTokenizer st = new StringTokenizer(line);
            String command = st.nextToken();

            if ("UPDATE".equals(command)) {
                //UPDATE value1 value2
                if (st.countTokens() == 2) {
                    String before = st.nextToken();
                    String after = st.nextToken();
                    for (int i = 1; i <= 2500; i++) {
                        if (before.equals(value[i]))
                            value[i] = after;
                    }
                }
                //UPDATE x y value
                else {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    String after = st.nextToken();
                    int num = convertNum(x, y);
                    value[find(num)] = after;
                }
            } else if ("MERGE".equals(command)) {
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                int n1 = convertNum(x1, y1);
                int n2 = convertNum(x2, y2);
                int root1 = find(n1);
                int root2 = find(n2);
                //0. 같은 그룹이면 무시
                if (root1 == root2) continue;
                //1. 값을 가진쪽으로 병합
                String rootString = value[root1].isBlank() ? value[root2] : value[root1];
                value[root1] = "";
                value[root2] = "";
                union(root1, root2);
                value[root1] = rootString;
            } else if ("UNMERGE".equals(command)) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int num = convertNum(x, y);
                int root = find(num);
                String rootString = value[root];
                value[root] = "";
                value[num] = rootString;
                List<Integer> deleteList = new ArrayList<>();
                for (int i = 1; i <= 2500; i++) {
                    if (find(i) == root)
                        deleteList.add(i);
                }
                for (Integer t : deleteList)
                    parent[t] = t;
            } else if ("PRINT".equals(command)) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int num = convertNum(x, y);
                int root = find(num);
                if (value[root].isBlank())
                    result.add("EMPTY");
                else
                    result.add(value[root]);
            }
        }
        return result.toArray(new String[0]);
    }

//    public static HashMap<Integer, String> map1 = new HashMap<>();
//    public static List<List<Integer>> MergeList = new ArrayList<>();
//    public static List<String> PrintList = new ArrayList<>();
//
//    public static String[] solution(String[] commands) {
//        for (int i = 0; i < commands.length; i++) {
//            if (commands[i].substring(0, 3).equals("UPD")) {
//                try{
//                    int temp = Integer.parseInt(commands[i].substring(7, 8));
//                    //삽입
//                    Create(commands[i]);
//                } catch (Exception e) {
//                    //변경
//                    Update(commands[i]);
//                }
//            } else if (commands[i].substring(0, 3).equals("MER")) {
//                //병합
//                Merge(commands[i]);
//            } else if (commands[i].substring(0, 3).equals("UNM")) {
//                //병합해제
//                UnMerge(commands[i]);
//            } else {
//                //출력
//                Print(commands[i]);
//            }
//        }
//
//        String[] answer = new String[PrintList.size()];
//        for (int i = 0; i < PrintList.size(); i++) {
//            answer[i] = PrintList.get(i);
//        }
//
//        System.out.println(map1);
//
//        return answer;
//    }
//
//    public static void Create(String command) {
//        command = command.replaceAll(" ", "");;
//        int key = Integer.parseInt(command.substring(6, 8));
//        String value = command.substring(8, command.length());
//        map1.put(key, value);
//    }
//
//    public static void Update(String command) {
//        String[] temp = command.split(" ");
//
//        for (Integer key: map1.keySet()) {
//            if (map1.get(key) == null) {
//                map1.put(key, temp[2]);
//            } else if (map1.get(key).equals(temp[1])) {
//                map1.put(key, temp[2]);
//            }
//        }
//    }
//
//    public static void Merge(String command) {
//        command = command.replaceAll(" ", "");;
//        String keys = command.substring(5, command.length());
//
//        List<Integer> MergeKeyList = new ArrayList<>();
//        for (int i = 0; i < keys.length(); i = i+2) {
//            int key = Integer.parseInt(keys.substring(i, i + 2));
//            MergeKeyList.add(key);
//        }
//
//        String temp = "";
//        for (int i = 0; i < MergeKeyList.size(); i++) {
//            if (map1.get(MergeKeyList.get(i)) != null) {
//                temp = map1.get(MergeKeyList.get(i));
//            }
//        }
//
//        for (int i = 0; i < MergeKeyList.size(); i++) {
//            map1.put(MergeKeyList.get(i), temp);
//        }
//
//        MergeList.add(MergeKeyList);
//    }
//
//    public static void UnMerge(String command) {
//        command = command.replaceAll(" ", "");;
//        int key = Integer.parseInt(command.substring(7, 9));
//        String temp = map1.get(key);
//
//        List<Integer> UnMergeList = new ArrayList<>();
//        boolean FoundCheck = true;
//        for (int i = 0; i < MergeList.size(); i++) {
//            if (FoundCheck) {
//                for (int k = 0; k < MergeList.get(i).size(); k++) {
//                    if (MergeList.get(i).contains(key)) {
//                        UnMergeList = MergeList.get(i);
//                        FoundCheck = false;
//                        break;
//                    }
//                }
//            } else {
//                break;
//            }
//        }
//
//        if (UnMergeList != null) {
//            for (int i = 0; i < UnMergeList.size(); i++) {
//                if (UnMergeList.get(i) != key) {
//                    map1.put(UnMergeList.get(i), "");
//                }
//            }
//        }
//    }
//
//    public static void Print(String command) {
//        command = command.replaceAll(" ", "");;
//        int key = Integer.parseInt(command.substring(5, 7));
//        if (map1.get(key) == null || map1.get(key).equals("")) {
//            PrintList.add("EMPTY");
//        } else {
//            PrintList.add(map1.get(key));
//        }
//    }

    public static void main(String[] args) {
        String[] commands = {
                "UPDATE 1 1 menu",
                "UPDATE 1 2 category",
                "UPDATE 2 1 bibimbap",
                "UPDATE 2 2 korean",
                "UPDATE 2 3 rice",
                "UPDATE 3 1 ramyeon",
                "UPDATE 3 2 korean",
                "UPDATE 3 3 noodle",
                "UPDATE 3 4 instant",
                "UPDATE 4 1 pasta",
                "UPDATE 4 2 italian",
                "UPDATE 4 3 noodle",
                "MERGE 1 2 1 3",
                "MERGE 1 3 1 4",
                "UPDATE korean hansik",
                "UPDATE 1 3 group",
                "UNMERGE 1 4",
                "PRINT 1 3",
                "PRINT 1 4"};
        String[] result = {"EMPTY", "group"};

        if (Arrays.equals(solution(commands), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}