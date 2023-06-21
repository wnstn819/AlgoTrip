import java.util.*;

class Solution {
        public static int answer;
        public static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        ArrayList<Integer> arr = new ArrayList();
        visited = new boolean[dungeons.length];
        DFS(0,k, dungeons,0);
        
        
        
        return answer;
    }
    
    public static void DFS(int n,int k,int[][] dungeons,int depth){
        if(k >= 0 ){
            answer = Math.max(answer, depth);
        }else{
            return;
        }
        
        for(int i=n;i<dungeons.length;i++){
            if(!visited[i] &&k >= dungeons[i][0]  && k-dungeons[i][1] >= 0){
                visited[i] = true;
                DFS(n,k-dungeons[i][1],dungeons,depth+1);
                visited[i] = false;
            }
        }
        
    
               
        
    }
}