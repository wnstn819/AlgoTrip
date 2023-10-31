import java.util.*;

class Solution {
    public int solution(int[] order) {
        int result = 0;
        
        Stack<Integer> belt = new Stack<>();
        Stack<Integer> subBelt = new Stack<>();
        for(int i=order.length;i>0;i--){
            belt.push(i);
        }
        for(int i=0;i<order.length;i++){
            
            if(!subBelt.isEmpty() && subBelt.peek() == order[i]){
                subBelt.pop();
                result++;
                continue;
            }
            while(!belt.isEmpty() && belt.peek() != order[i]){
                subBelt.push(belt.pop());
            }
            
            if(!belt.isEmpty() && belt.peek() == order[i]){
                result++;
                belt.pop();
            }else{
                break;
            }
            
        }
        return result;
    }
}