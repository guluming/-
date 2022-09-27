package 가문제메모장;

import java.util.Arrays;

public class Solution2 {

    public static String solution(int k, String[] dic, String chat) {
        StringBuilder answer = new StringBuilder();
        String[] checkChat = chat.split(" ");
        for (int i = 0; i < dic.length; i++) {
            for (int j = 0; j < checkChat.length; j++) {
                if (dic[i].equals(checkChat[j])) {
                    checkChat[j] = checkChat[j].replaceAll(".", "#");
                } else if (dic[i].length() >= checkChat[j].length()) {
                    checkChat[j] = checkChat[j].replaceAll(".", "#");
                }
            }
        }

        System.out.println(Arrays.toString(checkChat));
        for (int i = 0; i < checkChat.length; i++) {
            answer.append(" ").append(checkChat[i]);
        }

        System.out.println(answer);
        return answer.toString();
    }

    public static void main(String[] args) {
        int k = 2;
        String[] dic = {"slang", "badword"};
        String chat = "badword ab.cd bad.ord .word sl.. bad.word";
        String result = "####### ab.cd ####### .word #### bad.word";
        if (solution(k, dic, chat).equals(result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}