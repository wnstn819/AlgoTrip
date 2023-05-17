import java.io.*;
import java.util.*;


class Line implements Comparable<Line>{
    int x;
    int cost;
    Line(int x , int cost){
        this.x=x;
        this.cost=cost;
    }

    @Override
    public int compareTo(Line o) {
        return this.cost - o.cost;
    }
}

public class Main {
    public static int n,m;
    public static List<ArrayList<Line>> line;
    public static int[] dp,result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        line = new ArrayList<>();
        dp = new int[n+1];
        result = new int[n+1];

        for (int i =0;i<n+1;i++){
            line.add(new ArrayList<Line>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a,b,cost;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            line.get(a).add(new Line(b,cost));
        }


        st = new StringTokenizer(br.readLine());
        int sC = Integer.parseInt(st.nextToken());
        int sA = Integer.parseInt(st.nextToken());


        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[sC] = 0;
        bfs(sC);

        int count =0;

        System.out.println(dp[sA]);
        while(dp[sA] != 0){
            count++;
            sb.insert(0,sA + " ");
            sA = result[sA];
        }
        sb.insert(0,sC+ " ");
        System.out.println(count+1);
        System.out.println(sb);



    }


    public static void bfs(int start){
        PriorityQueue<Line> q = new PriorityQueue<>();
        q.add(new Line(start,0));

        while(!q.isEmpty()){
            Line x = q.poll();
            int cur = x.x;
            if(dp[cur] < x.cost){
                continue;
            }
            for(int i =0;i<line.get(cur).size();i++){
                int nx =line.get(cur).get(i).x;
                int nc = line.get(cur).get(i).cost;

                if(dp[nx] > nc+dp[cur]){ //
                    dp[nx] = nc+dp[cur];
                    result[nx] = cur;
                    q.add(new Line(nx,dp[nx]));
                }

            }
        }
    }

}
