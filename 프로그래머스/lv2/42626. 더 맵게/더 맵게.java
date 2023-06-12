import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue();
        for(int i : scoville){
            q.add(i);
        }
        
        while(q.peek() < K && q.size() >= 2){
            answer++;
            int a = q.poll();
            int b = q.poll();
            int ans = a+(b*2);
            q.add(ans);
        }
        
        if(q.peek() < K){
            answer= -1;
        }
        
        return answer;
    }
}