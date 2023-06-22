import java.util.*;

class Solution {
    public String solution(String number, int k) {
         char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i<number.length(); i++) {  // 하나씩 돌면서
            char c = number.charAt(i); 
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) { // top보다 큰값이면 pop()!
                stack.pop(); 
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}