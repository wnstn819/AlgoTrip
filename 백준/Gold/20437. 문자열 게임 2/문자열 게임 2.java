import java.io.*;
import java.util.*;

public class Main {
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int t = 0; t < N; t++) {
            String str = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                System.out.println("1 1");
                continue;
            }

            int[] alpha = new int[26];
            for (char c : str.toCharArray()) {
                alpha[c - 'a']++;
            }

            int minLen = Integer.MAX_VALUE;
            int maxLen = -1;

            for (int i = 0; i < str.length(); i++) {
                if (alpha[str.charAt(i) - 'a'] < K) continue;

                int count = 0;
                for (int j = i; j < str.length(); j++) {
                    if (str.charAt(i) == str.charAt(j)) count++;
                    if (count == K) {
                        int length = j - i + 1;
                        minLen = Math.min(minLen, length);
                        maxLen = Math.max(maxLen, length);
                        break;
                    }
                }
            }

            if (minLen == Integer.MAX_VALUE) {
                System.out.println("-1");
            } else {
                System.out.println(minLen + " " + maxLen);
            }
        }
    }
}
