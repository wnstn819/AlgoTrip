package DFS.G5_1759_암호만들기;

import java.io.*;
import java.util.*;

public class Main {
        public static int N, M;
        public static String[] arr;
        public static boolean[] visited;
        public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new String[M];
        visited = new boolean[M];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<M;i++){
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);
        ArrayList<String> temp = new ArrayList<>();
        DFS(0,temp);

        System.out.println(sb);


    }

    public static void DFS(int depth, ArrayList<String> ary){
        if (ary.size() == N){
            int find =0;
            int another =0;
            for(String s: ary){
                if(s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")){
                    find++;
                }else{
                    another++;
                }

            }
            if(find>0 && another>1){
                for(String s : ary){
                    sb.append(s);
                }
                sb.append("\n");
            }


        }

        for(int i=depth;i< arr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                ary.add(arr[i]);
                DFS(i+1,ary);
                ary.remove(ary.size()-1);
                visited[i] = false;
            }
        }
    }

}
