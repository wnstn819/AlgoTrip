import java.io.*;
import java.util.*;

public class Main {
        public static int N,L,R,result =0;
        static int[][] arr;
        static boolean[][] visited;
        static int[] dx={0,0,1,-1};
        static int[] dy={1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int set = 0;
        while(set != N*N){
            set =0;
           
            visited = new boolean[N][N];
            for(int i=0;i<N;i++){
                for(int j =0;j<N;j++){
                    if(!visited[i][j]){
                        BFS(i,j);
                        set++;
                    }
                }
            }
             result++;

        }


        System.out.println(result-1);



    }

    public static void BFS(int x, int y){
        visited[x][y] = true;
        Queue<City> que = new LinkedList<>();
        Queue<City> cityList = new LinkedList<>();
        que.add(new City(x,y));
        cityList.add(new City(x, y));
        int sum =arr[x][y];
        int count =1;
        while(!que.isEmpty()){
            City ct = que.poll();

            for(int i =0;i<4;i++){
                int nx = ct.x +dx[i];
                int ny = ct.y +dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]){
                    int dif = Math.abs(arr[nx][ny]-arr[ct.x][ct.y]);
                    if( dif >= L && dif <= R){
                        que.add(new City(nx,ny));
                        cityList.add(new City(nx,ny));
                        visited[nx][ny] = true;
                        count++;
                        sum += arr[nx][ny];
                    }
                }
            }
        }
        int avg = sum/count;

        while (!cityList.isEmpty()) {
            City ct = cityList.poll();
            arr[ct.x][ct.y] = avg;
        }


    }

}


class City{
    int x, y;
    City(int x, int y){
        this.x=x;
        this.y=y;
    }
}
