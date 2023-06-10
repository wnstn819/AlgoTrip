import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MIN_VALUE;
        
        for(int[] i : sizes){
            int listmax = Math.max(i[0],i[1]);
            int listmin = Math.min(i[0],i[1]);
            
            mx = Math.max(listmax,mx);
            mn = Math.max(listmin,mn);
        }
        answer = mx * mn;
        return answer;
    }
}