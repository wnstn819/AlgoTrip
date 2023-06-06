package 문자열.S3_1213_팰린드롬만들기;

import java.io.*;
import java.util.*;

public class Main {
        public static char[] arr;
        public static int[] list;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringBuilder sp = new StringBuilder();


        arr = st.nextToken().toCharArray();
        list = new int[26];
        for (char c : arr) {
            list[c - 65]++;
        }

        if(arr.length == 1){
            System.out.print(arr[0]);
            System.exit(0);
        }

        while(true){
            boolean control = false;
            int count =0;
            for(int i=0;i<list.length;i++){
                if(list[i]>1){
                    sb.append((char)(i+65));
                    sp.insert(0,(char)(i+65));
                    list[i]-= 2;
                    control = true;
                }else if(list[i] ==1){
                    count++;
                }
                if(control){
                    break;
                }
            }

            if(!control){
                if(sb.length() ==0 ) {
                    sb.append("I'm Sorry Hansoo");
                    break;
                }else{
                    if(count>1){
                        sb = new StringBuilder();
                        sp = new StringBuilder();
                        sb.append("I'm Sorry Hansoo");
                        break;
                    }
                    for(int i=0;i<list.length;i++){
                        if(list[i]!=0){
                            sb.append((char)(i+65));
                        }
                    }
                }

               break;
            }
        }
        sb.append(sp);
        System.out.print(sb);
    }

}
