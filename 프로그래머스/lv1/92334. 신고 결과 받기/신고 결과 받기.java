import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String,HashSet<String>> map = new HashMap();
        HashMap<String,Integer> idx = new HashMap();
  
        for(int i =0;i<id_list.length;i++){
            map.put(id_list[i],new HashSet());
            idx.put(id_list[i],i);
        }
        
        
        for(int i =0;i<report.length;i++){
            String from = report[i].split(" ")[0];
            String to = report[i].split(" ")[1];
            map.get(to).add(from);
        }
        
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> send = map.get(id_list[i]);
            
            if(send.size() >= k ){
                for(String s : send){
                    answer[idx.get(s)]++;
                }
            }
        }
    
        return answer;
    }
}