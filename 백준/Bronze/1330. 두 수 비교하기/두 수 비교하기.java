import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (N>M){
            System.out.println(">");
        }else if(N<M){
            System.out.println("<");
        }else{
            System.out.println("==");
        }



    }

}
