import java.io.*;
import java.util.*;

public class Main {
        public static int n;
        public static long count;
        public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        count =0;
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            count += Math.abs((i+1)-arr[i]);
        }

        System.out.println(count);



    }

}
