import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;
        public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i =1;i<N+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        for(int  i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boolean check = true;
            while(a <= b){
                if(arr[a] != arr[b]){
                    check = false;
                    break;
                }else{
                    a++;
                    b--;
                }
            }
            if(check){
                sb.append("1\n");
            }else{
                sb.append("0\n");
            }
        }

        System.out.println(sb);

    }

}
