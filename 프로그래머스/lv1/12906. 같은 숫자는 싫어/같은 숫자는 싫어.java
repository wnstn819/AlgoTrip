import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        int[] list = new int[arr.length];
        list[0] = arr[0];
        int index =0;
        for(int i =1;i < arr.length;i++){
            if(arr[i] != list[index]){
                 index++;   
                 list[index] = arr[i];
                    
            }
            
        }
        int[] answer = new int[index+1];
        
        for(int i =0;i<=index;i++){
            answer[i]= list[i];
        }
        
        
        

        return answer;
    }
}