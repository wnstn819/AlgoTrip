import java.io.*;
import java.util.*;


public class Main {
    public static int N,M,result=Integer.MAX_VALUE;
    public static Integer[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new Integer[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int p1 = 0;
        int p2 = 0;

        while(p1<=p2 && p2<N){
            int ans = arr[p2]-arr[p1];
            if(ans >= M){
                result = Math.min(result, ans);
                p1++;
            }else{
                p2++;
            }

        }

        System.out.println(result);






    }

}
