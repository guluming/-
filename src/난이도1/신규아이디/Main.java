package 난이도1.신규아이디;

public class Main {
    public static void main(String[] ars) {
        Solution s = new Solution();

        String new_id = "01234567898765.321";
        String result = "01234567898765";

        String answer = s.solution(new_id);

        if (result.equals(answer)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("일치하지 않습니다.");
        }

    }
}