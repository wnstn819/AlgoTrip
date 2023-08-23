package 추가문제.S2_1406_에디터;

import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Character> deque = new ArrayDeque<>();
        Deque<Character> lastDeque = new ArrayDeque<>();


        for(char c: st.nextToken().toCharArray()){
            deque.add(c);
        }

        int n = Integer.parseInt(br.readLine());

        for(int i =0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char b = ' ';

            switch (a){
                case 'P':
                    b = st.nextToken().charAt(0);
                    deque.addLast(b);
                    break;
                case 'L':
                    if(!deque.isEmpty()) {
                        lastDeque.addFirst(deque.pollLast());
                    }
                    break;
                case 'D':
                    if(!lastDeque.isEmpty()){
                        deque.add(lastDeque.pollFirst());
                    }

                    break;
                case 'B':
                    if(!deque.isEmpty()){
                        deque.pollLast();
                    }
                    break;
                default:
                    break;
            }
                    }

        while(!deque.isEmpty()){
            sb.append(deque.poll());
        }

        while(!lastDeque.isEmpty()){
            sb.append(lastDeque.poll());
        }

        System.out.print(sb);


    }

}
