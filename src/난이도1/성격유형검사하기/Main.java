package 난이도1.성격유형검사하기;

public class Main {
    public static void main(String[] ars) {
        Solution s = new Solution();

        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        String answer = s.solution(survey, choices);
        String result = "TCMA";

        if (answer.equals(result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("일치하지 않습니다.");
        }
    }
}