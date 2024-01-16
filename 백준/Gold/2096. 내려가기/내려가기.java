import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;

        static int[][] arr;
        static int[][] maxDp, minDp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());

        arr = new int[N][3];
        maxDp = new int[N][3];
        minDp = new int[N][3];

        for(int[] list : minDp){
            Arrays.fill(list,Integer.MAX_VALUE);
        }


        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                int num = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    minDp[i][j] = num;
                    maxDp[i][j] = num;
                }
                arr[i][j] = num;
            }
        }

        for(int i =1;i<N;i++){
           for(int j =0; j<3;j++){
               if(j ==0){
                   maxDp[i][j] = Math.max(maxDp[i-1][j],maxDp[i-1][j+1]) + arr[i][j];
                   minDp[i][j] = Math.min(minDp[i-1][j],minDp[i-1][j+1]) + arr[i][j];
               }else if( j == 1){
                   maxDp[i][j] =Math.max(Math.max(maxDp[i-1][j],maxDp[i-1][j+1]),maxDp[i-1][j-1]) + arr[i][j];
                   minDp[i][j] =Math.min(Math.min(minDp[i-1][j],minDp[i-1][j+1]),minDp[i-1][j-1]) + arr[i][j];
               }else{
                   maxDp[i][j] = Math.max(maxDp[i-1][j],maxDp[i-1][j-1]) + arr[i][j];
                   minDp[i][j] = Math.min(minDp[i-1][j],minDp[i-1][j-1]) + arr[i][j];
               }


           }
        }


        int n = Math.max(Math.max(maxDp[N - 1][0], maxDp[N - 1][1]), maxDp[N - 1][2]);
        int m = Math.min(Math.min(minDp[N - 1][0], minDp[N - 1][1]), minDp[N - 1][2]);

        System.out.println(n + " " +m);



    }

}
