package 신규아이디;

public class Main {
    public static void main(String[] ars) {
        Solution s = new Solution();

        String new_id = "...!@BaT#*..y.abcdefghijklm";
        String result = "bat.y.abcdefghi";

        String answer = s.solution(new_id);

        if (result.equals(answer)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("일치하지 않습니다.");
        }

    }
}