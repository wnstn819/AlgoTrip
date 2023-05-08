package Lv2.뒤에있는큰수찾기;

import java.io.*;
import java.util.*;

class test{
    public int x;
    public int y;
    test(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] arr= new int[4];
        int[] result;
        for (int i =0 ;i<4;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = solution(arr);

        for(int i : result){
            System.out.print(i +" ");
        }
    }
    public static int[] solution(int[] numbers) {
        int[] ret = new int[numbers.length];
        Stack<test> stack = new Stack<>();
        for (int i =0;i<numbers.length;i++){
            if (i==0){
                stack.push(new test(numbers[i],i));
            }
            else{

                while (!stack.isEmpty() &&  stack.peek().x < numbers[i]){
                    ret[stack.peek().y] = numbers[i];
                    stack.pop();

                }

                stack.push(new test(numbers[i],i));
            }
        }
        while (!stack.isEmpty()){
            ret[stack.peek().y] = -1;
            stack.pop();
        }

        return ret;
    }
}