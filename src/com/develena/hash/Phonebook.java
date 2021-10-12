package com.develena.hash;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {

  public static void main(String[] args) {

    System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
    System.out.println(solution(new String[]{"123", "456", "789"}));
    System.out.println(solution(new String[]{"12", "123", "1235", "567", "88"}));

  }

  public static boolean solution(String[] phone_book) {
    boolean answer = true;

    // 전화번호를 hashing한다 -> HashMap (key) 이용
    Map<String, Integer> hashMap = new HashMap<String, Integer>();
    for (int i = 0; i < phone_book.length; i++) {
      hashMap.put(phone_book[i], i);
    }

    // HashMap의 containsKey를 이용하여 검색
    for (int i = 0; i < phone_book.length; i++) {
      for (int j = 0; j < phone_book[i].length(); j++) { // length만큼 검사.
        if (hashMap.containsKey(phone_book[i].substring(0, j))) {
          answer = false;
          return answer;
        }
      }
    }
    return answer;
  }


}
