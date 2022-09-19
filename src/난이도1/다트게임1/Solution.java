package 난이도1.다트게임1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int solution(String dartResult) {
        String[] dartResultList = new String[dartResult.length()];
        dartResultList = dartResult.split("");

        List<String> numberList = new ArrayList<>();
        for (int i = 0; i < dartResultList.length; i++) {
            try {
                if (Integer.parseInt(dartResultList[i]) == 1 && Integer.parseInt(dartResultList[i + 1]) == 0) {
                    numberList.add(dartResultList[i] + dartResultList[i + 1]);
                    i++;
                } else {
                    numberList.add(dartResultList[i]);
                }
            } catch (Exception e) {
                numberList.add(dartResultList[i]);
                continue;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < numberList.size(); i++) {
            if (numberList.get(i).equals("S") && i == 1) {
                result.add(Integer.parseInt(numberList.get(0)));
                continue;
            } else if (numberList.get(i).equals("D") && i == 1) {
                result.add(Integer.parseInt(numberList.get(0)) * Integer.parseInt(numberList.get(0)));
                continue;
            } else if (numberList.get(i).equals("T") && i == 1) {
                result.add(Integer.parseInt(numberList.get(0)) * Integer.parseInt(numberList.get(0)) * Integer.parseInt(numberList.get(0)));
                continue;
            } else if (numberList.get(i).equals("*") && i == 2) {
                result.set(0, 2 * result.get(0));
                continue;
            } else if (numberList.get(i).equals("#") && i == 2) {
                result.set(0, (-1) * result.get(0));
                continue;
            } else if (numberList.get(i).equals("S")) {
                result.add(Integer.parseInt(numberList.get(i - 1)));
                continue;
            } else if (numberList.get(i).equals("D")) {
                result.add(Integer.parseInt(numberList.get(i - 1)) * Integer.parseInt(numberList.get(i - 1)));
                continue;
            } else if (numberList.get(i).equals("T")) {
                result.add(Integer.parseInt(numberList.get(i - 1)) * Integer.parseInt(numberList.get(i - 1)) * Integer.parseInt(numberList.get(i - 1)));
                continue;
            } else if (numberList.get(i).equals("*")) {
                result.set(result.size() - 2, 2 * result.get(result.size() - 2));
                result.set(result.size() - 1, 2 * result.get(result.size() - 1));
                continue;
            } else if (numberList.get(i).equals("#")) {
                result.set(result.size() - 1, (-1) * result.get(result.size() - 1));
                continue;
            }
        }

        int answer = 0;
        for (int i = 0; i < result.size(); i++) {
            answer = answer + result.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String dartResult = "1D2S#10S";
        int result = 9;

        if (solution(dartResult) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}