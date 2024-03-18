import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long[] arr = new long[n];
            for(int j=0;j<n;j++){
                arr[j] = Long.parseLong(st.nextToken());
            }

            long max = arr[n-1];
            long sum =0;
            for(int j=n-2;j>=0;j--){
                if(arr[j] > max){
                    max = arr[j];
                }else{
                    sum += max-arr[j];
                }


            }
            System.out.println(sum);
        }


    }

}
