package 그래프탐색.G3_11779_최소비용구하기2;

import java.io.*;
import java.util.*;


class Line{
    int x;
    int cost;
    Line(int x , int cost){
        this.x=x;
        this.cost=cost;
    }
}

public class Main {
    public static int n,m;
    public static List<ArrayList<Line>> line;
    public static int[] dp,result;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
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

        // 그래프에 인접도시 객체 추가
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

        // 거리 값 전부 최댓값으로 초기화
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[sC] = 0;
        bfs(sC); // 다익스트라 시작

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
       Queue<Line> q = new LinkedList<>();
       q.add(new Line(start,0));

        while(!q.isEmpty()){
            Line x = q.poll();
            int cur = x.x;
            if(dp[cur] < x.cost){ // 이미 저장되어 있는 경로의 비용보다, 더 높은 비용의 값이 들어왔을때
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
