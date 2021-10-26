package com.develena.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class KthNumber {

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{
                {2,5,3},
                {4, 4, 1},
                {1, 7, 3}
        };

        System.out.println(Arrays.toString(solution(array, commands)));

        test();
    }


    public static int[] solution(int[] array, int[][] commands) {
        int[] answer =  new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i]; // {2,5,3}

            // 1. Arrays.copyOfRange() 이용하여 잘린 subArray 생성.
            int[] subArray = Arrays.copyOfRange(array, command[0]-1, command[1]);
//            System.out.println(Arrays.toString(subArray));
            // 2. 배열 sorting 오름차순.
            Arrays.sort(subArray);
//            System.out.println(Arrays.toString(subArray));

            answer[i] = subArray[command[2]-1];

        }
        return answer;
    }


    public static void test(){
        int[] arr = {1,2,3,4,5};
        int[] subArr = Arrays.copyOfRange(arr, 2,4);
        System.out.println(Arrays.toString(subArr));
    }
}
