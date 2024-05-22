import java.io.*;
import java.util.*;

public class Main {
        public static int L,R,C;
        static StringTokenizer st;
        static int[][][] building;
        static boolean[][][] visited;

        static int[] dx = {0,0,-1,1,0,0};
        static int[] dy = {1,-1,0,0,0,0};
        static int[] dz = {0,0,0,0,1,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            building = new int[L][R][C];
            visited = new boolean[L][R][C];
            Node startNode = null;
            for (int k = 0; k < L; k++) {
                for (int i = 0; i < R; i++) {
                    st = new StringTokenizer(br.readLine());
                    String token = st.nextToken();
                    for (int j = 0; j < C; j++) {
                        building[k][i][j] = Insert(token.charAt(j));
                        if(token.charAt(j) == 'S'){
                           startNode = new Node(k,i,j,0);
                        }

                    }
                }
                br.readLine();
            }

            int count = BFS(startNode);

            if(count > 0 ){
                sb.append("Escaped in " + count + " minute(s).").append("\n");
            }else{
                sb.append("Trapped!").append("\n");
            }

        }
        System.out.print(sb);


    }

    public static int BFS(Node node){
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        visited[node.z][node.x][node.y] = true;
        while(!que.isEmpty()){
            Node nd = que.poll();
            for(int i =0;i<6;i++){
                int nx = nd.x + dx[i];
                int ny = nd.y + dy[i];
                int nz = nd.z + dz[i];
                if(nx >=0 && nx < R && ny >=0 && ny <C && nz >=0 && nz < L && building[nz][nx][ny] != 1 && !visited[nz][nx][ny]){
                    if(building[nz][nx][ny] == 3){
                        return nd.depth+1;
                    }
                    visited[nz][nx][ny] = true;
                    que.add(new Node(nz,nx,ny,nd.depth +1));
                }

            }


        }
        return -1;

    }
    public static int Insert(char c){
        switch (c){
            case '.':
                return 0;
            case 'E':
                return 3;
            default:
                return 1;
        }
    }

}

class Node{

    int x, y, z,depth;
    Node(int z, int x, int y, int depth){
        this.x = x;
        this.y = y;
        this.z = z;
        this.depth = depth;
    }
}
