package 구현.S4_4396_지뢰찾기;

import java.io.*;
import java.util.*;

public class Main {
        public static int N;
        public static char[][] arr1, arr2;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        arr1 = new char[N][N];
        arr2 = new char[N][N];
        int[] dx = new int[]{1, 1, 1, 0, 0, -1, -1, -1};
        int[] dy = new int[]{-1,0,1,1,-1,-1,0,1};

        for(int i =0;i<N;i++){
            String str = br.readLine();

            for(int j =0;j<N;j++){
                arr1[i][j] = str.charAt(j);
            }
        }

        for(int i =0;i<N;i++){
            String str = br.readLine();
            for(int j =0;j<N;j++){
                arr2[i][j] = str.charAt(j);

            }
        }
        boolean find = false;
        for(int i=0;i<N;i++){
            for(int j =0;j<N;j++){
                if(arr2[i][j] == 'x'){
                    int count =0;
                    for(int z =0;z<8;z++){
                        int nx = i+dx[z];
                        int ny = j+dy[z];
                        if(0<= nx && nx<N && 0<= ny && ny<N && arr1[nx][ny] == '*'){
                            count++;
                        }
                    }

                    if(arr1[i][j]== '*'){
                        find = true;
                    }
                    arr2[i][j]= (char)(count+'0');
                }
            }
        }


        for(int i=0;i<N;i++){

            for(int j=0;j<N;j++){
                if(find && arr1[i][j] == '*'){
                    System.out.print(arr1[i][j]);
                }else{
                    System.out.print(arr2[i][j]);
                }

            }
            System.out.println();
        }


    }

}
