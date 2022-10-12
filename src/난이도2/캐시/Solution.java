package 난이도2.캐시;

import java.util.*;

public class Solution {
    public static long solution(int cacheSize, String[] cities) {
        int answer = 0;
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }

        LinkedList<String> cache = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            if (cache.isEmpty() && cacheSize != 0) {
                cache.add(cities[i]);
                answer = answer + 5;
            } else if (cacheSize == 0) {
                answer = answer + 5;
            } else if (cache.size() < cacheSize) {
                if (!cache.contains(cities[i])) {
                    cache.add(cities[i]);
                    answer = answer + 5;
                } else {
                    cache.remove(cache.indexOf(cities[i]));
                    cache.add(cities[i]);
                    answer = answer + 1;
                }
            } else {
                if (!cache.contains(cities[i])) {
                    cache.removeFirst();
                    cache.add(cities[i]);
                    answer = answer + 5;
                } else {
                    cache.remove(cache.indexOf(cities[i]));
                    cache.add(cities[i]);
                    answer = answer + 1;
                }
            }
        }

        System.out.println(cache);
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        int cacheSize = 0;
        String[] cities = {"la","la"};
        int result = 10;
        if (solution(cacheSize, cities) == result) {
            System.out.println("통과했습니다.");
        } else {
            System.out.println("불일치했습니다.");
        }
    }
}