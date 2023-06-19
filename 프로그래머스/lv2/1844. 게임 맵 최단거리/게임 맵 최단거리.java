import java.util.*;

class Move{
    int x, y, depth;
    
    Move(int x, int y, int depth){
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}

class Solution {
        public static int answer,n,m;
        public static boolean[][] visited;
    public int solution(int[][] maps) {
        answer = 10000000;
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
  
                
                    
        BFS(0,0,maps);
    
        
        
        if(answer > 1000000){
            answer = -1;
        }
        return answer;
    }
    public static void BFS(int x, int y, int[][] maps){
        
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        Deque<Move> que = new ArrayDeque();
        que.addLast(new Move(x,y,1));
        visited[x][y] =true;
        while(!que.isEmpty()){
            Move temp = que.poll();
            if(temp.x == n-1 && temp.y == m-1){
                answer = Math.min(temp.depth, answer);
            }
            for(int i=0;i<4;i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                
                if(0<= nx && nx<n && 0<=ny && ny<m && maps[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    que.addLast(new Move(nx,ny,temp.depth+1));
                    
                }
            }
            
        }
        
        
    }
}