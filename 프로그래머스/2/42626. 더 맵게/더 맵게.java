import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> que = new PriorityQueue<>();
        
        for(int i : scoville){
            que.add(i);
        }
        while(que.size() > 1 && que.peek() < K){
            int num = que.poll() + (que.poll() * 2);
            answer++;
            que.add(num);
            
        }
        
        if(que.size() <= 1 && que.peek() < K){
            answer = -1;
        }
        return answer;
    }
}