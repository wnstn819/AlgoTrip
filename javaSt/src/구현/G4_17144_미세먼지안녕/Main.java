package 구현.G4_17144_미세먼지안녕;

import java.io.*;
import java.util.*;

public class Main {
    public static int R, C, T, filterX, filterY,result;
    public static int[][] arr, box;
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        box = new int[R][C];
        result =0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    filterX = i;
                    filterY = j;
                }
            }
        }

        for (int t = 0; t < T; t++) { // 시간

            for (int i = 0; i < R; i++) { //확산
                for (int j = 0; j < C; j++) {
                    if (arr[i][j] / 5 >= 1) {
                        int count = 0;
                        for (int z = 0; z < 4; z++) {
                            int nx = i + dx[z];
                            int ny = j + dy[z];
                            if (0 <= nx && nx < R && 0 <= ny && ny < C && arr[nx][ny] != -1) {
                                box[nx][ny] += arr[i][j] / 5;
                                count++;
                            }
                        }
                        arr[i][j] = arr[i][j] - (arr[i][j] / 5 * count);
                    }
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    arr[i][j] += box[i][j];
                    box[i][j] = 0;
                }
            }
            int x = filterX - 2; //filterX = 4
            int y = filterY;     //filterY = 0
            int location = 0;
            while (true) {

                int nx = x + dx[location];
                int ny = y + dy[location];
                if (0 <= nx && nx <= filterX - 1 && 0 <= ny && ny < C) {
                    if (arr[nx][ny] == -1) {
                        arr[x][y] = 0;
                        break;
                    } else {
                        arr[x][y] = arr[nx][ny];
                    }


                } else {
                    location++;
                    nx = x + dx[location];
                    ny = y + dy[location];
                    arr[x][y] = arr[nx][ny];


                }
                x += dx[location];
                y += dy[location];


            }
            x = filterX + 1;
            y = filterY;
            location = 0;
            while (true) {

                int nx = x + dx[location]*-1;
                int ny = y + dy[location];
                if (filterX <= nx && nx < R && 0 <= ny && ny < C) {
                    if (arr[nx][ny] == -1) {
                        arr[x][y] = 0;
                        break;
                    } else {
                        arr[x][y] = arr[nx][ny];
                    }


                } else {

                    location++;
                    nx = x + dx[location]*-1;
                    ny = y + dy[location];
                    arr[x][y] = arr[nx][ny];


                }
                x += dx[location]*-1;
                y += dy[location];


            }


        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result+=arr[i][j];
            }
        }

        for(int i=0;i<R;i++){
            System.out.println();
            for(int j = 0; j< C;j++){
                System.out.print(arr[i][j] + " ");
            }
        }

        System.out.println(result+2);




    }


}

