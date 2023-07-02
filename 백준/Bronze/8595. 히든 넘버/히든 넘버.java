import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String str = st.nextToken();

        long sum =0 ;
        long ans= 0;
        for(char c : br.readLine().toCharArray()){
            if(c-'0'<10){
                if(ans != 0){
                    ans *= 10;
                    ans += c-'0';
                }else{
                    ans += c-'0';
                }

            }else{
                sum += ans;
                ans=0;
            }



        }
        sum+=ans;

        System.out.println(sum);


    }

}
