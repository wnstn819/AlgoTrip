package 구현.G4_14500_테트로미노;

import java.io.*;
import java.util.*;

public class Main {
        public static int N,M, result = Integer.MIN_VALUE;
        public static int[][] arr;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();



        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];


        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =0;i<N;i++){
            for(int j=0;j<M;j++){
                checkOne(i,j,0,1,0,2,-1,2);
                checkOne(i,j,0,1,-1,1,-1,2);
                checkOne(i,j,0,1,1,1,0,2);
                checkOne(i,j,0,1,0,2,0,3);
                checkOne(i,j,0,1,1,1,1,0);
            }
        }

        System.out.println(result);







    }

    public static void checkOne(int i,int j, int x1, int y1, int x2, int y2, int x3, int y3){
        int[] dx=new int[]{i,i+x1,i+x2,i+x3};
        int[] dy=new int[]{j,j+y1,j+y2,j+y3};
        int[] changeX= new int[]{-1,1,-1,1};
        int[] changeY= new int[]{1,-1,1,-1};

        for(int k =0;k<4;k++){
            int ans=0;
            for(int v =0;v<4;v++){
                if(0<= dx[v] && dx[v] <N && 0<= dy[v] && dy[v]< M) {
                    ans += arr[dx[v]][dy[v]];
                    dx[v] = dx[v]*changeX[v];
                    dy[v] = dy[v]*changeY[v];
                }


            }
            if(ans > result){
                result = ans;
            }

        }

        for(int k =0;k<4;k++){
            int ans=0;
            for(int v =0;v<4;v++){
                if(0<= dx[v] && dx[v] <M && 0<= dy[v] && dy[v]< N) {
                    ans += arr[dy[v]][dx[v]];
                    dx[v] = dx[v]*changeX[v];
                    dy[v] = dy[v]*changeY[v];
                }
            }
            if(ans > result){
                result = ans;
            }

        }

    }

}
