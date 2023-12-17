import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;
        public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];

        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            if(arr[n][m] == 0){
                arr[n][m] = value;
            }else{
                arr[n][m] =  Math.min(value,arr[n][m]);
            }
        }

        for(int k = 1; k<=N;k++){
            for(int i= 1; i<=N ; i++ ){
                for(int j= 1;j<=N;j++){
                    if (i != j && arr[i][k] != 0 && arr[k][j] != 0) {
                        if(arr[i][j] ==0){
                            arr[i][j] = arr[i][k] + arr[k][j];
                        }else{
                            arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
                        }

                    }
                }
            }
        }

      for(int i =1;i<=N;i++){

          for(int j=1; j<=N;j++){
              System.out.print(arr[i][j]+ " ");
          }
          System.out.println();
      }


    }

}
