import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;
        public static int[][][] open;
        public static int[] process;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int leftDoor = Integer.parseInt(st.nextToken());
        int rightDoor = Integer.parseInt(st.nextToken());


        M = Integer.parseInt(br.readLine());
        open = new int[N+1][N+1][M];
        process = new int[M];

        for(int i =0;i<M;i++){
            int n = Integer.parseInt(br.readLine());
            process[i] = n;
        }

        System.out.println(solve(leftDoor,rightDoor,0));


    }

    public static int solve(int left, int right, int depth){
        if(depth >= M){
            return 0;
        }

        open[left][right][depth] = Math.min(
                 Math.abs(left - process[depth]) + solve(process[depth], right, depth+1 )// 왼쪽으로 갔을 경우
                ,
                Math.abs(right - process[depth]) + solve(left, process[depth], depth+1 )// 오른쪽으로
        );

        return open[left][right][depth];

    }

}
