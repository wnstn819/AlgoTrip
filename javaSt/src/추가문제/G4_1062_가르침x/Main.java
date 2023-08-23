package 추가문제.G4_1062_가르침x;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
        public static int N,M,result =0;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for (int i = 0; i <N;i++) {
            String str = br.readLine();
            HashSet<Character> hset = new HashSet<>();
            for(char c : str.toCharArray()){
                hset.add(c);
            }
            if(hset.size() <=M){
                result++;
            }

        }

        System.out.println(result);




    }

}
