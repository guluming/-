package 난이도2.파일명정렬;

import java.util.*;

public class Solution {
    private static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] file_1 = file_check(o1);
                String[] file_2 = file_check(o2);

                int head_value = file_1[0].compareTo(file_2[0]);

                if (head_value == 0) {
                    int number_1 = Integer.parseInt(file_1[1]);
                    int number_2 = Integer.parseInt(file_2[1]);

                    return number_1 - number_2;
                } else {
                    return head_value;
                }
            }

            private String[] file_check(String str) {
                String head = "";
                String number = "";

                int index = 0;
                for (; index<str.length(); ++index) {
                    char check = str.charAt(index);
                    if (check >= '0' && check <='9') {
                        break;
                    }
                    head = head + check;
                }

                for (; index<str.length(); ++index) {
                    char check = str.charAt(index);
                    if (!(check >= '0' && check <='9')) {
                        break;
                    }
                    number = number + check;
                }

                return new String[]{head.toUpperCase(), number};
            }
        });

        return files;
    }

    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] result = {"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"};
        if (Arrays.equals(solution(files), result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}