package 구현.G5_14503_로봇청소기;

import java.io.*;
import java.util.*;

public class Main {
        static int N,M,result,sX,sY,location;
        static boolean check;
        static int[][] arr;
        static int[] dx = {-1,0,1,0};
        static int[] dy = {0,1,0,-1};


    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = 0;
        check = true;
        st = new StringTokenizer(br.readLine());

        sX = Integer.parseInt(st.nextToken());
        sY = Integer.parseInt(st.nextToken());
        location = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i =0 ;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (check){
            if(arr[sX][sY] == 0){
                arr[sX][sY] = 2;
                result ++;
            }
            int test=0;
            for ( int i=0;i<4;i++){

                int nx = sX+dx[i];
                int ny = sY+dy[i];
                if (0<=nx && nx < N && 0<=ny && ny<M && arr[nx][ny] ==0){
                        test++;
                }

            }
            if (test >0){

                rotate(location);
                if (0 <= sX + (dx[location]) && sX + (dx[location]) < N && 0 <= sY + (dy[location]) && sY + (dy[location]) < M && arr[sX+dx[location]][sY+dy[location]] == 0) {
                    move(sX + dx[location], sY + dy[location]);
                }

            }else{
                    if (0 <= sX + (dx[location] * -1) && sX + (dx[location] * -1) < N && 0 <= sY + (dy[location] * -1) && sY + (dy[location] * -1) < M && arr[sX+(dx[location])*-1][sY+(dy[location]*-1)] != 1) {
                        move(sX + dx[location] * -1, sY +dy[location] * -1);
                    } else {
                        System.out.println(result);
                        return;
                    }

            }





        }







    }
    public static void move(int x, int y){
            sX = x;
            sY = y;
    }

    public static void rotate(int num) {
        switch (num) {
            case 0:
                location = 3;
                break;
            case 1:
                location = 0;
                break;
            case 2:
                location = 1;
                break;
            case 3:
                location = 2;
                break;

        }
    }

}
