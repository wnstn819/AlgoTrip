import java.io.*;
import java.util.*;

class List{
    public int number;
    public int depth;
    List(int number,int depth){this.number = number;
        this.depth = depth;
    }

}

public class Main {
    static char[][] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb  = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        List[] arr = new List[N+1];
        for (int i =0;i<N+1;i++){
            arr[i]= new List(0,Integer.MAX_VALUE);
        }
        arr[N] = new List(N,0);
        for (int i = N; i>=1 ;i--){
            if (i % 3 == 0 && arr[i/3].depth > arr[i].depth+1){
                arr[i/3] = new List(i,arr[i].depth+1);
            }

            if (i % 2 == 0 && arr[i/2].depth > arr[i].depth+1){
                arr[i/2] = new List(i,arr[i].depth+1);
            }

            if (arr[i-1].depth > arr[i].depth+1) {
                arr[i - 1] = new List(i, arr[i].depth + 1);
            }
        }

        int number = 1;
        System.out.println(arr[1].depth);
        sb.insert(0,number);
        for (int i =0;i <arr[1].depth;i++){
            sb.insert(0,arr[number].number+" ");
            number = arr[number].number;
        }
        System.out.println(sb);


    }




}
