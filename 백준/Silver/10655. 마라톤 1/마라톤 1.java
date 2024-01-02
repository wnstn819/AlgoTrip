import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;
        static int result = Integer.MAX_VALUE;
        static GPS[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        arr = new GPS[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr[i] = new GPS(n,m);

            if(i>0){
                M += Math.abs(arr[i-1].x - n) + Math.abs(arr[i-1].y - m);
            }

        }

        //DFS(0,1,0);

        for(int i=1;i<N-1;i++){

            result = Math.min(result,M+calDis(i));

        }

        System.out.println(result);

    }
    public static int calDis(int i){
        // i-1 -> i
        int one = Math.abs(arr[i-1].x - arr[i].x) + Math.abs(arr[i-1].y - arr[i].y);

        // i -> i+1

        int two = Math.abs(arr[i].x - arr[i+1].x) + Math.abs(arr[i].y - arr[i+1].y);
        // i-1 -> i +1

        int three = Math.abs(arr[i-1].x - arr[i+1].x) + Math.abs(arr[i-1].y - arr[i+1].y);
        return three - one - two ;


    }

}

class GPS{
    int x,y;

    GPS(int x, int y){
        this.x=x;
        this.y=y;
    }
}
