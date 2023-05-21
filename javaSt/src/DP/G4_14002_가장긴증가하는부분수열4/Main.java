package DP.G4_14002_가장긴증가하는부분수열4;

import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] arr,depth,dp;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[N];
        depth= new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = i;
        }


        Arrays.fill(depth,1);


        for(int i =1;i<N;i++){
            for(int j=i;j>0;j--){
                if (arr[i] > arr[j-1]){
                    if(depth[i] <= depth[j-1]){
                        depth[i] = depth[j-1] +1;
                        dp[i] = j-1;
                    }


                }
            }
        }


        int max =0;
        int maxI = 0;
        for(int i=0;i<N;i++){
            if(max<=depth[i]){
                max = depth[i];
                maxI = i;
            }
        }
        System.out.println(max);

        while(max>0){
            sb.insert(0,arr[maxI] + " ");
            maxI= dp[maxI];
            max--;
        }

        System.out.println(sb);


    }

}
