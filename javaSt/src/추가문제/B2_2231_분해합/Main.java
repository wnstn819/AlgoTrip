package 추가문제.B2_2231_분해합;

import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int start = n-(n/2);

        if(start < 10){
            if(n<10){
                start =0;
            }else{
                start = n-10;
            }
        }
        int result =0;
        for(int i =start;i<n;i++){
            int sum =i;
            int k = i;
            while(k>0){
                sum+=k%10;
                k /= 10;
            }
            if(sum == n){
                result =i;
                break;
            }
        }
        System.out.print(result);

    }

}
