package 추가문제.S1_1303_전쟁전투;

import java.io.*;
import java.util.*;
class Location{
    int x;
    int y;

    Location(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
        public static int N,M;
        public static int[][] arr;
        public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                if(str.charAt(j)== 'W'){
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = 1;
                }
            }
        }
        int resultW = 0;
        int resultB = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]){
                    if(arr[i][j] == 1){
                       int w = BFS(i,j,1);
                       resultW+= Math.pow(w,2);
                    }else{
                       int b = BFS(i,j,0);
                       resultB+= Math.pow(b,2);
                    }

                }

            }
        }

        System.out.print(resultB + " " + resultW);

    }

    public static int BFS(int x, int y,int team){
        Deque<Location> deque = new ArrayDeque<>();
        deque.add(new Location(x,y));
        visited[x][y]=true;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int ans =0;
        while(!deque.isEmpty()){
            Location loc = deque.pollFirst();
            ans++;

            for(int i=0;i<4;i++){
                int nx = loc.x + dx[i];
                int ny = loc.y + dy[i];
                if(0<=nx && nx<N && 0<= ny && ny<M && !visited[nx][ny] && arr[nx][ny] == team){
                    visited[nx][ny] = true;
                    deque.addLast(new Location(nx,ny));
                }

            }

        }
        return ans;
    }

}
