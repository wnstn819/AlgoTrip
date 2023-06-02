import java.io.*;
import java.util.*;

public class Main {
        public static int N,M,result=Integer.MAX_VALUE;
        public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];


        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String str= st.nextToken();
            for(int j=0;j<M;j++){
                if(str.charAt(j) == 'W'){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = 0;
                }

            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(i+7<N && j+7<M){
                    result = Math.min(result,check(i,j));
                }

            }

        }

        System.out.println(result);


    }

    public static int check(int x,int y){

        int zero =0;
        int one =0;
        for(int i=x;i<x+8;i++){
            for(int j=y;j<y+8;j++){
                if((i+j) % 2 == 0){
                    if(arr[i][j] == 1){
                        zero++;
                    }
                }else{
                    if(arr[i][j] == 0){
                        zero++;

                    }
                }

                if((i+j) % 2 ==0){
                    if(arr[i][j] == 0){
                        one++;
                    }

                }else{
                    if(arr[i][j] ==1){
                        one++;
                    }
                }

            }
        }

        return Math.min(zero,one);
    }

}
