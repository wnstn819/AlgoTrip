import java.io.*;
import java.util.*;

public class Main {
    public static int N,M,K,result=0;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j =0;j<M;j++){
                map[i][j] = str.charAt(j) == '.' ? 0 : 1;
                visited[i][j] = map[i][j] == 1 ? true : false;
            }
        }


        visited[N-1][0] = true;
        DFS(N-1,0,1);

        System.out.println(result);


    }


    public static void DFS(int x , int y, int depth){

        if (x == 0 && y == M-1) {
            if (depth == K) {
                result++;
            }
            return;
        }


        for(int i =0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                DFS(nx, ny, depth + 1);
                visited[nx][ny] = false;
            }
        }


    }

}
