package 문자열.S2_1254_팰린드롬만들기;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String str = st.nextToken();
        int num = str.length();

        for(int i=0; i<str.length(); i++) {
            if(count(str.substring(i))) break;
            num++;
        }
        System.out.println(num);
    }

    private static boolean count(String s) {
        int start = 0;
        int last = s.length()-1;

        while(start <= last ) {
            if(s.charAt(start) != s.charAt(last)) return false;

            start++;
            last--;
        }
        return true;
    }
}
