package 난이도2.방금그곡;

import java.util.*;

public class Solution {
    public static String solution(String m, String[] musicinfos) {
        String[] scale = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
        List<String> scaleList = Arrays.asList(scale);
        List<String> myMelody = melodyCheck(m);

        String changeMyMelody = changeMelody(scaleList, myMelody);

        for (int i = 0; i < musicinfos.length; i++) {
            String[] temp = musicinfos[i].split(",");
            int musicTime = musicTime(temp[0], temp[1]);

            List<String> radioMelody = melodyCheck(temp[3]);
            List<String> realRadioMelody = realRadioMelody(musicTime, radioMelody);

            String changeRealRadioMelody = changeMelody(scaleList, realRadioMelody);

            if (changeRealRadioMelody.contains(changeMyMelody)) {
                return temp[2];
            }
        }

        String answer = "";
        return answer;
    }

    public static List<String> melodyCheck(String melody) {
        List<String> melodyResult = new ArrayList<>();
        String[] temp = melody.split("");
        for (int i = 0; i < temp.length; i++) {
            if (i == temp.length - 1) {
                melodyResult.add(temp[i]);
            } else if (temp[i + 1].equals("#")) {
                String realMelody = temp[i] + temp[i + 1];
                melodyResult.add(realMelody);
                i++;
            } else {
                melodyResult.add(temp[i]);
            }
        }

        return melodyResult;
    }

    public static int musicTime(String start, String end) {
        String[] startHM = start.split(":");
        String[] endHM = end.split(":");

        int h = Integer.parseInt(endHM[0]) - Integer.parseInt(startHM[0]);
        int m = Integer.parseInt(endHM[1]) - Integer.parseInt(startHM[1]);

        return h * 60 + m;
    }

    public static List<String> realRadioMelody(int musicTime, List<String> Melody) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < musicTime; i++) {
            if (i < Melody.size() - 1) {
                temp.add(Melody.get(i));
            } else {
                int a = i % Melody.size();
                temp.add(Melody.get(a));
            }
        }

        return temp;
    }

    public static boolean compareMelody (List<String> myMelody, List<String> realRadioMelody) {
        
        return true;
    }

    public static String changeMelody(List<String> scaleList, List<String> melody) {
        String a = "";
        for (int i = 0; i < melody.size(); i++) {
            int temp = scaleList.indexOf(melody.get(i));

            a = a + temp;
        }

        return a;
    }

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