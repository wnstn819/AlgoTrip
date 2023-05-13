package DFS.S1_2529_부등호;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static int N;
    public static long min = Long.MAX_VALUE,max = Long.MIN_VALUE;
    public static String[] arr;
    public static String minStr,maxStr;
    public static ArrayList<String> result = new ArrayList<>();
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        arr = new String[N+1];
        visited = new boolean[10];
        st = new StringTokenizer(br.readLine());
        for ( int i = 0;i<N;i++){
            arr[i] = st.nextToken();
        }

        DFS(0,result);

        System.out.println(maxStr);
        System.out.println(minStr);


    }

    public static void DFS(int s,ArrayList<String> list){
        if (list.size() == N+1){
            String ans="";
            for(String t : list){
                ans+=t;
            }
            if (min> Long.parseLong(ans)){
                min = Math.min(Long.parseLong(ans),min);
                minStr = ans;
            }

            if (max <Long.parseLong(ans)){
                max = Math.max(Long.parseLong(ans),max);
                maxStr = ans;
            }
            return;
        }


        for (int i =0;i<10;i++){
            boolean mis = false;
            if (list.size() ==0){
                mis = true;
            }
            if (!visited[i]){
                    if(s >0){
                        switch (arr[s-1]){
                            case "<":
                                if(Integer.parseInt(list.get(list.size()-1)) < i){
                                    mis = true;
                                }
                                break;
                            case ">":
                                if(Integer.parseInt(list.get(list.size()-1)) >i){
                                    mis = true;
                                }
                                break;
                        }
                    }
                    if(mis){
                        visited[i] = true;
                        list.add(String.valueOf(i));
                        DFS(s+1,list);
                        visited[i] = false;
                        list.remove(list.size()-1);
                    }

            }

        }


    }

}
