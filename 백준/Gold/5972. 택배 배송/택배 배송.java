import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;
        static int[] dist;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        ArrayList<Map>[] list= new ArrayList[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 1;i<N+1;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            list[n].add(new Map(m,k));
            list[m].add(new Map(n,k));
        }

        PriorityQueue<Map> que = new PriorityQueue<>();
        dist[1] = 0;
        que.add(new Map(1,0));
        while(!que.isEmpty()) {
            Map current = que.poll();
            

            for(int i = 0; i < list[current.x].size(); i++) {
                Map next = list[current.x].get(i);
                if(dist[next.x] > dist[current.x] + next.cost) {
                    dist[next.x] = dist[current.x] + next.cost;
                    que.add(new Map(next.x, dist[next.x]));
                }
            }
        }


        System.out.println(dist[N]);






    }

}

class Map implements Comparable<Map>{
    int x, cost;

    Map(int x, int cost){
        this.x=x;
        this.cost= cost;
    }
    @Override
    public int compareTo(Map n) {
        return this.cost - n.cost;
    }
}
