

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;
public class Main {
    static int n,t;
    static StringBuilder sb = new StringBuilder();
    static int dp[][] = new int[10001][4];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[1][1]=1;
        dp[1][2]=0;
        dp[1][3]=0;

        dp[2][1]=1;
        dp[2][2]=1;
        dp[2][3]=0;

        dp[3][1]=1;
        dp[3][2]=1;
        dp[3][3]=1;

        for(int i=4; i<=10000; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1]+dp[i-2][2];
            dp[i][3] = dp[i-3][1]+dp[i-3][2]+dp[i-3][3];
        }

        t = Integer.parseInt(br.readLine());

        while(t-- >0) {
            n= Integer.parseInt(br.readLine());
            int sum = dp[n][1]+dp[n][2]+dp[n][3];
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }
}