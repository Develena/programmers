package com.develena.exhaustive;

import java.util.HashSet;
import java.util.Set;

public class PrimeNumber {

    private static boolean[] visited; // 선택한 숫자 checked.
    private static char[] arr;
    private static Set<Integer> set = new HashSet<>(); // 조합을 넣을 셋.(중복 없이)

    public static void main(String[] args) {

        System.out.println(solution("17"));
        System.out.println(solution("011"));

    }


    public static int solution(String numbers) {
        set.clear();
        visited = new boolean[numbers.length()];
        arr = new char[numbers.length()];

        // String number -> int[] 변환.
//        int[] numArr = new int[numbers.length()]; // 순열을 만들 배열
//        for (int i = 0; i < numbers.length(); i++) {
//            numArr[i] = numbers.charAt(i) - '0';
//        }
//
//        System.out.println(Arrays.toString(numArr));
//        System.out.println("------");

        for (int i = 1; i <= numbers.length(); i++) {
            perm_with_defs(0, i, numbers);
        }
        return set.size();

    }


    //2. DFS를 이용해 구현  - 순서를 지키면서 n 개중에서 r 개를 뽑는 경우
    static void perm_with_defs(int level, int length, String numbers) {
        if (level == length) {
            int num = charToInt(arr, length);
            if (isPrime(num)) {
                set.add(num);
            }
            // output
            return;
        }
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i] != true) {
                visited[i] = true;
                arr[level] = numbers.charAt(i);
                perm_with_defs(level + 1, length, numbers);
                visited[i] = false;
            }
        }
    }

    // 2부터 num의 제곱근까지 모듈연산을 확인하는 방법. O(√N)
    private static boolean isPrime(int num) {
        if (num == 1 || num == 0) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private static int charToInt(char[] arr, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(arr[i]);
        }
        return Integer.parseInt(sb.toString());

    }

}
