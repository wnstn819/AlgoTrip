import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int start = 0;
        int end = p.length()-1;
        
        while(end < t.length()){
            StringBuilder sb = new StringBuilder();
            for(int i = start; i<=end;i++){
                sb.append(t.charAt(i));
            }
            
            Long number = Long.parseLong(sb.toString());
            if(number <= Long.parseLong(p)){
                answer++;
            }
            start++;
            end++;
             
        }
        return answer;
    }
}