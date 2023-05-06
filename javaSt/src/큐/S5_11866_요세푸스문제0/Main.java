// 큐 - 요세푸스 문제 0

package 큐.S5_11866_요세푸스문제0;

import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sb.append("<");
        int count = 1;
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            if (count == K) {
                count = 1;
                if (queue.size() == 1) {
                    sb.append(queue.poll());
                } else {
                    sb.append(queue.poll() + ", ");
                }

            } else {
                queue.add(queue.poll());
                count++;

            }
        }

        sb.append(">");

        System.out.println(sb);
    }

}
