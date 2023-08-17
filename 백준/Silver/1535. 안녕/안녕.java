import java.io.*;
import java.util.*;

public class Main {
        public static int N,M,result=0;
        public static int[] L,J;
        public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        L = new int[N];
        J = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            L[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            J[i] = Integer.parseInt(st.nextToken());
        }


        DFS(0,0,100);
        System.out.println(result);

    }

    public static void DFS(int num,int ans, int max){

        if(max <=0){
            return;
        }
        if(ans > result){
            result = ans;
        }
        if(num>=N){
            return;
        }




        for(int i=num;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                max -= L[i];
                ans += J[i];
                DFS(i+1, ans,max);
                max += L[i];
                ans -= J[i];
                visited[i] = false;
            }
        }



    }

}
