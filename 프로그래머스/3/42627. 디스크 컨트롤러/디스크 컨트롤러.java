import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int currentTime = 0;
        
        PriorityQueue<int[]> que = new PriorityQueue<>((o1,o2) -> {
            return o1[0]-o2[0];
        });
        
        
        PriorityQueue<int[]> que2 = new PriorityQueue<>((o1,o2) -> {
            return o1[1]-o2[1];
        });
        
        for(int i=0;i<jobs.length;i++){
            que.add(new int[]{jobs[i][0],jobs[i][1]});
        }
        
        

        while(!que.isEmpty() || !que2.isEmpty()){
            
           
            while(!que.isEmpty() && que.peek()[0] <= currentTime){
                que2.offer(que.poll());
            }
         

            if(que2.isEmpty()){
                currentTime = que.peek()[0];
            }else{
                int[] a = que2.poll();
                answer += a[1]+currentTime - a[0];
                currentTime += a[1];  
            }
 
            
            
        }
        
        answer /= jobs.length;

        return answer;
    }
}