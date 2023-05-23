import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;
    public static long result=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            queue.add(Long.parseLong(st.nextToken()));
        }

        for(int i=0;i<M;i++){
            long x =0;
            if(!queue.isEmpty()){
                x = queue.poll();

            }
            long y=0;
            if(!queue.isEmpty()){
                y = queue.poll();
            }
            long sum = x + y;
            queue.add(sum);
            queue.add(sum);

        }

        for(long i : queue){
            result+=i;
        }


        System.out.println(result);


    }

}
