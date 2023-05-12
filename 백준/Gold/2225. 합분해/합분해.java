
import java.io.*;
import java.util.*;

public class Main {
        public static int n,k;
        public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[n+1];


        for(int i=0;i<n+1;i++){
            dp[i] = 1;
        }



        for(int i =1;i<k;i++){
            for (int j=1;j<n+1;j++){
                dp[j] = (dp[j-1] +dp[j]) % 1_000_000_000;
            }
        }

        System.out.println(dp[n]);





    }

}
