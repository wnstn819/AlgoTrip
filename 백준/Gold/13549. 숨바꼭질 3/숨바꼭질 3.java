import java.io.*;
import java.util.*;

public class Main {
        public static int N,M,result = 0;
        public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int max = Math.max(N,M);
        arr= new int[(max+1)*2];

        Arrays.fill(arr,-1);
        BFS(N);





    }

    public static void BFS(int n){
        Queue<Integer> queue = new LinkedList<>();

        arr[n] = 0;
        queue.add(n);

        while(!queue.isEmpty()){
            int temp = queue.poll();
            if(temp ==M){
                System.out.println(arr[temp]);
                System.exit(0);
            }

            if(temp-1 >=0){
                if (arr[temp-1] == -1 || arr[temp-1] > arr[temp] +1 ){
                    arr[temp-1]= arr[temp] +1;
                    queue.add(temp-1);
                }

            }


            if(temp+1 < M*2 && (arr[temp+1] == -1 || arr[temp+1] > arr[temp] +1 )){
                arr[temp+1]= arr[temp] +1;
                queue.add(temp+1);
            }
            if(temp*2 <M*2 && (arr[temp*2] == -1 || arr[temp*2] > arr[temp] )){
                arr[temp*2] = arr[temp];
                queue.add(temp*2);
            }


        }





    }



}
