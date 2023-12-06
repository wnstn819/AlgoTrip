import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Deque<Integer> dque = new ArrayDeque<>();
        Deque<Integer> pque = new ArrayDeque<>();
        
        for(int i = 0;i<n;i++){
            dque.addFirst(deliveries[i]);
            pque.addFirst(pickups[i]);
        }    

        while(!dque.isEmpty() || !pque.isEmpty() ){
            while(!dque.isEmpty() && dque.peek() == 0){
                dque.poll();
            }
            
            while(!pque.isEmpty() && pque.peek() == 0){
                pque.poll();
            }
            int dsize = dque.size();
            int psize = pque.size();
            int dcnt = cap;
            int pcnt = cap;
            while(dcnt > 0 && !dque.isEmpty()){
                if(dque.peek() <= dcnt){
                    dcnt -= dque.poll();
                }else{
                    dque.addFirst(dque.poll() - dcnt);
                    dcnt = 0;
                    
                }
            }
            while(pcnt >0 && !pque.isEmpty()){
                if(pque.peek() <= pcnt){
                    pcnt -= pque.poll();
                }else{
                    pque.addFirst(pque.poll() - pcnt);
                    pcnt = 0;
                }
            }
            
            answer += Math.max(dsize, psize) * 2;
            
        }
        
        return answer;
    }
}