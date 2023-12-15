import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;
        public static int[][] map;

        public static String result="YES";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i == j){
                    map[i][j] = 1;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        Queue<Integer> que = new LinkedList<>();

        while(st.hasMoreTokens()){
            que.add(Integer.parseInt(st.nextToken()));
        }

        int[] arr = new int[que.size()];


        for(int k =0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j =0;j<N;j++){
                    if(map[i][k] == 1 && map[k][j] == 1){
                        map[i][j] = 1;
                    }
                }
            }
        }

        int num = que.size();
        int count = 0;
        int start = 0;
        while(!que.isEmpty()){
            arr[count] = que.poll()-1;
            if(count ==0) start = arr[count];
            count++;
        }

        for(int i =1;i<num;i++){
                if(map[start][arr[i]] == 0){
                    result="NO";
                }


        }

        System.out.println(result);


    }

}
