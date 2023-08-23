package Programmers;

import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,(x,y)-> x[1]-y[1]);

        int end = targets[0][1];
        answer ++;
        for(int i =1 ;i<targets.length;i++){
            if(end<=targets[i][0]){
                answer++;
                end = targets[i][1];
            }
        }

        return answer;
    }
}