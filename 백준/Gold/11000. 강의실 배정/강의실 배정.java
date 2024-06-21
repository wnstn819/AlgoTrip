import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> que = new PriorityQueue<>((o1,o2)->{
            if(o1[0] == o2[0]){
                return o1[1]-o2[1];
            }else{
                return o1[0]-o2[0];
            }
        });

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            que.add(new int[]{n,m});
        }

        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.add(0);

        while(!que.isEmpty()){
            int[] list = que.poll();
            if(list[0] >= room.peek()){
                room.poll();
            }
            room.add(list[1]);

        }

        System.out.println(room.size());





    }

}
