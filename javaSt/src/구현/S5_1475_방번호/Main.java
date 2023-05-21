package 구현.S5_1475_방번호;

import java.io.*;
import java.util.*;

public class Main {
    public static int[] num;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = new int[10];
        for(char c: st.nextToken().toCharArray()){
            int number = c-'0';
            if(number == 9 || number == 6){
                num[9] ++;
            }else{
                num[c-'0'] ++;
            }

        }

        if (num[9] % 2 ==0){
            num[9] /= 2;
        }else{
            num[9] = (num[9] / 2) + 1  ;

        }

        int result =0;
        for(int i:num){
            if(result < i){
                result = i;
            }
        }

        System.out.println(result);


    }

}
