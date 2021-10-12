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
    System.out.println(solution(new String[][]{
        {"yellowhat", "headgear"},
        {"bluesunglasses", "eyewear"},
        {"green_turban", "headgear"}
    }));
    System.out.println(solution(new String[][]{
        {"crowmask", "face"},
        {"bluesunglasses", "face"},
        {"smoky_makeup", "face"}
    }));

  }

//  public static int solution(String[][] clothes) {
//        int answer = 0;
//
//        Map<String, String> hashmap = new HashMap<String, String>();
//
//        for (int i = 0; i < clothes.length; i++) {
////          if(hashmap.containsKey(clothes[i][1])){
////              answer += hashmap.size();
////          }else{
////              hashmap.put(clothes[i][1], clothes[i][0]);
////          }
//          answer++;
//        }
//      return answer;
//    }

  public static int solution(String[][] clothes) {
        int answer = 1;

        Map<String, List<String>> hashmap = new HashMap<String, List<String>>();

//      for (int i = 0; i < clothes.length; i++) {
//        if(hashmap.containsKey(clothes[i][1])){
//            List<String> list = hashmap.get(clothes[i][1]);
//            list.add(clothes[i][0]);
//          }else{
//            List<String> list = new ArrayList<String>();
//            list.add(clothes[i][0]);
//            hashmap.put(clothes[i][1],list);
//          }
//      }
//
//      // (A+1)*(B+1) - 1;
//      for(String key :  hashmap.keySet()){
//          answer *= (hashmap.get(key).size() + 1);
//      }
//      return answer-1;

      // case 2
      Map<String, Integer> hs = new HashMap<String, Integer>();

      for(int i =0; i<clothes.length; i++){
          // key (clothes[i][1]) 이 존재할 경우 해당 값 반환, 없으면 0 반환 -> 반환값에 1 더한값 저장.
          hs.put(clothes[i][1], hs.getOrDefault(clothes[i][1],0)+1);
      }

      for(String key : hs.keySet()) {
          answer *=(hs.get(key)+1);
      }
      answer -=1;
      return answer;


  }


}
