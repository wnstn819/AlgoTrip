import java.io.*;
import java.util.*;

public class Main {
    static private LinkedList<Integer> arr[];
    static private boolean[] visited;
    static int N,M,result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());



        for (int i =0;i<T;i++){

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            result = 0;
            arr = new LinkedList[N];
            visited = new boolean[N];
            for (int z = 0; z<N;z++){
                arr[z] = new LinkedList();
            }

            for (int j = 0; j<M;j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a-1].add(b-1);
                arr[b-1].add(a-1);

            }
            bfs();
            sb.append(result-1+"\n");

        }

        System.out.println(sb);


    }
    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            result++;
            int value = queue.poll();
            int number =arr[value].size();
            for (int i =0;i<number;i++){
                int peek = arr[value].pop();
                if(!visited[peek]){
                    visited[peek] = true;
                    queue.add(peek);
                }
            }
        }


    }

}
