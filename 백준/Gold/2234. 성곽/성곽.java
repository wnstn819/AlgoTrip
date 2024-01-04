import java.io.*;
import java.util.*;

public class Main {
        static int N,M,roomCount=0,roomMax=0,max=0;
        static Room[][] arr;

        static int[] dx = {0,-1,0,1}; // 1,2,4,8 기준
        static int[] dy = {-1,0,1,0}; // 서,북,동,남



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new Room[M][N];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int n = Integer.parseInt(st.nextToken());
                arr[i][j] = new Room(0,n,0);

            }
        }

        for(int i =0;i<M;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j].parent == 0){
                    bfs(i,j);
                    roomCount++;
                }
            }
        }


        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                calRoom(i,j);
            }
        }

        System.out.println(roomCount);
        System.out.println(roomMax);
        System.out.println(max);

    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        arr[x][y].parent = x*N + (y+1); // 부모의 방번호
        int size =0;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            size++;
            for(int i=0;i<4;i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx >=0 && nx<M && ny>=0 && ny<N && arr[nx][ny].parent == 0 && (arr[cx][cy].number & (int)Math.pow(2,i)) == 0 ){
                    queue.add(new int[]{nx,ny});
                    arr[nx][ny].parent = x*N + (y+1);
                }
            }

        }
        arr[x][y].roomSize = size;
        roomMax = Math.max(size,roomMax);

    }

    public static void calRoom(int x, int y){
        // 벽이 있고, 벽 너머의 부모가 다르다면 넓이 더하기
        Room room = arr[x][y];
        for(int i =0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if((room.number & (int)Math.pow(2,i)) !=0  && nx>=0 && nx<M && ny>=0 && ny<N && room.parent != arr[nx][ny].parent){
                int px = (room.parent-1)/N;
                int py = (room.parent-1)%N;
                int nxP = (arr[nx][ny].parent-1)/N;
                int nyP = (arr[nx][ny].parent-1)%N;
                max = Math.max(max, arr[px][py].roomSize + arr[nxP][nyP].roomSize);
            }

        }

    }

}

class Room{
        int parent;
        int number;
        int roomSize;
        Room(int x, int number,int size) {
            this.parent = x;
            this.number = number;
            this.roomSize = size;
        }
}