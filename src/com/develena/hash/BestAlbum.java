package com.develena.hash;

import java.util.*;

public class BestAlbum {

    public static void main(String[] args) {
        int ret[] = solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500});
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i] + " ");
        }

    }

    public static int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        // 1. genre play 수 max
        // genre를 key로 가지는 해쉬맵을 만들고, value로는 play수를 증가시켜 put 함.
        HashMap<String, Integer> genreAndPlayMap = new HashMap<String, Integer>();
        for (int i = 0; i < genres.length; i++) {
            genreAndPlayMap.put(genres[i], genreAndPlayMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        System.out.println(genreAndPlayMap);

        // 2. 1의 hashmap의 key를 sorting : keySet() -> Collection.sort(내림차순)
        // **맵에서 value 에 따라 key 를 sorting 하기.
        List<String> keys = new ArrayList<>(genreAndPlayMap.keySet());

        Collections.sort(keys, (o1, o2) ->
            genreAndPlayMap.get(o2).compareTo(genreAndPlayMap.get(o1))); //  사용자 정의 sorting.

        for (String key : keys){
            System.out.println(key +"의 play");
            List<Integer> playList = new ArrayList<Integer>(); // play의 고유 i 리스트 넣기.
            for (int i = 0; i < genres.length; i++) {
                if(genres[i].equals(key)){ // genre가 pop이
                    playList.add(i);
                }
            }
            playList.sort(((o1, o2) -> plays[o2]-plays[o1]));
//            playList.forEach(System.out::println);
            if(playList.size() > 0){
                for (int i = 0; i < playList.size(); i++) {
                    if (i == 2) { // 두개까지 제한.
                        break;
                    }
                    answer.add(playList.get(i));
                }
            }



        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}
