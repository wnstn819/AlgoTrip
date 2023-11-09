import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int start = 0;
        int end = -1;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<want.length;i++){
            map.put(want[i],number[i]);
            end += number[i];
        }
        
        for(int i=start ; i<=end;i++){
            if(map.get(discount[i]) != null){
                map.put(discount[i], map.get(discount[i])-1);
            }
        }
                
        while(end < discount.length){
            int check = 0;
            for(String str: map.keySet()){
                if(map.get(str) > 0){
                    check = 1;
                    break;
                }
            }
            
            if(check == 0){
                answer++;
            }
            
            if(end == discount.length-1){
                break;
            }
            
           
           
            
            if(map.get(discount[start]) !=null){
                map.put(discount[start],map.get(discount[start])+1);    
            }
             start++;
             end++;
            
            if(map.get(discount[end]) != null){  
                map.put(discount[end],map.get(discount[end])-1);    
            }
            
            
            
            
        }
        
        
        
        return answer;
    }
}