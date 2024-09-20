import java.util.*;

class Solution {
    public static Map<String, Integer> map, first, second, firstIndex, secondIndex;

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answerList = new ArrayList<>(); // 동적 크기 조절을 위한 ArrayList
        map = new HashMap<>();
        first = new HashMap<>();
        second = new HashMap<>();
        firstIndex = new HashMap<>();
        secondIndex = new HashMap<>();

        // 우선순위 큐: 재생 수가 많은 순서대로 정렬
        PriorityQueue<General> que = new PriorityQueue<>((o1, o2) -> o2.plays - o1.plays);

        // 장르별로 재생 수 및 곡 정보 저장
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);

            // 첫 번째 곡 처리
            if (first.get(genres[i]) == null || 
                first.get(genres[i]) < plays[i] || 
                (first.get(genres[i]) == plays[i] && firstIndex.get(genres[i]) > i)) {
                
                // 기존 첫 번째 곡을 두 번째 곡으로 옮김
                second.put(genres[i], first.getOrDefault(genres[i], 0));
                secondIndex.put(genres[i], firstIndex.getOrDefault(genres[i], -1));

                // 새로운 첫 번째 곡 설정
                first.put(genres[i], plays[i]);
                firstIndex.put(genres[i], i);
                
            // 두 번째 곡 처리
            } else if (second.get(genres[i]) == null || 
                       second.get(genres[i]) < plays[i] || 
                       (second.get(genres[i]) == plays[i] && secondIndex.get(genres[i]) > i)) {
                
                second.put(genres[i], plays[i]);
                secondIndex.put(genres[i], i);
            }
        }

        // 장르별 총 재생 수에 따라 큐에 추가
        for (String str : map.keySet()) {
            que.add(new General(str, map.get(str)));
        }

        // 큐에서 장르별로 두 개의 곡 인덱스를 가져와 결과에 추가
        while (!que.isEmpty()) {
            String gen = que.poll().genres;

            // 첫 번째 곡 추가
            if (firstIndex.get(gen) != null) {
                answerList.add(firstIndex.get(gen));
            }

            // 두 번째 곡 추가
            if (secondIndex.get(gen) != null && secondIndex.get(gen) != -1) {
                answerList.add(secondIndex.get(gen));
            }
        }

        // ArrayList를 배열로 변환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}

class General {
    String genres;
    int plays;

    General(String genres, int plays) {
        this.genres = genres;
        this.plays = plays;
    }
}
