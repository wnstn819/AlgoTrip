import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        String str;
        while ((str = br.readLine()) != null){
            st = new StringTokenizer(str);
            sb =new StringBuilder();
            int len = (int) Math.pow(3, Integer.parseInt(st.nextToken()));
            for (int i = 0; i < len; i++) {
                sb.append("-");
            }

            func(0, len);
            System.out.println(sb);


        }



    }

    public static void func(int start,int size) {
        if(size==1) {
            return;
        }
        int newSize=size/3;
        for(int i=start+newSize; i<start+2*newSize; i++) {
            sb.setCharAt(i, ' ');
        }

        func(start, newSize); // 3등분한 문자열에서 첫번째 부분
        func(start+2*newSize, newSize); // 3등분한 문자열의 세번째 부분
    }



}
