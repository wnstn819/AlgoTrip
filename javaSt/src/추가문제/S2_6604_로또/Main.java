package 추가문제.S2_6604_로또;

import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;
        public static  int[] arr;
        public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringBuilder sb = new StringBuilder();


        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n ==0){
                break;
            }
            arr = new int[n];
            visited = new boolean[n];
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer> list =new ArrayList<>();
            DFS(0,list);
            System.out.println();



        }


    }

    public static void DFS(int depth,ArrayList<Integer> list){
        if(list.size() == 6){
            for(int i : list){
                System.out.print(i + " ");

            }
            System.out.println();
            return;
        }

        for(int i=depth;i<arr.length;i++){
            if(!visited[i]){
                list.add(arr[i]);
                DFS(i+1,list);
                list.remove(list.size()-1);
            }

        }

    }

}
