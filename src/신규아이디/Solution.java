package 신규아이디;


class Solution {
    public String solution(String new_id) {

        new_id = new_id.toLowerCase();

        if (new_id.equals("")) {
            new_id = "a";
        }

        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.charAt(new_id.length()-1) == '.') {
                StringBuilder new_str_id = new StringBuilder(new_id);
                new_id = new_str_id.deleteCharAt(14) + "";
            }
        }

        while (new_id.length() <= 2) {
            new_id = new_id + new_id.charAt(new_id.length()-1);
        }

        System.out.println(new_id);
        String answer = new_id;
        return answer;
    }
}