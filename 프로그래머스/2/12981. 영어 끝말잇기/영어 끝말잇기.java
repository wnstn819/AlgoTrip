import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};    
        
        Set<String> set = new HashSet();
        int play = 1;
        String prev = words[0];
        set.add(prev);
        
        for(int i=1;i<words.length;i++){
            String next = words[i];
            if(next.length() <=1 || set.contains(next) == true || prev.charAt(prev.length() -1) != next.charAt(0)){
                
                break;             
            }
            set.add(next);
            prev = next;
            play++;
        
            
        }
        if(play == words.length){
            answer = new int[] {0,0};
        }else{
            play++;
            answer = new int[]{play%n == 0 ? n : play%n , play%n == 0 ? play/n : play/n + 1};
            
        }

        return answer;
    }
}