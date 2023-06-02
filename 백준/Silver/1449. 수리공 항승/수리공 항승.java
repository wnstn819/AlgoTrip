import java.io.*;
import java.util.*;

public class Main {
        public static int N,L,result =0;
        public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i <N;i++){
            arr[i] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(arr);
        double start =arr[0]-0.5;
        double end =start+L;

        result = 1;
        for(int i:arr){
            if( i>=start && i<=end){
                continue;
            }else{
                start = i-0.5;
                end= start+L;
                result++;
            }
        }

        System.out.println(result);






    }

}
