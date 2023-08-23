package 추가문제.S2_1654_랜선자르기;

import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long sum =0;
        int[] arr = new int[N];
        for (int i =0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            if(sum<arr[i]){
                sum = arr[i];
            }
        }

        long start =0;
        sum ++;
        long mid = 0;
        while(start<sum){

            mid = (start +sum)/2;

            long ans = 0;
            for(int i: arr){
                ans += (i/mid);
            }

            if(ans < M){
               sum = mid;
            }else{
                start = mid+1;
            }
        }

        System.out.println(start-1);





    }

}
