
import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;
        public static int[][] wheel;

        public static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        wheel=  new int[4][8];


        for(int i =0;i<4;i++){
            st = new StringTokenizer(br.readLine());
            String num  = st.nextToken();
            for(int j=0;j<8;j++){
                wheel[i][j] = num.charAt(j) - '0';
            }
        }


        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for(int i =0; i<N;i++){
            visited = new int[4];
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            rotate(n-1,m);
        }

        System.out.println(score());

    }
    public static void rotate(int wheelNum, int rotatePosition){

        visited[wheelNum] = 1;
        int left = wheel[wheelNum][6];
        int right = wheel[wheelNum][2];

        tempArr(wheelNum,rotatePosition);
        if(wheelNum -1 >= 0 && wheel[wheelNum-1][2] != left && visited[wheelNum-1] == 0 ){
            rotate(wheelNum - 1, rotatePosition*-1);
        }


        if(wheelNum+1 <=3 && wheel[wheelNum+1][6] != right && visited[wheelNum+1] == 0){
            rotate(wheelNum + 1, rotatePosition*-1);
        }

    }

    public static void tempArr(int wheelNum , int rotatePosition){
        int temp =0;
        if(rotatePosition == -1){
            temp =wheel[wheelNum][0];
            for(int i =0;i<7;i++){
                wheel[wheelNum][i] =wheel[wheelNum][i+1];
            }
            wheel[wheelNum][7] = temp;
        }else{
            temp = wheel[wheelNum][7];
            for(int i=7;i>0;i--){
                wheel[wheelNum][i]  = wheel[wheelNum][i-1];
            }
            wheel[wheelNum][0] = temp;
        }
    }

    public static int score(){
        int score =0;
        for(int i =0;i<4;i++){
            score +=  wheel[i][0] *(int) Math.pow(2,i);
        }
        return score;
    }


}
