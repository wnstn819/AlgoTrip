import java.io.*;
import java.util.*;

public class Main {
        public static int N,M = 0;
        static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        ArrayList<Node> arr = new ArrayList<>();
        dp= new int[N];

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr.add(new Node(n,m));

        }

        arr.sort((o1, o2) -> o1.x - o2.x);

        dp[0] = 1;

        for(int i=1;i<N;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(arr.get(i).y > arr.get(j).y){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int max =Integer.MIN_VALUE;
        for(int j=0;j<N;j++) {
            if(dp[j]>max)
                max = dp[j];
        }

        System.out.println(N-max);

    }

}

class Node implements Comparable<Node> {
    int x,y;
    Node(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(Node o) {

        return  this.y - o.y;
    }
}