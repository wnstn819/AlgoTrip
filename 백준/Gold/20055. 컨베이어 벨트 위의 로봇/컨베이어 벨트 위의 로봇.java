import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());

        List<Status> list = new LinkedList<>();

        for(int i =0;i<N*2;i++){
            list.add(new Status(Integer.parseInt(st.nextToken())));
        }


        int count =0;
        int result =0;
        while(count < M){
            Status last = list.remove((N * 2)-1);
            list.add(0,last);
            if (list.get(N - 1).visited) list.get(N - 1).moveRobot();

            for(int i=N-2;i>=0;i--){
                if(list.get(i).visited){
                    if (list.get(i).visited && !list.get(i + 1).visited && list.get(i + 1).value >= 1) {
                        list.get(i).moveRobot();
                        list.get(i + 1).putRobot();
                        if (list.get(i + 1).value == 0) count++;
                    }


                }
            }
            if (list.get(N - 1).visited) list.get(N - 1).moveRobot();

            if (list.get(0).value >= 1) {
                list.get(0).putRobot();
                if (list.get(0).value == 0) count++;
            }



            result++;


        }

        System.out.println(result);



    }

}

class Status{
    int value;
    boolean visited;

    Status(int value){
        this.value = value;
        visited=false;
    }

    public void putRobot(){
        visited=true;
        value--;
    }

    public void moveRobot(){
        visited=false;
    }
}
