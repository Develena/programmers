package com.develena.sort;

import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{3, 0, 6, 1, 5})); //3
        System.out.println(solution(new int[]{0, 0, 0, 0, 0}));// 0
        System.out.println(solution(new int[]{0, 0, 0, 0, 1})); // 1
        System.out.println(solution(new int[]{9, 9, 9, 12}));// 4 -----
        System.out.println(solution(new int[]{9, 7, 6, 2, 1})); // 3
        System.out.println(solution(new int[]{10, 8, 5, 4, 3})); // 4
        System.out.println(solution(new int[]{25, 8, 5, 3, 3})); // 3
        System.out.println(solution(new int[]{1, 1, 5, 7, 6})); // 3
        System.out.println(solution(new int[]{0})); //0
        System.out.println(solution(new int[]{0,0})); //0

    }

    public static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        // System.out.println(Arrays.toString(citations)); // 9, 9, 9, 12

        for (int i = citations[citations.length-1]; i >= 0; i--) { // 12 11 10 9
            int h = i; // 10000
            // cri번 이상 인용된 논문 수.
            int overCnt = (int) Arrays.stream(citations)
                    .filter(n -> n >= h)
                    .count();

            if (overCnt >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}
