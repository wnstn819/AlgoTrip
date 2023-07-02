import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String str = st.nextToken();


        int text=0;
        if(str.charAt(0) == '0'){
            if(str.charAt(1) == 'x'){
                text=Integer.parseInt(str.substring(2,str.length()),16);
            }else{
                text=Integer.parseInt(str.substring(0,str.length()),8);
            }

        }else{
            text = Integer.parseInt(str);
        }

        System.out.println(text);


    }

}
