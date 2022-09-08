package 나머지가1이되는수찾기;

public class Main {
    public static void main(String[] ars) {
        Solution s = new Solution();

        int n = 10;
        int result = 3;

        int answer = s.solution(n);

        if (result == answer) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("일치하지 않습니다.");
        }

    }
}