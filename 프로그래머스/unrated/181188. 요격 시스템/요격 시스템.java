import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,(x,y)-> x[1]-y[1]);
        
        int end = targets[0][1];
        answer ++;
        int count =0;
        for(int[] i : targets){
            if(count == 0){
                count++;
                continue;
            }
            
            if(end<=i[0]){
                answer++;
                end = i[1];
            }
        }
        
        return answer;
    }
}