import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static String[] arr;
    public static ArrayList<String> result = new ArrayList<>();
    public static boolean[] visited = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new String[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }

        DFS( "",0);
        Collections.sort(result);
        System.out.println(result.get(result.size() - 1)); //최댓값
        System.out.println(result.get(0)); //최솟값


    }

    public static void DFS( String str,int depth) {
        if (depth == N + 1) {
            result.add(str);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (depth == 0 || !visited[i] && compare(str.charAt(str.length()-1)-'0',i,arr[depth-1])) {
                visited[i] = true;
                DFS(str+i,depth+1);
                visited[i] = false;

            }

        }


    }
    private static boolean compare(int a, int b, String c) {
        if (c.equals("<")) return a < b;
        else return a > b;
    }

}
