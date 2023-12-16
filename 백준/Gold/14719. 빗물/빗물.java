import java.io.*;
import java.util.*;

public class Main {
        public static int N,M,result =0;

        public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];


        st = new StringTokenizer(br.readLine());

        for(int  i=0;i<M;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1;i<M;i++){
            int left = i;
            int right = i;

            int leftValue =0;
            int rightValue =0;
            while(left >=0){
                leftValue = Math.max(leftValue,arr[left]);
                left--;
            }

            while(right <M){
                rightValue = Math.max(rightValue,arr[right]);
                right++;
            }
            result += (Math.min(leftValue,rightValue) - arr[i] );
        }


        System.out.println(result);


    }

}
