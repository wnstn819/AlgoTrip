package 추가문제.S3_10974_모든순열;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
        public static int N;
        public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
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
