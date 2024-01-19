import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;
        static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp= new int[M+1];

        for(int i =0;i<N;i++){
            int n = Integer.parseInt(br.readLine());
            for(int j=1;j<=M;j++){
                if (j - n > 0) {
                    dp[j] = dp[j] + dp[j-n];
                } else if (j - n == 0) {
                    dp[j]++;
                }

            }
        }

        System.out.println(dp[M]);

    }

}
