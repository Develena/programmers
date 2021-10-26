package com.develena.sort;

import java.util.*;

public class MaxNumber {

    public static void main(String[] args) {
        System.out.println(solution2(new int[]{6, 10, 2}));
        System.out.println(solution2(new int[]{3, 30, 34, 5, 9}));
        System.out.println(solution2(new int[]{0,0,0}));
    }

    public static String solution(int[] numbers) { // 1 이상.
        String answer = "";

        String[] temp = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            temp[i] = String.valueOf(numbers[i]);

        }

        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2); // 내림차순??
            }
        });

//        System.out.println(Arrays.toString(temp));

        if(temp[0].equals("0")) return "0"; // {0,0,0}
        for(String str : temp){
            answer += str;
        }

        return answer;
    }

    public static String solution2(int[] numbers){
        String answer = "";

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });
        StringBuilder sb = new StringBuilder();
        for(Integer i : list) {
            sb.append(i);
        }
        answer = sb.toString();
        if(answer.charAt(0) == '0') {
            return "0";
        }else {
            return answer;
        }
    }

}
