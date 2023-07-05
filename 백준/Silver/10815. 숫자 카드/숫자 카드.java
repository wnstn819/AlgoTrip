import java.io.*;
import java.util.*;

public class Main {
        public static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            if(set.contains(Integer.parseInt(st.nextToken()))){
                sb.append(1).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }

        System.out.print(sb);
    }

}
