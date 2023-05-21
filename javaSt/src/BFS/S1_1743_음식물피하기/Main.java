package BFS.S1_1743_음식물피하기;

import java.io.*;
import java.util.*;

public class Main {
    public static int N,M,K,result = 0;
    public static int[][] arr;
    public static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a-1][b-1] = 1;
        }

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    BFS(i,j);
                }

            }
        }

        System.out.println(result);



    }

    public static void BFS(int x, int y){
        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        int ans =0;
        Queue<Trash> q = new LinkedList<>();
        q.add(new Trash(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Trash trash = q.poll();
            for (int i=0;i<4;i++){
                int nx = trash.x + dx[i];
                int ny = trash.y + dy[i];
                if(0<= nx && nx<N && 0<=ny && ny<M && !visited[nx][ny] && arr[nx][ny] ==1){
                    q.add(new Trash(nx,ny));
                    visited[nx][ny] = true;
                    ans ++;
                }
            }
        }
        if(result < ans+1){
            result=ans+1;
        }
    }


}

class Trash{
    int x;
    int y;
    Trash(int x, int y){
       this.x = x;
       this.y = y;
    }
}
