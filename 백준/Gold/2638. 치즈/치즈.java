import java.io.*;
import java.util.*;

public class Main {
        public static int N,M,chz=0, result =0;
        static int[][] list, meltMap;

        static int[] dx = {0,0,1,-1};
        static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();



        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new int[N][M];
        meltMap = new int[N][M];

        for(int i = 0 ;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int n = Integer.parseInt(st.nextToken());
                if(n == 1){
                    chz++;
                }
                list[i][j] = n;
            }
        }

        while(chz > 0) {

            meltCheck();
            result++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (list[i][j] == 1) {
                        melting(i,j);
                    }
                }
            }
        }

        System.out.println(result);

    }

    static void meltCheck(){

        boolean[][] visited = new boolean[N][M];
        Queue<Air> que = new LinkedList<>();
        que.add(new Air(0,0));

        visited[0][0] = true;
        meltMap[0][0] = 1;
        while(!que.isEmpty()){
            Air air = que.poll();

            for(int i=0;i<4;i++){
                int nx = air.x + dx[i];
                int ny = air.y + dy[i];
                if(0<=nx && nx<N && 0<=ny && ny<M && !visited[nx][ny] && list[nx][ny] ==0){
                    visited[nx][ny] = true;
                    meltMap[nx][ny] = 1;
                    que.add(new Air(nx,ny));
                }
            }
        }

    }

    static void melting(int x, int y){

        int count =0;
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(meltMap[nx][ny] == 1){
                 count++;
                 if(count >= 2){
                     chz--;
                     list[x][y] = 0;
                     break;
                 }
            }

        }
    }

}

class Air{
    int x, y;
    Air(int x, int y){
        this.x = x;
        this.y = y;
    }
}
