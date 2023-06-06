package 문자열.S3_14425_문자열집합;

import java.io.*;
import java.util.*;

public class Main {
        public static int N,M,result =0;
        public static String[] arr;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N];
        for(int i=0;i<N;i++){
            arr[i] = br.readLine();
        }
        for(int i=0;i<M;i++){
            String str = br.readLine();
            for(String s : arr){
                if(s.equals(str)){
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);







    }

}
