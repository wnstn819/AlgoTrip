package 이진탐색.S3_2512_예산;

import java.io.*;
import java.util.*;

public class Main {
    public static int N,M,result;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        binary(0,arr[N-1],M);

        System.out.println(result);

    }

    public static void binary(int start, int end , int goal){

        int mid = (start + end) / 2;
        if(start > end){
            result = mid;
            return;
        }
        int sum =0;
        for(int i : arr){
            if (i>mid){
                sum+=mid;
            }else{
                sum+=i;
            }
        }
        if(goal >= sum){
            binary(mid+1,end,goal);
        }else{
            binary(start,mid-1,goal);
        }




    }

}
