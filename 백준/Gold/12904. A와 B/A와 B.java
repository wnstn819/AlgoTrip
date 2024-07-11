import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();

        s.append(st.nextToken());
        t.append(br.readLine());

        while(s.length() < t.length()){

            if(t.charAt(t.length()-1) == 'A'){
                t.deleteCharAt(t.length()-1);
            }else{
                t.deleteCharAt(t.length()-1);
                t.reverse();
            }
        }

        if(s.toString().contentEquals(t.toString())){
            System.out.println(1);
        }else{
            System.out.println(0);
        }





    }

}
