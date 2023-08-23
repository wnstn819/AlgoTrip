package Programmers.Lv2.올바른괄호_12909;

import java.util.*;

class Solution {
    public static Stack<Character> st = new Stack();
    boolean solution(String s) {
        boolean answer = true;

        for(char c : s.toCharArray()){
            if(c == '('){
                st.add(c);
            }else{
                if(!st.isEmpty()){
                    char a = st.pop();
                    if(a != '('){
                        answer = false;
                    }
                }else{
                    answer = false;
                }

            }
        }



        if(st.size() != 0){
            answer = false;
        }

        return answer;
    }
}