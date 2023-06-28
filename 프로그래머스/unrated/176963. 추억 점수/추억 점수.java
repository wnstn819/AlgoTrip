import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String,Integer> map = new HashMap();
        for(int i=0;i<name.length;i++){
            map.put(name[i],yearning[i]);
        }
        int index=0;
  
        for(String[] args : photo){
            int result =0;
            for(String s : args){
                if(map.get(s) != null){
                    result +=map.get(s);    
                }
                
            }
            answer[index] = result;
            index++;
        }
        
        return answer;
    }
}