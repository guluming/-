package 난이도2.방금그곡;

import java.util.*;

public class Solution {
    public static String solution(String m, String[] musicinfos) {

        m = melodyCheck(m);
        int min = Integer.MIN_VALUE;
        String answer = "(None)";
        for (String infos : musicinfos) {
            String[] info = infos.split(",");
            int time = (Integer.parseInt(info[1].substring(0, 2)) * 60 + Integer.parseInt(info[1].substring(3, 5))) -
                    (Integer.parseInt(info[0].substring(0, 2)) * 60 + Integer.parseInt(info[0].substring(3, 5)));

            String noteTemp = melodyCheck(info[3]);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < time / noteTemp.length(); i++) {
                sb.append(noteTemp);
            }

            for (int i = 0; i < time % noteTemp.length(); i++) {
                sb.append(noteTemp.charAt(i));
            }

            if (sb.toString().contains(m) && time > min) {
                answer = info[2];
                min = time;
            }
        }


        return answer;
    }

    public static String melodyCheck(String s) { // 뒤에 #이 있다면 lowercase로 바꿔주는 메서드
        StringBuilder note = new StringBuilder(s);
        for (int i = note.length() - 2; i >= 0; i--) {
            if (note.charAt(i + 1) != '#') continue;
            note.deleteCharAt(i + 1);
            note.setCharAt(i, Character.toLowerCase(note.charAt(i)));
        }

        return note.toString();
    }

//    public static List<String> melodyCheck(String melody) {
//        List<String> melodyResult = new ArrayList<>();
//        String[] temp = melody.split("");
//        for (int i = 0; i < temp.length; i++) {
//            if (i == temp.length - 1) {
//                melodyResult.add(temp[i]);
//            } else if (temp[i + 1].equals("#")) {
//                String realMelody = temp[i] + temp[i + 1];
//                melodyResult.add(realMelody);
//                i++;
//            } else {
//                melodyResult.add(temp[i]);
//            }
//        }
//
//        return melodyResult;
//    }
//
//    public static int musicTime(String start, String end) {
//        String[] startHM = start.split(":");
//        String[] endHM = end.split(":");
//
//        int h = Integer.parseInt(endHM[0]) - Integer.parseInt(startHM[0]);
//        int m = Integer.parseInt(endHM[1]) - Integer.parseInt(startHM[1]);
//
//        return h * 60 + m;
//    }
//
//    public static String realRadioMelody(int musicTime, List<String> Melody) {
//        List<String> temp = new ArrayList<>();
//        for (int i = 0; i < musicTime; i++) {
//            if (i < Melody.size() - 1) {
//                temp.add(Melody.get(i));
//            } else {
//                int a = i % Melody.size();
//                temp.add(Melody.get(a));
//            }
//        }
//
//        String result = "";
//        for (String s : temp) {
//            result = result + s;
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String result = "HELLO";
        if (solution(m, musicinfos).equals(result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}