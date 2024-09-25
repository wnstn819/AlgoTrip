import java.io.*;
import java.util.*;

public class Main {
    public static int N, M, result1 = 0, result2=0;
    public static int[][] map;
    public static boolean[][] visited1, visited2;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();



        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0;j<N;j++){
                char color = str.charAt(j);
                map[i][j] = color == 'R' ? 1 : color == 'G' ? 2 : 4 ;
            }
        }

        for(int i =0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited1[i][j]){
                    BFS(i,j,visited1,1);
                    result1++;
                }
                if(!visited2[i][j]){
                    BFS(i,j,visited2,2);
                    result2++;
                }
            }

        }


        System.out.println(result1 + " " + result2);
    }

    public static void BFS(int i, int j,boolean[][] visited, int type){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{i,j});
        visited[i][j] = true;

        while(!que.isEmpty()){
            int[] arr = que.poll();

            for(int k=0;k<4;k++){
                int nx = arr[0] + dx[k];
                int ny = arr[1] + dy[k];
                if(nx >=0 && nx < N && ny >=0 && ny < N && !visited[nx][ny] && (type ==2 ? Math.abs(map[i][j] - map[nx][ny]) < 2  :  map[i][j] == map[nx][ny])){

                    que.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }


    }
}

