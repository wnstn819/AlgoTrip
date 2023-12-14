import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
        public static int N,M,R,result=0;
        static int[][] map;
        static int[] dx = {0,0,1,-1};
        static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayList<Road>[][] road;
        N = Integer.parseInt(st.nextToken()); // 크기
        M = Integer.parseInt(st.nextToken()); // 소 마리 수
        R = Integer.parseInt(st.nextToken()); // 길 수

        map = new int[N+1][N+1];
        road = new ArrayList[N+1][N+1];

        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                road[i][j] = new ArrayList<>();
            }
        }



        for(int i =0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            road[x1][y1].add(new Road(x2,y2));
            road[x2][y2].add(new Road(x1,y1));
        }

        Queue<Road> que = new LinkedList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            que.add(new Road(a,b));
            map[a][b] = 1;
        }

        bfs(que,road);


        System.out.println(result/2);




    }
    public static void bfs(Queue<Road> que, ArrayList<Road>[][] road){
        while(!que.isEmpty()){
            Road cow = que.poll();
            Queue<Road> next = new LinkedList<>();
            boolean[][] visited = new boolean[N+1][N+1];
            next.add(cow);
            visited[cow.x][cow.y] = true;
            int count =0;
            while(!next.isEmpty()){
                Road go = next.poll();
                for(int i=0;i<4;i++){
                    int nx = go.x+dx[i];
                    int ny = go.y+dy[i];
                    if(0<nx && nx < N+1 && 0<ny && ny<N+1 && !visited[nx][ny] ){

                        if(road[go.x][go.y].contains(new Road(nx,ny))){
                           continue;
                        }
                        if(map[nx][ny] == 1){
                            count++;
                        }
                        visited[nx][ny] = true;
                        next.add(new Road(nx,ny));
                    }
                }

            }
            result += ((M - 1) - count);

        }
    }



}
class Road{
    int x;
    int y;
    Road(int x , int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Road node = (Road) obj;

        return this.x == node.x && this.y == node.y;
    }
}
