package DP.S2_1912_연속합;

import java.io.*;
import java.util.*;

public class Main {
        public static int N;
        public static Integer[] arr;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());

        arr = new Integer[N];

        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for(int i=1;i<N;i++){
            int n = Integer.parseInt(st.nextToken());
            if(arr[i-1] + n <=0){
                arr[i] = n;
            }else{
                if(arr[i-1] + n < n){
                    arr[i] = n;
                }else{
                    arr[i] = arr[i-1] + n;
                }

            }

        }

        Arrays.sort(arr,Collections.reverseOrder());
        System.out.println(arr[0]);



    }

}
