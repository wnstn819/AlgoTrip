import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer,Integer> left = new HashMap<>();
        Map<Integer,Integer> right = new HashMap<>();
        left.put(topping[0],1);
        for(int i=1;i<topping.length;i++){
            right.put(topping[i],right.getOrDefault(topping[i],0)+1);
        }
        
        if(left.size() == right.size()){
            answer++;
        }
        for(int i=1;i<topping.length;i++){
            left.put(topping[i],right.getOrDefault(topping[i],0)+1);
            if(right.get(topping[i]) == 1){
                right.remove(topping[i]);
            }else{
                right.put(topping[i],right.get(topping[i])-1);
            }
            
             if(left.size() == right.size()){
            answer++;
            }
            
        }
        return answer;
    }
}