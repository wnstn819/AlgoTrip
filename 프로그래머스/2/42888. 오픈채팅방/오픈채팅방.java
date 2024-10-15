import java.util.*;


class Solution {
    public String[] solution(String[] record) {
        Map<String,String> map = new HashMap<>();
        Queue<String[]> que = new LinkedList<>();
        int n =0;
        for(String str : record){
            String[] action = str.split(" ");
            if(action[0].equals("Enter") || action[0].equals("Change")){
                map.put(action[1],action[2]);    
            }
            if(action[0].equals("Enter") || action[0].equals("Leave")){
                que.add(new String[]{action[1],action[0]});
                n++;
            }
            
        }
        String[] answer = new String[n];
        int count=0;
        while(!que.isEmpty()){
            String[] act = que.poll();
            if(act[1].equals("Enter")){
                answer[count++] = map.get(act[0]) + "님이 들어왔습니다.";
                
            }else if(act[1].equals("Leave")){
                answer[count++] = map.get(act[0]) + "님이 나갔습니다.";
                
            }
            
        }
        
        return answer;
    }
}