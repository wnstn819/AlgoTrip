package 구현.G5_21608_상어초등학교;

import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[][] arr, student,student2;
    public static boolean[] seat;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        seat = new boolean[N * N + 1];
        arr = new int[N][N];
        student = new int[N * N + 1][5];
        student2 = new int[N * N + 1][5];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};


        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int num1=Integer.parseInt(st.nextToken());
            int num2=Integer.parseInt(st.nextToken());
            int num3=Integer.parseInt(st.nextToken());
            int num4=Integer.parseInt(st.nextToken());
            int num5=Integer.parseInt(st.nextToken());

            student[i][0] = num1;
            student[i][1] = num2;
            student[i][2] = num3;
            student[i][3] = num4;
            student[i][4] = num5;

            student2[num1][0] =num1;
            student2[num1][1] =num2;
            student2[num1][2] =num3;
            student2[num1][3] =num4;
            student2[num1][4] =num5;


        }


        for (int v = 0; v < N * N; v++) {
            int x = 0;
            int y = 0;
            int maxScore = 0;
            int emptyMaxScore = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int score = 0;
                    int emptyScore = 0;
                    if (arr[i][j] != 0) {
                        continue;
                    }
                    for (int z = 0; z < 4; z++) {
                        int nx = i + dx[z];
                        int ny = j + dy[z];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                            if (arr[nx][ny] == student[v][1] || arr[nx][ny] == student[v][2] || arr[nx][ny] == student[v][3] || arr[nx][ny] == student[v][4]) {
                                score++;
                            }
                            if (arr[nx][ny] == 0) {
                                emptyScore++;
                            }
                        }
                    }
                    if (score > maxScore) {
                        x = i;
                        y = j;
                        maxScore = score;
                        emptyMaxScore = emptyScore;
                    } else if (score == maxScore) {
                        if (emptyScore > emptyMaxScore) {
                            x = i;
                            y = j;
                            emptyMaxScore = emptyScore;
                        }
                    }
                    if(arr[x][y] !=0){
                        x=i;
                        y=j;
                    }
                }
            }
            arr[x][y] = student[v][0];
        }




        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int score = 0;
                for (int z = 0; z < 4; z++) {
                    int nx = i + dx[z];
                    int ny = j + dy[z];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        if (arr[nx][ny] == student2[arr[i][j]][1] || arr[nx][ny] == student2[arr[i][j]][2] || arr[nx][ny] == student2[arr[i][j]][3] || arr[nx][ny] == student2[arr[i][j]][4]) {
                            score++;
                        }
                    }

                }
                if (score == 0) {
                    result += 0;
                } else if (score == 1) {
                    result += 1;
                } else if (score == 2) {
                    result += 10;
                } else if (score == 3) {
                    result += 100;
                } else {
                    result += 1000;
                }
            }


        }

        System.out.println(result);
    }

}
