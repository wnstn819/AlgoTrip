import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;
        public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        N = Integer.parseInt(st.nextToken());
        arr = new int[N][3];



        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<3;j++){
                if(i==0){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }else{
                    int num = Integer.parseInt(st.nextToken());

                    int a = arr[i-1][0];
                    int b = arr[i-1][1];
                    int c = arr[i-1][2];

                    arr[i][j] = num + Math.min(Math.min(j != 0 ? a:Integer.MAX_VALUE, j != 1? b : Integer.MAX_VALUE), j != 2 ? c: Integer.MAX_VALUE);
                }

            }
        }


        System.out.println(Math.min(Math.min(arr[N-1][0],arr[N-1][1]),arr[N-1][2]));

    }

}
