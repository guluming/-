package 가문제메모장;

import java.util.*;

public class Solution4 {
    public static int[] solution(int[] balance, int[][] transaction, int[] abnormal) {
        List<User> logs = new ArrayList<>();
        for (int i = 0; i < balance.length; i++) {
            User user = new User(i + 1, balance[i]);
            logs.add(user);
        }

        for (int i = 0; i < transaction.length; i++) {
            List<int[]> plusPoint = new ArrayList<>();

            if (logs.get(transaction[i][1] - 1).getUserPlusPoint() != null) {

                for (int j=0; j<logs.get(transaction[i][1] - 1).getUserPlusPoint().size(); j++) {
                    int a = 0;
                    if (logs.get(transaction[i][1] - 1).getUserPlusPoint().get(j)[1] - transaction[i][2] < 0) {
                        a = transaction[i][2] - logs.get(transaction[i][1] - 1).getUserPlusPoint().get(j)[1];
                        logs.get(transaction[i][1] - 1).pointDown(a);
                        int[] temp = {transaction[i][0], a};
                        plusPoint.add(temp);
                    }
                }

            } else {
                int[] temp = {transaction[i][0], transaction[i][2]};
                plusPoint.add(temp);
            }

            if (logs.get(transaction[i][1] - 1).getUserPlusPoint() != null) {
                logs.get(transaction[2][1] - 1).updatePlusPoint(plusPoint);
            } else {
                logs.get(transaction[i][0] - 1).pointDown(transaction[i][2]);
                logs.get(transaction[i][1] - 1).setPlusPoint(plusPoint);
            }
        }

        System.out.println(logs.get(0).getUserPlusPoint());
        System.out.println(logs.get(1).getUserPlusPoint());
        System.out.println(logs.get(2).getUserPlusPoint());
        System.out.println(logs.get(3).getUserPlusPoint());
        System.out.println(Arrays.toString(logs.get(1).getUserPlusPoint().get(0)));
        System.out.println(Arrays.toString(logs.get(2).getUserPlusPoint().get(0)));
        System.out.println(Arrays.toString(logs.get(3).getUserPlusPoint().get(0)));
        System.out.println(Arrays.toString(logs.get(3).getUserPlusPoint().get(1)));

        int[] answer = new int[balance.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = logs.get(i).getUserPoint();
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }

    static class User {
        private int number;
        private int point;
        private List<int[]> plusPoint;

        public User(int number, int point) {
            this.number = number;
            this.point = point;
        }

        public int getUserNumber() {
            return number;
        }

        public int getUserPoint() {
            return point;
        }

        public List<int[]> getUserPlusPoint() {
            return plusPoint;
        }

        public void setPlusPoint(List<int[]> plusPoint) {
            this.plusPoint = plusPoint;
        }

        public void pointDown(int point) {
            this.point = this.point - point;
        }

        public void updatePlusPoint(List<int[]> plusPoint) {
            this.plusPoint.add(plusPoint.get(0));
        }
    }

    public static void main(String[] args) {
        int[] balance = {30, 30, 30, 30};
        int[][] transaction = {{1, 2, 10}, {2, 3, 20}, {3, 4, 5}, {3, 4, 30}};
        int[] abnormal = {1};
        int[] result = {0, 20, 15, 55};
        if (Arrays.equals(solution(balance, transaction, abnormal), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}