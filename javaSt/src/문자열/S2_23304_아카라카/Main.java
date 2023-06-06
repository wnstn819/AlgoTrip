package 문자열.S2_23304_아카라카;

import java.io.*;
import java.util.*;

public class Main {
        public static char[] arr;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String str = st.nextToken();
        arr = str.toCharArray();
        if (search(0,str.length()-1)){
            System.out.println("K");
        }else{
            System.out.println("F");
        }


    }
    public static boolean search(int start, int end){

        int mid = (start + end)/2;
        if (start >= end ){
            return true;
        }
        for(int i=0;i<mid;i++){
            if(arr[i+start] != arr[end-i]){
                return false;
            }
        }


        if ((end-start+1)%2 ==0 ){
            if(search(start,mid-1) && search(mid,end)){
                return true;
            }else{
                return false;
            }

        }else{
            if(search(start,mid-1) && search(mid+1,end)){
                return true;
            }else{
                return false;
            }


        }




    }

}
