import java.io.*;
import java.util.*;


class Locate{
    int x;
    int y;
    Locate(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
        public static int N,M,result =0,minus=0;
        public static int[][] tomato;
        public static Deque<Locate> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tomato = new int[M][N];
        deque = new ArrayDeque<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                tomato[i][j] = num;
                if(num == 1){
                    deque.add(new Locate(i,j));
                }
                if(num == -1){
                    minus++;
                }
            }
        }

        BFS();
        System.out.println(result);

    }

    public static void BFS(){
        int[] dx= {0,0,1,-1};
        int[] dy= {1,-1,0,0};
        int ans =0;

        while(true){
            Deque<Locate> temp = new ArrayDeque<>();
            int test = ans;
            while(!deque.isEmpty()){
                Locate lc = deque.poll();
                ans++;
                for(int i=0;i<4;i++){
                    int nx = lc.x +dx[i];
                    int ny = lc.y +dy[i];
                    if(nx>=0 && nx<M && ny>=0 && ny<N && tomato[nx][ny] ==0){
                        tomato[nx][ny]=1;
                        temp.add(new Locate(nx,ny));

                    }
                }

            }

            deque = temp;
            if(ans == N*M-minus){
                break;
            }

            if(test == ans){
                result = -1;
                break;
            }
            result++;
        }


    }

}
