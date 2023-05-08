package 분할정복.S3_4779_칸토어집합;

import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st;


        String str;
        sb =new StringBuilder();
        sb.append("-");
        func(1); // 시작 인덱스, 시작 길이
        while ((str = br.readLine()) != null){
            st = new StringTokenizer(str);
            System.out.println(sb.substring(0,(int)Math.pow(3,Integer.parseInt(st.nextToken()))));
        }



    }

    public static void func(int start) { //시작 인덱스, 문자열 사이즈

        int newSize=(int)Math.pow(3,start)/3;

        String temp ="";
        for (int i = sb.length(); i>0 ;i--){
            temp += sb.charAt(i-1);
        }
        for (int i = newSize; i<newSize*2;i++){
            sb.append(" ");
        }
        sb.append(temp);

        if(start == 12){
            return;
        }
        func(start+1);




    }



}
