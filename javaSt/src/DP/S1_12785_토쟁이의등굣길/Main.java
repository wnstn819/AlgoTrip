package DP.S1_12785_토쟁이의등굣길;


import java.io.*;
import java.util.*;

public class Main {
        public static int N,M,x,y;
        public static int[] dx,dy;
        public static long[][] dp;



    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        dp = new long[M][N];
        for (int i=0;i<M;i++){
            dp[i][0] =1;
        }
        for (int i=1;i<N;i++){
            dp[0][i] = 1;
        }
        
        for(int i =1;i<M;i++){
            for(int j=1;j<N;j++){
                dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1000007;
            }
        }
        for(int i=0;i<M;i++){
            System.out.println();
            for(int j =0;j<N;j++){
                System.out.print(dp[i][j] + " ");
            }
        }
        System.out.println(dp[y-1][x-1]*dp[M-y][N-x] % 1000007);

    }

}
