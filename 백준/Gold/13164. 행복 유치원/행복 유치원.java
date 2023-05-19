import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;
        public static Integer[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new Integer[N];
        dp = new Integer[N];
        st = new StringTokenizer(br.readLine());
        Arrays.fill(dp,0);
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i>0){
                dp[i-1] = arr[i] - arr[i-1];
            }
        }
        Arrays.sort(dp,Collections.reverseOrder());

        int result =0;
        for(int i=M-1 ;i<N;i++){
            result+=dp[i];
        }

        System.out.println(result);










    }

}

