import java.util.*;
class Solution {
        public static Stack<Integer> sub;
    
    public int solution(int[] order) {
        int answer = 0;
        
        sub = new Stack();
        
        int location = 0;
        for(int i =0;i<order.length;i++){
            sub.add(i+1);
            
            while(!sub.isEmpty()){
                if(sub.peek() == order[location]){
                    sub.pop();
                    answer++;
                    location++;
                }else{
                    break;
                }
            }
        }
        
        return answer;
    }
}