package 난이도2.전화번호목록;

import java.util.*;

public class Solution {
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i=0; i< phone_book.length; i++) {
            if (i == phone_book.length - 1) {
                break;
            }
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] phone_book = {"123", "1000", "1234"};
        boolean result = false;
        if (solution(phone_book) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}