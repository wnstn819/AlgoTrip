import java.io.*;
import java.util.*;

public class Main {
    public static int F,S,G,U,D,result = 0;
    public static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new int[F+1];

        Arrays.fill(visited,-1);

        BFS();
        System.out.println(visited[G] == -1 ? "use the stairs" : visited[G]);

    }

    public static void BFS(){
        Queue<Integer> que = new LinkedList<>();
        que.add(S);
        visited[S] = 0;

        while(!que.isEmpty()){
            int n = que.poll();
            if(n == G){
                break;
            }
            if(n + U <= F && visited[n+U] == -1){
                que.add(n+U);
                visited[n+U] = visited[n]+1;

            }
            if(n - D > 0 && visited[n-D] == -1){
                que.add(n-D);
                visited[n-D] = visited[n]+1;

            }
        }

    }

}

