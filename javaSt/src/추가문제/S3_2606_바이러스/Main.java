package 추가문제.S3_2606_바이러스;

import java.io.*;
import java.util.*;

public class Main {
        public static int N,M,result=0;
        public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        for(int i=0;i<N;i++){
            arr.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr.get(n-1).add(m-1);
            arr.get(m-1).add(n-1);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        visited[0]= true;
        while(!deque.isEmpty()){
            int num = deque.pollFirst();
            for(int i =0;i<arr.get(num).size();i++){
                int num2 = arr.get(num).get(i);
                if(!visited[num2]){
                    visited[num2] = true;
                    deque.addLast(num2);
                    result++;
                }


            }

        }

        System.out.println(result);


    }

}
