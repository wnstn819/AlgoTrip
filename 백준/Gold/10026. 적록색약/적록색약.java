import java.io.*;
import java.util.*;

public class Main {
        public static int N,M,result =0,result2 =0;
        public static int[][] list, list2;
        public static boolean[][] visited;
        public static int[] dx = {0,0,1,-1};
        public static int[] dy = {1,-1,0,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        list = new int[N][N];
        list2 = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<str.length();j++){
                char a = str.charAt(j);
                list[i][j] = a == 'R' ? 1 : a == 'G' ? 2 : 3;
                list2[i][j] = a == 'B' ? 1 : 2;

            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    BFS(i,j,list);
                    result++;
                }
            }
        }
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    BFS(i,j,list2);
                    result2++;
                }
            }
        }

        System.out.println(result + " " + result2);


    }

    public static void BFS(int i , int j,int[][] type){
        visited[i][j] = true;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(i,j));
        int key = type[i][j];


        while (!que.isEmpty()) {
            Node node = que.poll();

            for(int k=0;k<4;k++){
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];
                if(nx >= 0 && nx <N && ny >=0 && ny <N && !visited[nx][ny] ){
                    if( key == type[nx][ny]){
                        que.add(new Node(nx,ny));
                        visited[nx][ny] = true;
                    }

                }

            }


        }

    }

}
class Node{
    int x,y;
    Node(int x,int y){
        this.x=x;
        this.y=y;
    }

}
