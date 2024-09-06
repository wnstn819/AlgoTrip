import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int result =0;
        dp = new int[N+1][N+1];
        for(int i =1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=i;j++){
                dp[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        for(int i=2;i<N+1;i++){
            for(int j=1;j<=i;j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + dp[i][j], dp[i - 1][j - 1] + dp[i][j]);

            }
        }

        for(int j=1;j<N+1;j++){
            result = Math.max(dp[N][j],result);
        }
        System.out.println(result);
    }

}
