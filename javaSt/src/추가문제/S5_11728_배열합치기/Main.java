package 추가문제.S5_11728_배열합치기;

import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            queue.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            queue.add(Integer.parseInt(st.nextToken()));
        }


        while(!queue.isEmpty()){

            sb.append(queue.poll()).append(" ");
        }

        System.out.println(sb);




    }

}
