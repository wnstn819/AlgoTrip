import java.io.*;
import java.util.*;

public class Main {
        public static int N,one =-1,two =-1;
        static char[] char1, char2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());

        String str1 = br.readLine();
        String str2 = br.readLine();


       char1 = str1.toCharArray();
       char2 = str1.toCharArray();

       Switch(0,char1);
       one +=1;

       for(int i =1;i<N-1;i++){
           if(char1[i-1] != str2.charAt(i-1)){
               Switch(i,char1);
               one++;
           }

           if(char2[i-1] != str2.charAt(i-1)){
               Switch(i,char2);
               two++;
           }
       }

       if(char1[N-1] != str2.charAt(N-1)){
           Switch(N-1,char1);
           one++;
       }

       if(char2[N-1] != str2.charAt(N-1)){
           Switch(N-1,char2);
           two++;
       }

       if(!new String(char1).equals(str2)){
           one = Integer.MAX_VALUE;
       }

       if(!new String(char2).equals(str2)){
           two = Integer.MAX_VALUE;
       }


       int m = Math.min(one,two);

        System.out.println(m == Integer.MAX_VALUE ? -1 : m+1);




    }

    public static void Switch(int index,char[] arr){
        for(int i=index-1;i<=index+1;i++){
            if(i>=0 && i<N){
                arr[i] = arr[i] == '0' ? '1' : '0';
            }
        }

    }

}
