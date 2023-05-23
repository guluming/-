package 가문제메모장;
/*

*/

import java.util.*;

public class Solution {

    public static int solution(int[][] queries) {
        HashSet<Integer> temp1 = new HashSet<>();
        for (int i = 0; i < queries.length; i++) {
            temp1.add(queries[i][0]);
        }

        List<customArray> customArrayList = new ArrayList<>();
        for (Integer integer : temp1) {
            customArray customArray = new customArray(integer, 0, 0, 0);
            customArrayList.add(customArray);
        }

        for (int i = 0; i < queries.length; i++) {
            for (int k = 0; k < customArrayList.size(); k++) {
                if (customArrayList.get(k).getNumber() == queries[i][0]) {
                    int temp = customArrayList.get(k).getNowArraySize() + queries[i][1];

                    if (temp <= customArrayList.get(k).getMaxArraySize()) {
                        customArrayList.get(k).setNowArraySize(customArrayList.get(k).getNowArraySize() + queries[i][1]);
                    } else {
                        customArrayList.get(k).setCopyCount(customArrayList.get(k).getCopyCount() + customArrayList.get(k).getNowArraySize());
                        customArrayList.get(k).setNowArraySize(customArrayList.get(k).getNowArraySize() + queries[i][1]);
                        customArrayList.get(k).setMaxArraySize(arraySizeUp(temp));
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < customArrayList.size(); i++) {
            answer = answer + customArrayList.get(i).getCopyCount();
        }

        return answer;
    }

    public static int arraySizeUp(int arrayNumber) {
        int result = 1;
        while (result < arrayNumber) {
            result = result * 2;
        }

        return result;
    }

    static class customArray {
        private int number;
        private int nowArraySize;
        private int maxArraySize;
        private int copyCount;

        public customArray(int number, int nowArraySize, int maxArraySize, int copyCount) {
            this.number = number;
            this.nowArraySize = nowArraySize;
            this.maxArraySize = maxArraySize;
            this.copyCount = copyCount;
        }

        public void setNowArraySize(int nowArraySize) {
            this.nowArraySize = nowArraySize;
        }

        public void setMaxArraySize(int maxArraySize) {
            this.maxArraySize = maxArraySize;
        }

        public void setCopyCount(int copyCount) {
            this.copyCount = copyCount;
        }

        public int getNumber() {
            return number;
        }

        public int getNowArraySize() {
            return nowArraySize;
        }

        public int getMaxArraySize() {
            return  maxArraySize;
        }

        public int getCopyCount() {
            return copyCount;
        }
    }

    public static void main(String[] args) {
        int[][] queries = {{2,10},{7,1},{2,5},{2,9},{7,32}};
        int result = 16;
//        int[][] queries = {{1,1},{1,2},{1,4},{1,8}};
//        int result = 11;
        if (solution(queries) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}