package 정렬.G4_2643_색종이올려놓기;

import java.io.*;
import java.util.*;

public class Main {
        public static int N,result=0;
        public static int[][] list;


    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        list = new int[N][3];

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a>= b){
                list[i][0] = b;
                list[i][1] = a;
            }else{
                list[i][0] = a;
                list[i][1] = b;
            }
            list[i][2] = a * b;
        }


        Arrays.sort(list,(o1, o2)->{

                if(o1[0] != o2[0]){
                    return o2[0]-o1[0];
                }else {
                    return o2[1] - o1[1];
                }
        });
        int max = list[0][2];
        int afterLength = list[0][1];

        for(int[] arr: list){
            //System.out.println(Arrays.toString(arr));
        }
        for(int[] arr: list){
            if(max >= arr[2] && afterLength >= arr[1]){
                    result++;
                    max = arr[2];
                    afterLength=arr[1];
                    System.out.println(Arrays.toString(arr));
            }
        }

        System.out.print(result);






    }

}
