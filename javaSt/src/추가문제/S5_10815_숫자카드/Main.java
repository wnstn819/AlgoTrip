package 추가문제.S5_10815_숫자카드;

import java.io.*;
import java.util.*;


class Test{
    int x;

    Test(int x){
        this.x =x ;
    }
}
public class Main {
        public static int N,M;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int number = Integer.parseInt(st.nextToken());


            int start = 0;
            int end = N-1;
            boolean check = false;
            while(start <= end) {
                int mid = (start + end) / 2;
                if (arr[mid] > number) {
                    end = mid - 1;
                } else if (arr[mid] == number) {
                    check =true;
                    break;
                } else {
                    start = mid + 1;
                }
            }

            if(check){
                sb.append(1).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }

        System.out.print(sb);
    }

    // Set으로 품
//    public static void main(String[] args) throws IOException {
//        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
//
//        N = Integer.parseInt(st.nextToken());
//
//        HashSet<Integer> set = new HashSet<>();
//
//        st = new StringTokenizer(br.readLine());
//        for(int i =0;i<N;i++){
//            set.add(Integer.parseInt(st.nextToken()));
//        }
//
//        M = Integer.parseInt(br.readLine());
//
//        st = new StringTokenizer(br.readLine());
//        for(int i=0;i<M;i++){
//            if(set.contains(Integer.parseInt(st.nextToken()))){
//                sb.append(1).append(" ");
//            }else{
//                sb.append(0).append(" ");
//            }
//        }
//
//        System.out.print(sb);
//    }

}
