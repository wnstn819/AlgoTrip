import java.io.*;
import java.util.*;

public class Main {
        public static int N;
        public static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        str = br.readLine();


        for(int i =0;i<N;i++){
            String s = br.readLine();
            boolean test = false;
            if(s.length() < str.length() -1 ){
                System.out.println("NE");
                continue;
            }
            for(int j=0;j<str.length();j++){
                if(str.charAt(j) == '*'){
                    break;
                }
                if(str.charAt(j) != s.charAt(j)){

                    test = true;
                }
            }
            if(test){
                System.out.println("NE");
                continue;
            }
            for(int j=str.length()-1;j>=0;j--){
                if(str.charAt(j) == '*'){
                    break;
                }
                if(str.charAt(j) != s.charAt(s.length()-1 - (str.length()-1 - j))){
                    test = true;
                }
            }

            if(test){
                System.out.println("NE");
                continue;
            }
            System.out.println("DA");
        }






    }

}
