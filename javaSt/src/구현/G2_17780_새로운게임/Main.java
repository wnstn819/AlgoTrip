package 구현.G2_17780_새로운게임;

import java.io.*;
import java.util.*;

public class Main {
    public static int N, M, result = -1;
    static Info[][] list;
    static Piece[] rotation;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new Info[N][N];
        rotation = new Piece[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                list[i][j] = new Info();
                list[i][j].number = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            list[x - 1][y - 1].deque.add(new Piece(x - 1, y - 1, i, z));
            rotation[i] = new Piece(x - 1, y - 1, i, z);
        }
        boolean fin = false;
        while (result < 1001) {
            result++;
            for (int i = 0; i < rotation.length; i++) {
                Piece piece = rotation[i];
                Info info = list[piece.x][piece.y];
                if (!info.deque.isEmpty() && info.deque.peek().number != piece.number) {
                    continue;
                }


                System.out.println("before = " + piece.x + " : " + piece.y + " : piceNum" + piece.number + " : direc " + piece.direction);
                //move
                move(piece);

                Piece ps = rotation[i];

                if (list[ps.x][ps.y].deque.size() == rotation.length) {
                    fin = true;
                    break;
                }
                System.out.println("moved = " + ps.x + " : " + ps.y);
                System.out.println("----");




            }

            if(fin){
                break;
            }

        }
        System.out.println(result >= 999 ? -1 : result + 1);

    }

    public static void move(Piece piece) {
        int x = piece.x;
        int y = piece.y;
        int direction = piece.direction;

        int nx = x + dx[direction - 1];
        int ny = y + dy[direction - 1];
        // 0 오, 1 왼, 2 위, 3 아래
        System.out.println("direc = " + (direction-1) + " nx = " + nx + " ny : " + ny);
        //흰색 0
        int number =0;
        if( 0 > nx || nx>=N || ny<0 || ny>=N){
            number = 2;
        }else{
            number = list[nx][ny].number;
        }
        switch (number) {
            case (0):
                while (!list[x][y].deque.isEmpty()) {
                    Piece pc = list[x][y].deque.poll();
                    list[nx][ny].deque.add(pc);
                    assert pc != null;
                    rotation[pc.number] = new Piece(nx, ny, pc.number, pc.direction);
                }
                break;
            case (1):
                while (!list[x][y].deque.isEmpty()) {
                    Piece pc = list[x][y].deque.pollLast();
                    list[nx][ny].deque.add(pc);
                    assert pc != null;
                    rotation[pc.number] = new Piece(nx, ny, pc.number, pc.direction);
                }
                break;
            case (2):
                nx = x + dx[reverse(direction - 1)];
                ny = y + dy[reverse(direction - 1)];
                int size = list[x][y].deque.size();
                for(int i =0;i<size;i++){
                    Piece pc = list[x][y].deque.poll();
                    assert pc != null;
                    int changeNum = pc.direction-1;
                    changeNum = i == 0 ? reverse(changeNum) : changeNum;
                    if (0 > nx || nx >= N || 0 > ny || ny >= N || list[nx][ny].number == 2) {
                        rotation[pc.number] = new Piece(x, y, pc.number, changeNum+1);
                        list[x][y].deque.add(pc);
                    } else {
                        if(list[nx][ny].number==1){
                            rotation[pc.number] = new Piece(nx, ny, pc.number, changeNum+1);
                            list[nx][ny].deque.addFirst(pc);
                        }else{
                            rotation[pc.number] = new Piece(nx, ny, pc.number, changeNum+1);
                            list[nx][ny].deque.add(pc);
                        }

                    }

                }
                break;
        }


    }

    public static int reverse(int x) {
        switch (x) {
            case (0) -> {
                return 1;
            }
            case (1) -> {
                return 0;
            }
            case (2) -> {
                return 3;
            }
            case (3) -> {
                return 2;
            }
        }
        return x;
    }

}



class Info{
    int number;
    Deque<Piece> deque = new ArrayDeque<>();


}

class Piece{
    int number, direction, x, y;

    Piece(int x, int y,int number, int direction){
        this.x = x;
        this.y = y;
        this.number = number;
        this.direction = direction;
    }

    void changeInfo(int x, int y, int direction){
        this.x =x;
        this.y =y;
        this.direction = direction;
    }

}
