package 난이도2.최댓값과최솟값;

import java.util.*;

public class Solution {
    static int[][] map;

    public static String solution(String s) {
        String answer = "";
        String[] saar = new String[(s.length()+1)/2];
        saar = s.split(" ");

        int[] iaar = new int[saar.length];
        for (int i=0; i< saar.length; i++) {
            iaar[i] = Integer.parseInt(saar[i]);
        }

        Arrays.sort(iaar);

        answer = Integer.toString(iaar[0]) + " " + Integer.toString(iaar[iaar.length -1]);
        return answer;
    }

    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        String result = "-4 -1";
        if (solution(s).equals(result)) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}