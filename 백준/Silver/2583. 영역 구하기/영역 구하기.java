import java.io.*;
import java.util.*;

public class Main {
        public static int N,M,L,result=0;

        public static int[][] area;
        public static int[] dx, dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        area = new int[N][M];
        dx = new int[]{1,-1,0,0};
        dy = new int[]{0,0,1,-1};

        for(int i =0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            int Fy = Integer.parseInt(st.nextToken());
            int Fx = Integer.parseInt(st.nextToken());
            int Ey = Integer.parseInt(st.nextToken());
            int Ex = Integer.parseInt(st.nextToken());

            for(int j=Fx;j<Ex;j++){
                for(int k = Fy;k<Ey;k++){
                    area[j][k] = 1;
                }
            }

        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(area[i][j] != 1){
                    list.add(BFS(i,j));
                    result++;
                }

            }
        }

        System.out.println(result);
        Collections.sort(list);
        for(int i : list){
            System.out.print(i + " ");
        }
    }

    public static int BFS(int x, int y){
        Queue<Position> que = new LinkedList<>();
        que.add(new Position(x,y));
        area[x][y] = 1;
        int ans =1;
        while(!que.isEmpty()){
            Position ps = que.poll();
            int psx = ps.x;
            int psy = ps.y;
            for(int i=0;i<4;i++){
                int nx = psx + dx[i];
                int ny = psy + dy[i];
                if(nx >=0 && nx < N && ny>=0 && ny < M && area[nx][ny] != 1){
                    que.add(new Position(nx,ny));
                    area[nx][ny] = 1;
                    ans++;
                }
            }
        }
        return ans;
    }


}
class Position{
    int x;
    int y;
    Position(int x, int y){
        this.x= x;
        this.y= y;
    }
}
