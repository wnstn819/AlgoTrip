import java.io.*;
import java.util.*;

public class Main {
        static int N;
        static char[][] arr;
        static ArrayList<Node> list;
        static int[] dx = {0,0,1,-1};
        static int[] dy = {1,-1,0,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        arr = new char[N][N];

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = st.nextToken().charAt(0);
                if(arr[i][j] == 'T'){
                    list.add(new Node(i, j));
                }
            }
        }
        DFS(0);
        System.out.println("NO");

    }

    public static void DFS(int count){
        if(count == 3){
            if (BFS()) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j] == 'X'){
                    arr[i][j] = 'O';
                    DFS(count+1);
                    arr[i][j] = 'X';
                }
            }
        }
    }

    public static boolean BFS(){
        Queue<Node> que = new LinkedList<>();
        for (Node node : list) {
            que.offer(node);
        }

        while(!que.isEmpty()){
            Node node = que.poll();
            for(int  i=0;i<4;i++){
                int nx = node.x;
                int ny = node.y;
                while(true){
                    nx+= dx[i];
                    ny+= dy[i];
                    if(nx <0 || ny <0 || nx>=N || ny>= N) break;
                    if(arr[nx][ny] == 'O') break;
                    if(arr[nx][ny] == 'S') return false;
                }
            }
        }
        return true;
    }

}

class Node{
    int x,y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
