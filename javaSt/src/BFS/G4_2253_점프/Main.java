package BFS.G4_2253_점프;

import java.io.*;
import java.util.*;


class Locate {
    int x;
    int depth;
    int speed;

    Locate(int x, int depth, int speed) {
        this.x = x;
        this.depth = depth;
        this.speed = speed;
    }
}

public class Main {
    public static int N, M;
    public static int[] arr;
    public static ArrayList<ArrayList<Integer>> list;
    public static Queue<Locate> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        arr = new int[N + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[n] = -1;
        }
        queue.add(new Locate(1, 0, 1));
        arr[1] = 0;
        while (!queue.isEmpty()) {
            Locate l = queue.poll();
            int idx = l.x;
            int depth = l.depth;
            int speed = l.speed;

            if (speed - 1 > 0 && idx + speed - 1 < N + 1 && arr[idx + speed - 1] >= depth + 1 && !list.get(idx + speed - 1).contains(speed - 1)) {
                arr[idx + speed - 1] = depth + 1;
                queue.add(new Locate(idx + speed - 1, depth + 1, speed - 1));
                list.get(idx + speed - 1).add(speed - 1);
            }


            if (idx + speed < N + 1 && arr[idx + speed] >= depth + 1 && !list.get(idx + speed).contains(speed)) {
                arr[idx + speed] = depth + 1;
                queue.add(new Locate(idx + speed, depth + 1, speed));
                list.get(idx + speed).add(speed);
            }
            if (idx > 1 && idx + speed + 1 < N + 1 && arr[idx + speed + 1] >= depth + 1 && !list.get(idx + speed + 1).contains(speed + 1)) {
                arr[idx + speed + 1] = depth + 1;
                queue.add(new Locate(idx + speed + 1, depth + 1, speed + 1));
                list.get(idx + speed + 1).add(speed + 1);
            }


        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();


        if (arr[N] > N + 1) {
            System.out.print(-1);
        } else {
            System.out.print(arr[N]);
        }


    }

}
