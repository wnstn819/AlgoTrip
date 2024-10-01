import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        int[] dp = new int[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());


        }


        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));


        for(int i=0;i<N;i++) {
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if(arr[i][1] > arr[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i=0; i<N;i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(N-max);



    }

}
