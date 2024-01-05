import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;
        static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr[n-1][m-1] = 1;
            arr[m-1][n-1] = -1;
        }

        for(int k=0;k<N;k++){
            for(int  i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(arr[i][k] == arr[k][j] && arr[i][k]!=0)
                        arr[i][j] = arr[i][k];
                }
            }
        }

        for(int  i=0;i<N;i++){
            int count =1;
            for(int j=0;j<N;j++){
                if(arr[i][j] !=0){
                    count++;
                }
            }
            System.out.println(N-count);
        }

    }

}
