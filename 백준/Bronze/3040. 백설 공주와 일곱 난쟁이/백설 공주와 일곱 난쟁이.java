import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] dwarf = new int[9];
    static boolean[] visited = new boolean[9];

    public static void Sol(int start, int depth) {

        if (depth == 7) {
            int sum = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                if (visited[i]) {

                    sb.append(dwarf[i]).append("\n");
                    sum += dwarf[i];

                }
            }
            if (sum == 100) {
                System.out.println(sb.toString());
                System.exit(0);
            }
        }


        for (int i = start; i < 9; i++) {
            visited[i] = true;
            Sol(i + 1, depth + 1);
            visited[i] = false;
        }


    }


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int testCase = 0; testCase < 9; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dwarf[testCase] = Integer.parseInt(st.nextToken());


        }
        Arrays.sort(dwarf);

        Sol(0, 0);


    }
}


