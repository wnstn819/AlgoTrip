package 추가문제.S1_2343_기타레슨;

import java.io.*;
import java.util.*;

public class Main {
        public static int N,M,result=Integer.MAX_VALUE;
        public static int[] arr;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr=  new int[N];


        st = new StringTokenizer(br.readLine());

        int start =0;
        int end = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            end += arr[i];
            if (start < arr[i]) {
                start = arr[i];
            }
        }

        while(start<=end){
            int mid = (start+end)/2;
            int lay = 1;
            int ans = 0;
            for(int i=0;i<N;i++) {
                if(ans + arr[i] > mid){
                    lay++;
                    ans = 0;
                }
                ans += arr[i];
            }

            if(lay > M ){
                start = mid+1;

            }else{
                end = mid-1;
            }

        }

        System.out.println(start);


    }

}
