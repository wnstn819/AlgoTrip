package 스택.S2_10799_쇠막대기.S2_5379_키로거;

import java.io.*;
import java.util.*;

public class Main {
        public static int N;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            String str = br.readLine();
            Stack<Character> stack1 = new Stack<>();
            Stack<Character> stack2 = new Stack<>();

            for(char c : str.toCharArray()){
                if(c == '<'){
                    if(!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                }else if(c== '>'){
                    if(!stack2.isEmpty()){
                        stack1.push(stack2.pop());
                    }
                }else if(c=='-'){
                    if(!stack1.isEmpty()){
                        stack1.pop();
                    }

                }else{
                        stack1.push(c);
                }
            }
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }

            StringBuilder sb = new StringBuilder();
            for(char c : stack1){
                sb.append(c);
            }
            System.out.println(sb);



        }


    }

}
