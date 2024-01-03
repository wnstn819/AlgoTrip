import java.io.*;
import java.util.*;

public class Main {
        public static int N,M,K;
        public static int[][] arr, arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        arr2 = new int[N][M];
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String stx = st.nextToken();
            for(int j=0;j<M;j++){

                if(stx.charAt(j) == 'O'){
                    arr[i][j] = 1;
                    for(int k=0;k<4;k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(nx>=0 && nx<N && ny>=0 && ny<M && arr[nx][ny] == 0){
                            arr[nx][ny] = 2;
                        }
                    }

                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j =0;j<M;j++){
                if(arr[i][j] == 0){
                    arr2[i][j] = 1;
                    for(int k=0;k<4;k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(nx>=0 && nx<N && ny>=0 && ny<M && arr2[nx][ny] == 0){
                            arr2[nx][ny] = 2;
                        }
                    }
                }
            }
        }


        if(K == 1){
         for(int i=0;i<N;i++){
             for(int j=0;j<M;j++){
                 if(arr[i][j] == 1){
                     System.out.print("O");
                 }else{
                     System.out.print(".");
                 }
             }
             System.out.println();
         }
        }
        else if(K%2 == 0){
            for(int i=0;i<N;i++){
                for(int j =0;j<M;j++){
                    System.out.print("O");
                }
                System.out.println();
            }
        }else {
            if(K%4 == 1){
                for(int i=0;i<N;i++){
                    for(int j =0;j<M;j++){
                        if(arr2[i][j] == 0){
                            System.out.print("O");
                        }else{
                            System.out.print(".");
                        }

                    }
                    System.out.println();
                }
            }else{
                for(int i=0;i<N;i++){
                    for(int j =0;j<M;j++){
                        if(arr2[i][j] == 1){
                            System.out.print("O");
                        }else{
                            System.out.print(".");
                        }
                    }
                    System.out.println();
                }
            }
        }



    }

}
