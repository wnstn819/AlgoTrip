import java.util.*;

class Solution {
    
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        
        for(int i : section){
            que.add(i);
        }
        
        while(!que.isEmpty()){
            int number = que.poll();
            
            while(!que.isEmpty() && number+m >que.peek()){
                que.poll();
            }
            answer++;
        }
        return answer;
    }
}