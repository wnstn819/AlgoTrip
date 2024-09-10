import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() -1;
        for(int i =0;i<name.length();i++){
            char c = name.charAt(i);  
            int a = ('Z' -'0' - 17) - (c - '0' - 17)+1;
            System.out.println('Z'- '0' - 17);
            int b = (c - '0' - 17) - ('A' - '0' - 17);
            
            System.out.println(" a : " + a +" b : " + b);
            System.out.println((c - 'A') + " : " + ('Z' - c + 1));
            int min = Math.min(c - 'A', 'Z' - c + 1);
            answer += min; 
            
        }
    
        for(int i=0;i<name.length();i++){
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
               int endA = i + 1;
               while(endA < name.length() && name.charAt(endA) == 'A')
                   endA++;
                
                System.out.println(i + " " +endA);
               move = Math.min(move, i * 2 + (name.length() - endA));
               move = Math.min(move, i + (name.length() - endA) * 2);
            }
        }
        

            
        return answer + move;
    }
}