import java.io.*;
import java.util.*;

public class Main {
        public static String sb1, sb2;
        public static int result =0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb1 = st.nextToken();
        sb2 = br.readLine();

        DFS(sb2);
        System.out.println(result);

    }
    public static void DFS(String str){

        if(str.length() == sb1.length()){
            if(str.equals(sb1)){
                result = 1;
                return;
            }
            return;
        }

        if(str.isEmpty()){
            return;
        }

        if(str.charAt(str.length()-1) == 'A'){
            DFS(str.substring(0,str.length()-1));
        }

        if(str.charAt(0) == 'B'){
            StringBuilder temp = new StringBuilder();
            temp.append(str, 1, str.length());
            DFS(temp.reverse().toString());
        }








    }

}
