import java.io.*;
import java.util.*;

class Locate{
    int x;
    int y;
    Locate(int x, int y){
        this.x = x;
        this.y = y;
    }

}

public class Main {
        public static int N,M,result = Integer.MAX_VALUE;
        public static ArrayList<Locate> home,chicken;
        public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();
        chicken = new ArrayList<>();
        int chickenPlus =0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    home.add(new Locate(i,j));
                }else if(num ==2){
                    chicken.add(new Locate(i,j));
                    chickenPlus++;
                }
            }
        }

        visited = new boolean[chickenPlus];

        ArrayList<Locate> arr = new ArrayList<>();
        DFS(0,arr);

        System.out.println(result);


    }
    public static void DFS(int chik,ArrayList<Locate> arr){
        if(arr.size() == M){
            // 거리 계산
            int res =0;
            for(Locate h: home){
                int ans=Integer.MAX_VALUE;
                for(Locate c: arr){
                    ans = Math.min(ans, Math.abs((h.x-c.x))+Math.abs((h.y-c.y)));
                }
                res += ans;
            }

            result = Math.min(result,res);


        }

        for(int i=chik;i<chicken.size();i++){
            if(!visited[i]){
                visited[i] = true;
                arr.add(chicken.get(i));
                DFS(i+1,arr);
                visited[i] = false;
                arr.remove(arr.size()-1);
            }
        }

    }

}
