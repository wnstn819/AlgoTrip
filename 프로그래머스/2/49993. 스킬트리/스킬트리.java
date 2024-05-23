import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        
        int[] arr = new int[26];
    
        int count = 1;
        for(char c : skill.toCharArray()){
            arr[c-65] = count;
            count++;
        }
              
        for(String str : skill_trees){
            int cc = 1;   
            for(char c : str.toCharArray()){
                if(arr[c-65] != 0 && arr[c-65] != cc){
                    System.out.println(c);
                    answer--;
                    break;
                }else{
                    if(arr[c-65] !=0){
                        cc++;    
                    }
                    
                }
            }
        }
        
        return answer;
    }
}