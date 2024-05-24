import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();



        N = Integer.parseInt(st.nextToken());

        int[] dp = new int[N+1];
        int[][] schedule = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=N-1;i>=0;i--){
            //i가
            if(schedule[i][0] + i > N ){
                dp[i] = dp[i+1];
            }else {
                dp[i] = Math.max(dp[i+1], schedule[i][1] + dp[i + schedule[i][0]]);
            }
        }

        System.out.println(dp[0]);


    }

}
