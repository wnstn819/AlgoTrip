import java.io.*;
import java.util.*;

public class Main {
        static int N,M,result;
        static int[][] map;
        static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new int[N];

        result =Integer.MAX_VALUE;

        for(int i = 0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k =0;k<N;k++){ // 거쳐서 가는 숫자 
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==j) continue;
                    // i에서 j로 가는 거리 중에서 k를 거쳐서 갈 때 가장 작은 숫자를 맵에 초기화
                    map[i][j] = Math.min(map[i][j],map[i][k] + map[k][j]);
                }
            }
        }

        visited[M] = 1;
        dfs(M,0,0);

        System.out.println(result);

    }

    public static void dfs(int start, int sum,int depth){
       if(depth == N-1){
           result = Math.min(result,sum);
           return;
       }

        for(int i =0;i<N;i++){
            if(visited[i] != 1){
                visited[i] = 1;
                dfs(i,sum+map[start][i],depth+1);
                visited[i] = 0;
            }

        }

    }

}
