package com.develena.hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 완주하지 못한 선수.
 */
public class Player {

  public static void main(String[] args) {

    System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},new String[]{"josipa", "filipa", "marina", "nikola"}));
    System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"},new String[]{"stanko", "ana", "mislav"}));


  }

  public static String solution(String[] participant, String[] completion) {
    String answer = "";

    Arrays.sort(participant); // 알파벳 오름차순
    Arrays.sort(completion); // 알파벳 오름차순

    for (int i = 0; i < completion.length; i++) {
      if(participant[i].equals(completion[i])){
        continue;
      }else{ // 참가자 - 완주자가 다를 경우: 해당 순서의 참가자가 미완주자.
        answer = participant[i];
        return answer;
      }
    }
    // for문이 다 통과되면: 참가자 중 남은 사람이 미완주자.
    answer = participant[completion.length];
    return answer;


  }

}
