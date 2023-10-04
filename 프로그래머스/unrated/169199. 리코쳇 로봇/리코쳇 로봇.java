import java.util.*;
class Solution {
    
        static int[] dx = {1,-1,0,0};
        static int[] dy = {0,0,1,-1};
        static int boardX, boardY, resultX, resultY;
        static boolean[][] visited;
        static int[][] arr;
    public int solution(String[] board) {
        int answer = -1;
        
        boardX = board.length;
        boardY = board[0].length();
        
        arr = new int[boardX][boardY];
        visited = new boolean[boardX][boardY];
        Queue<Robot> que = new LinkedList<>();
        
        for(int i =0;i<boardX;i++){
            for(int j=0;j<boardY;j++){
                switch(board[i].charAt(j)){
                    case '.':
                        arr[i][j] = 0;
                        break;
                    case 'D':
                        arr[i][j] = -1;
                        break;
                    case 'R':
                        arr[i][j] = 1;
                        que.add(new Robot(i,j,0));
                        visited[i][j] = true;
                        break;
                    case 'G':
                        arr[i][j] = 2;
                        resultX= i;
                        resultY = j;
                        break;
                }
            }
        }
        
        int check=0;
        
        while(!que.isEmpty()){
            Robot rob = que.poll();
            
            for(int i =0;i<4;i++){
                Robot nextR = getRobot(i,rob);
                
                if(!visited[nextR.x][nextR.y]){
                    que.add(nextR);
                    visited[nextR.x][nextR.y] = true;
                }
                
                if(arr[nextR.x][nextR.y] == 2){
                    answer = nextR.depth;
                    check = 1;
                    break;
                }
            }
            
            if(check == 1){
                break;
            }
            
        }
        
        return answer;
    }
    
    public Robot getRobot(int x, Robot robot){
        
        int nx = robot.x ;
        int ny = robot.y ;
        
        while(0 <= nx +dx[x]&& nx+dx[x] < boardX && 0<=ny + dy[x] && ny + dy[x]< boardY && arr[nx+dx[x]][ny+dy[x]] != -1){
            nx += dx[x];
            ny += dy[x];
        }
        
        return new Robot(nx,ny,robot.depth +1 );    
        
        
        
    }
    
    class Robot{
        int x;
        int y;
        int depth;
        
        Robot(int x ,int y, int depth){
            this.x=x;
            this.y=y;
            this.depth=depth;
        }
        
    }
}