package 추가문제.B1_11653_소인수분해;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        for(int i=2;i< n/2+1;i++){
            while(n %i==0){
                System.out.println(i);
                n/=i;
            }
        }

        if(n != 1){
            System.out.println(n);
        }




    }

}
