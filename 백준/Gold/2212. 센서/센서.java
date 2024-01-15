import java.io.*;
import java.util.*;

public class Main {
        public static int N,M,result =0;
        static int[] arr,diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();



        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        arr = new int[N];
        diff = new int[N-1];

        st = new StringTokenizer(br.readLine());

        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0;i<N-1;i++){
            diff[i] = arr[i+1] - arr[i];
        }

        Arrays.sort(diff);


        if(M < N){
            for(int i =0;i<N-M;i++){
                result+= diff[i];
            }
        }

        System.out.println(result);






    }

}
