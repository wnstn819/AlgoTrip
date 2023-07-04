import java.io.*;
import java.util.*;

public class Main {
        public static int N;
        public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        visited= new boolean[N];

        ArrayList<Integer> arr = new ArrayList<>();
        DFS(0,arr);



    }

    public static void DFS(int depth, ArrayList<Integer> arr){

        if(arr.size() == N){
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                arr.add(i+1);
                DFS(depth + 1,arr);
                arr.remove(arr.size()-1);
                visited[i] = false;
            }

        }
    }

}
