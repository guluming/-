package 가문제메모장;

import java.util.Arrays;

public class Solution2 {

    public static String solution(int k, String[] dic, String chat) {
        StringBuilder answer = new StringBuilder();
        String[] checkChat = chat.split(" ");
        for (int i = 0; i < checkChat.length; i++) {
            for (int j = 0; j < dic.length; j++) {
                if (checkChat[i].equals(dic[j])) {
                    checkChat[i] = checkChat[i].replaceAll(".", "#");
                } else if (checkChat[i].contains(".")) {

                }
            }
        }

        System.out.println(Arrays.toString(checkChat));

        System.out.println(answer);
        return answer.toString();
    }

    public static int countChar(String str, char ch) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }

        return count;
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