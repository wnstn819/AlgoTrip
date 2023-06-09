import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String,Integer> arr = new HashMap<>();
        for(String s : participant){
            arr.put(s, arr.getOrDefault(s,0)+1);
        }    
        for(String s : completion){
            arr.put(s, arr.get(s) -1);
        }
        
        for(String key : arr.keySet()){
            if(arr.get(key) !=0){
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}