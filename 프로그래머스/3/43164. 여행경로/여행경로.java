import java.util.*;
class Solution {
        
        public static ArrayList<String> list;
        public static boolean[] visited;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        list = new ArrayList<>();
        visited = new boolean[tickets.length +1];
        
        DFS(tickets, "ICN", "ICN", 0);
 
        
        Collections.sort(list);
        
        answer = list.get(0).split(" ");
    
        return answer;
    }
    
    public static void DFS(String[][] tickets,String start, String trip  ,int depth){
        if(depth == tickets.length){
            list.add(trip);
            return;
        }
        
        for(int i =0 ; i<tickets.length;i++){
            if(!visited[i] && start.equals(tickets[i][0])){
                visited[i] = true;
                DFS(tickets, tickets[i][1], trip + " " + tickets[i][1], depth + 1);
                visited[i] = false;
                
            }
        }
        
    }
}