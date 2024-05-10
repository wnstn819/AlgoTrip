import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;
        public static long result=1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int[] dp = new int[N+1];


        if(N< 2){
            dp[0] = 1;
            dp[1] = 1;
        }else{
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
        }


        for(int i=3;i<=N;i++){
            dp[i] = dp[i-1]+ dp[i-2];
        }




        M = Integer.parseInt(br.readLine());
        int start =0;
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(br.readLine());
            result *= dp[num-start-1];
            start = num;
        }
        result *=dp[N-start];

        System.out.println(result);

    }

}
