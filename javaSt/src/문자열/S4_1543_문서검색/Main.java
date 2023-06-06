package 문자열.S4_1543_문서검색;

import java.io.*;
import java.util.*;

public class Main {
    public static String str1, str2;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringBuilder sb = new StringBuilder();

        str1 = br.readLine();
        str2 = br.readLine();
        int count =0;
        while(true){
            if(str1.contains(str2)){
                str1 = str1.replaceFirst(str2,"1");
                count++;

            }else{
                break;
            }

        }
        System.out.print(count);



    }

}
