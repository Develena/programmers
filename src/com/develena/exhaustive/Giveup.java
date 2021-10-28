package com.develena.exhaustive;

import java.util.*;

public class Giveup {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(solution(new int[]{1,3,2,4,2})));
//        System.out.println(Arrays.toString(solution(new int[]{1,1,1,1,1})));
    }


    public static int[] solution(int[] answers) {
        HashMap<Integer,Integer> cntMap = new HashMap<>();

        // 각 수포자가 찍는 방식
        int[] p1 = new int[]{1, 2, 3, 4, 5}; // 5
        int[] p2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] p3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10

        for (int i = 0; i < answers.length; i++) {

            if(p1[(i % p1.length)] == answers[i]){
                cntMap.put(1, cntMap.getOrDefault(1, 0) + 1);
            }
            if(p2[(i % p2.length)] == answers[i]){
                cntMap.put(2, cntMap.getOrDefault(2, 0) + 1);
            }
            if(p3[(i % p3.length)] == answers[i]){
                cntMap.put(3, cntMap.getOrDefault(3, 0) + 1);
            }

        }

        // 가장 많이 맞춘 사람 순(value 내림차순) 정렬.
        List<Integer> keys = new ArrayList<>(cntMap.keySet());

        Collections.sort(keys, (o1, o2) ->
                cntMap.get(o2).compareTo(cntMap.get(o1))); //  내림차순

//        for (Integer key : keys){
//            System.out.println(cntMap.get(key));
//        }

        // 오름차순
        return  keys.stream()
                .filter(p -> cntMap.get(p) >= cntMap.get(keys.get(0)))
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
