import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;

        public static int[] parent;

        static String result = "YES";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        parent = new int[N];

        for(int i = 0 ;i<N;i++){
            parent[i] = i;
        }

        for(int  i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<N;j++){
               int number = Integer.parseInt(st.nextToken());
                if(number == 1){
                    union(i,j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken())-1);
        for(int  i=1;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            if(start != find(num-1)){
                result = "NO";
                break;
            }
        }

        System.out.println(result);





    }

    public static int find(int x){
        if(x == parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y) {
            if(x < y){
                parent[y] = x;
            }else{
                parent[x] = y;
            }
        }
    }

}
