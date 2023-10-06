import java.util.*;

class Solution {
        static char[][] map1, map2;
        static int[] dx = {0,0,1,-1};
        static int[] dy = {1,-1,0,0};
        static int N,M;
    
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        map1 = new char[N][M];
        map2 = new char[N][M];
        Node node = null;
        
        for(int i=0;i<N;i++){ // map1,2 셋팅
            for(int j=0;j<M;j++){
                char c = maps[i].charAt(j);
                map1[i][j] = c;
                map2[i][j] = c;
                if(c == 'S'){
                    node = new Node(i,j,0);
                }   
            }
        }
        
        
        Node result= bfs(bfs(node, map1,'L'),map2,'E');
        answer = result.depth;
        return answer;
    }
    
    public Node bfs(Node start, char[][] map, char find){
        
        if(start.depth == -1){
            return new Node(0,0,-1);
        }
        Queue<Node> que = new LinkedList<>();
        que.add(start);
        
        while(!que.isEmpty()){
            Node next= que.poll();

            if(map[next.x][next.y] == find){
                return next;
            }
            
            for(int i=0;i<4;i++){
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];
                if(0<= nx && nx < N && 0<= ny && ny < M && map[nx][ny] != 'X'){
                    que.add(new Node(nx,ny,next.depth +1));
                    if(map[nx][ny] != find){
                        map[nx][ny] = 'X';
                    }
                    
                }
            }
            
        }
        return new Node(0,0,-1);
    }
}

class Node {
    int x,y;
    int depth;
    
    Node(int x, int y, int depth){
        this.x= x;
        this.y = y;
        this.depth = depth;
    }
}