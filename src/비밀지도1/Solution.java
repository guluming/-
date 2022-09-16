package 비밀지도1;

import java.util.Arrays;

public class Solution {
    static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String temp;

        for (int i = 0; i < n; i++) {
            temp = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
            temp = temp.substring(temp.length() - n);
            temp = temp.replaceAll("1", "#").replaceAll("0", " ");
            answer[i] = temp;
        }

        return answer;

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        String[] answer = new String[n];
//        for (int i = 0; i < n; i++) {
//            String binary1 = Integer.toBinaryString(arr1[i]);
//            String binary2 = Integer.toBinaryString(arr2[i]);
//            binary1 = "0".repeat(n - binary1.length()) + binary1;
//            binary2 = "0".repeat(n - binary2.length()) + binary2;
//            ;
//            String[] biArr1 = binary1.split("");
//            String[] biArr2 = binary2.split("");
//            StringBuilder sb = new StringBuilder();
//            for (int j = 0; j < n; j++) {
//                if (biArr1[j].equals("1") || biArr2[j].equals("1")) {
//                    sb.append("#");
//                } else {
//                    sb.append(" ");
//                }
//            }
//            answer[i] = sb.toString();
//        }
//        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {46,33,33,22,31,50};
        int[] arr2 = {27,56,19,14,14,10};
        String[] result = {"######", "### #", "## ##", " #### ", " #####", "### # "};
        if (Arrays.equals(solution(n, arr1, arr2), result)) {
            System.out.println(Arrays.toString(solution(n, arr1, arr2)));
            System.out.println(Arrays.toString(result));
            System.out.println("통과했습니다.");
        } else {
            System.out.println(Arrays.toString(solution(n, arr1, arr2)));
            System.out.println(Arrays.toString(result));
            System.out.println("불일치했습니다.");
        }
    }
}