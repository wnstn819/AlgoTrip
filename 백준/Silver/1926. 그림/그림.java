import java.io.*;
import java.util.*;

public class Main {
    public static int N,M, maxSize =0, result=0;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];


        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j =0;j<M;j++){
                if(!visited[i][j] && map[i][j] == 1) {
                    BFS(i, j);
                    result++;
                }
            }
        }

        sb.append(result).append("\n");
        sb.append(maxSize);

        System.out.println(sb);


    }

    public static void BFS(int i, int j){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{i,j});
        visited[i][j] = true;
        int sum = 1;
        while (!que.isEmpty()) {
            int[] arr = que.poll();

            for(int k=0;k<4;k++){
                int nx = arr[0] + dx[k];
                int ny = arr[1] + dy[k];

                if(nx >= 0 && nx < N && ny >=0 && ny < M && !visited[nx][ny] && map[nx][ny] == 1){
                    que.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    sum++;
                }

            }



        }
        maxSize = Math.max(sum, maxSize);

    }

}
