package 문자열.S2_16113_시그널;

import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static char[][] arr;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        arr = new char[5][N / 5];

        String str = br.readLine();


        for (int j = 0; j < N; j++) {
            arr[j / (N / 5)][j % (N / 5)] = str.charAt(j);

        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N/5; i++) {
            if (arr[0][i] == '#') {

                if (i + 2 <= N / 5) {
                    if (arr[0][i + 1] == '#' && arr[0][i + 2] == '#') {

                        list.add(choice(i));

                        i = i + 3;

                        if (i >= N / 5) break;

                        continue;
                    }
                }

                if(arr[3][i] == '#') list.add(1); //(3,i)가 '#'이면 1을
                else{ //그렇지 않으면 4를 추가한다. 4역시 3칸을 차지하기 때문에, i=i+3를 꼭 해준다.
                    list.add(4);
                    i = i+3;
                    if(i >= N/5) break; //i+3의 결과가 범위를 벗어나면 에러가 나기 때문에, 종료구문을 써준다.
                }

            }
        }

        for(int n: list){
            System.out.print(n);
        }
    }


    //###인 경우, (2,3,5,6,7,8,9)중 찾는 함수.
    private static int choice(int x){

        StringBuffer sb = new StringBuffer();
        //한 줄의 String으로 만든다.
        for(int i = 0; i<5; i++){
            for(int j = 0; j<3; j++){
                sb.append(arr[i][j+x]);
            }
        }

        return check(sb.toString());
    }

    private static int check(String sb){

        int result = 10;
        String [] num = new String[10];

        //1과 4는 필요없다.
        num[0] = "####.##.##.####";
        num[2] = "###..#####..###";
        num[3] = "###..####..####";
        num[5] = "####..###..####";
        num[6] = "####..####.####";
        num[7] = "###..#..#..#..#";
        num[8] = "####.#####.####";
        num[9] = "####.####..####";

        for(int i = 0; i<num.length; i++){
            if(sb.equals(num[i])){
                result = i;
                break;
            }
        }
        return result;
    }

}
