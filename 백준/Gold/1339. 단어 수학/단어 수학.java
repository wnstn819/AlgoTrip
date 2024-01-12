import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;
        static Integer[] alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        alpha = new Integer[26];
        Arrays.fill(alpha,0);


        for(int i =0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<str.length();j++){
                alpha[str.charAt(j)-'0'-17] += (int) Math.pow(10,str.length()-(j+1));
            }

        }

        Arrays.sort(alpha,Collections.reverseOrder());

        int count = 9;
        int result =0;
        for(int i: alpha){
            result += i*count;
            count--;
        }
        System.out.println(result);
    }

}
