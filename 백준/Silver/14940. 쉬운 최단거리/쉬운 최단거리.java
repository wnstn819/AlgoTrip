import java.io.*;
import java.util.*;


class Locate{
    int x;
    int y;
    int depth;
    Locate(int x,int y,int depth){
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}
public class Main {
        public static int N,M;
        public static int[][] arr;
        public static Queue<Locate> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int n = Integer.parseInt(st.nextToken());
                if(n == 2){
                    queue.add(new Locate(i,j,0));
                    arr[i][j] = 0;
                }else if(n == 0){
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = -1;
                }

            }
        }

        BFS();


        for(int[] i : arr){
            for(int j: i){
                sb.append(j).append(" ");

            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void BFS(){
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};


        while(!queue.isEmpty()){
            Locate temp = queue.poll();
            int x = temp.x;
            int y = temp.y;
            int depth = temp.depth;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<= nx && nx<N && 0<=ny && ny<M && arr[nx][ny] == -1){
                    arr[nx][ny] = depth+1;
                    queue.add(new Locate(nx,ny,depth+1));
                }
            }

        }
    }

}
