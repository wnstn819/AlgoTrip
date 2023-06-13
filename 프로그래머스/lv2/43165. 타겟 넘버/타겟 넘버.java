import java.util.*;

class Solution {
    public static int answer =0;
    public int solution(int[] numbers, int target) {
               
        DFS(numbers,0,0,target);
        
        return answer;
    }
    public void DFS(int[] numbers,int sum,int num,int target){
        if(num == numbers.length){
            if(sum == target){
                answer++;
            }
            return; 
        }
        
      
            int one = numbers[num] + sum;
            DFS(numbers,one,num+1,target);
            one = sum - numbers[num];
            
            one = sum - numbers[num];
            DFS(numbers,one,num+1,target);
            
        
        
    }
}