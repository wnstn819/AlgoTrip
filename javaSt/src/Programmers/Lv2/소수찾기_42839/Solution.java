package Programmers.Lv2.소수찾기_42839;

import java.util.*;

class Solution {
    public static boolean[] visited;
    public static char[] paper;
    public static Set<Integer> set = new HashSet();
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        paper = numbers.toCharArray();
        DFS("");
        answer = set.size();

        return answer;
    }



    public static void DFS(String s){

        if(s != "" && check(Integer.parseInt(s))){
            if(!s.substring(0,1).equals("0")){
                set.add(Integer.parseInt(s));
            }
        }

        for(int i =0;i<paper.length;i++){
            if(!visited[i]){
                visited[i] = true;
                DFS(s+paper[i]);
                visited[i] = false;
            }
        }

    }


    public static boolean check(int n){

        if(n == 1 ){
            return false;
        }

        for(int i =2;i<n/2 + 1;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}