package 난이도2.오픈채팅방;

import java.util.*;

public class Solution {
    private static String[] solution(String[] record) {
        List<String> inout_user = new ArrayList<>();
        HashMap<String, String> nickname_user = new HashMap<>();
        for (int i = 0; i < record.length; i++) {
            String[] temp = record[i].split(" ");

            if (temp[0].equals("Enter")) {
                if (!nickname_user.containsKey(temp[1])) {
                    nickname_user.put(temp[1], temp[2]);
                    inout_user.add(temp[1] + "님이 들어왔습니다.");
                } else {
                    if (!temp[2].equals(nickname_user.get(temp[1]))) {
                        nickname_user.replace(temp[1], temp[2]);
                        inout_user.add(temp[1] + "님이 들어왔습니다.");
                    } else {
                        inout_user.add(temp[1] + "님이 들어왔습니다.");
                    }
                }
            } else if (temp[0].equals("Leave")) {
                inout_user.add(temp[1] + "님이 나갔습니다.");
            } else if (temp[0].equals("Change")) {
                nickname_user.replace(temp[1], temp[2]);
            }
        }

        String[] answer = new String[inout_user.size()];
        for (int i = 0; i < answer.length; i++) {
            String user_id = inout_user.get(i).substring(0, inout_user.get(i).indexOf("님"));
            answer[i] = inout_user.get(i).replace(user_id, nickname_user.get(user_id));
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] result = {"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};
        if (Arrays.equals(solution(record), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}