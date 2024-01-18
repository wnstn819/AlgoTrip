import java.io.*;
import java.util.*;

public class Main {
        public static int N,M,result =0;
        static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        N = Integer.parseInt(st.nextToken());
        arr= new int[N][2];

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(arr,(o1,o2)-> {

            if(o1[0] == o2[0]){
                return o1[1]-o2[1];
            }
            return o1[0] - o2[0];
        });


        int start = arr[0][0];
        int end = arr[0][1];
        result = end - start;
        for(int i=1;i<N;i++){
            // 선이 이어질 때 i-1의 end값보다 i의 start값이 더 작거나 같으면
            if(end >= arr[i][0]){
                // 결과값에 이어진 길어만큼 더하면 됨
                if(end == arr[i][1]){
                    continue;
                }else if(end >= arr[i][1]){
                    continue;
                }
                result += arr[i][1] - end;
                end = arr[i][1];
            }
            // 안 이어질 때 i-1의 end값보다 i의 start값이 크면
            else{

                start = arr[i][0];
                end = arr[i][1];
                result += end - start;

            }

        }

        System.out.println(result);



    }

}
