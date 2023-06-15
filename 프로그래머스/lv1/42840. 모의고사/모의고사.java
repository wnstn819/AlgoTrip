import java.util.*;

class Solution {
    public ArrayList solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList();
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        int[] result = new int[3];
        for(int i=0; i<answers.length;i++){
            if(answers[i] == one[i%5]){
                result[0]++;
            }
            
             if(answers[i] == two[i%8]){
                result[1]++;
            }
            
             if(answers[i] == three[i%10]){
                result[2]++;
            }
            
        }
        
        int max = result[0] >= result[1] ? result[0] >= result[2] ? 1: 3 :  result[1]>= result[2] ? 2 : 3;
        
        answer.add(max);
        
        for(int i=0;i<3;i++){
            if(max-1 != i && result[max-1] == result[i]){
                answer.add(i+1);
            }
        }
        
        System.out.println(max);
    
               
        
        return answer;
    }
}