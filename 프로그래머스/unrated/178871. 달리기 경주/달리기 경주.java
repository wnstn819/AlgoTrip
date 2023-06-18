import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String,Integer> map = new HashMap();
        
        for(int i=1; i<=players.length;i++){
            map.put(players[i-1],i);
        }
        
        for(String s : callings){
            int i = map.get(s);
            String temp = players[i-2];
            players[i-2] = players[i-1];
            players[i-1] = temp;
            map.put(players[i-2],map.get(players[i-2])-1);
            map.put(players[i-1],map.get(players[i-1])+1);
            
        }
        
        
        List<String> keySet = new ArrayList<>(map.keySet());
        
        keySet.sort((o1,o2) -> map.get(o1).compareTo(map.get(o2)));
   
        
        int index =0;
          for(String s : keySet){
            answer[index] = s;
              index++;
        }
    
        return answer;
    }
}