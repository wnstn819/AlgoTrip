import java.util.*;
class Solution {
        public static int answer;
        public static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        
            
        Deque<Integer> que = new ArrayDeque();
        visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(visited[i]){
                continue;
            }
            que.addLast(i);
            visited[i] = true;
            while(!que.isEmpty()){
                
            int a = que.poll();
            for(int j =0; j<n;j++){
                if(computers[a][j] == 1 && !visited[j]){
                    visited[j] = true;
                    que.addLast(j);
                }
            }
            }
            answer++;
            
        }
        
        return answer;
    }
    
   
}