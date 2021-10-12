package com.develena.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *  Hash Lv2. 위장
 */
public class Disguise {

  public static void main(String[] args) {
//    System.out.println(solution(new String[][]{
//        {"yellowhat", "headgear"},
//        {"bluesunglasses", "eyewear"},
//        {"green_turban", "headgear"}
//    }));
    System.out.println(solution(new String[][]{
        {"crowmask", "face"},
        {"bluesunglasses", "face"},
        {"smoky_makeup", "face"}
    }));

  }

  public static int solution(String[][] clothes) {
        int answer = 0;

        Map<String, List<String>> hashmap = new HashMap<String, List<String>>();

      for (int i = 0; i < clothes.length; i++) {
        if(hashmap.containsKey(clothes[i][1])){
            List<String> list = hashmap.get(clothes[i][1]);
            list.add(clothes[i][0]);
          }else{
            List<String> list = new ArrayList<String>();
            list.add(clothes[i][0]);
            hashmap.put(clothes[i][1],list);
          }
      }
//      hashmap.forEach((key, val) -> System.out.println("key: " + key + ", val.size : " + val.size()));
//      int cnt = hashmap.entrySet().stream().map( m -> m.getValue().size()).collect(Collectors.toList()).stream().reduce(0,(a,b) -> a * b);
//      int eachCnt = hashmap.entrySet().stream().map( m -> m.getValue().size()).collect(Collectors.toList()).stream().reduce(0, (a,b) -> a + b);
      return answer;
    }


}
