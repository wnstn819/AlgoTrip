import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : tangerine){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        list.sort((o1,o2)-> o2-o1);
        for(int i : list){
            k-=i;
            answer++;
            if(k<1){
                return answer;
            }
            
        }
        return answer;
    }
}