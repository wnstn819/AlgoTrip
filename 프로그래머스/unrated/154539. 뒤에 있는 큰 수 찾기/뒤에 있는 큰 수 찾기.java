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

class Solution {
    public int[] solution(int[] numbers) {
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