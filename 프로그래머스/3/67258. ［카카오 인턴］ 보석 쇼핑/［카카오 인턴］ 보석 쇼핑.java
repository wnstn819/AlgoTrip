import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        HashSet<String> set = new HashSet();
        HashMap<String, Integer> map = new HashMap<>();
        int dif = Integer.MAX_VALUE;
        for(String gem : gems){
            set.add(gem);
        }
        
        int start = 0;
        int end = 0;
       
        while(true){
            
            if(map.size() == set.size()){
              
                if(end - start < dif){
                    dif = end - start;
                    answer = new int[]{start+1,end};
                    
                }
                map.put(gems[start], map.get(gems[start]) - 1);
                if (map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                }
                start++;
                
            }else{
                if (end == gems.length) {
                    break;
                }
                  
                map.put(gems[end],map.getOrDefault(gems[end],0)+1);
                end++;
                   
            }
            
        }
    
        
        return answer;
    }
}