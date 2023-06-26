import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int n = targets.length;
        int[] answer = new int[n];
        int[] number = new int[26];
        
        Arrays.fill(number,101);
        for(String s : keymap){
            for(int i =0;i<s.length();i++){
                number[s.charAt(i)-'0'-17] = Math.min(number[s.charAt(i)-'0'-17],i);
            }
        }
        
        int index =0;
        for(String s : targets){
            int num = 0;
            boolean test = false;
            for(int i =0;i<s.length();i++){
                if(number[s.charAt(i)-'0'-17] != 101){
                    num+= number[s.charAt(i)-'0'-17] +1;    
                }else{
                    test= true;
                    break;
                }
                
            }
            if(num ==0){
                answer[index] = -1;
            }else{
                if(test){
                    answer[index]= -1;
                }else{
                    answer[index] = num;    
                }
                
            }
            index++;
            
        }

        
        return answer;
    }
}