import java.util.*;
class Solution {
    static HashSet<HashSet<String>> resultSet = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        
        for(int i=0;i<banned_id.length;i++){
            banned_id[i] = banned_id[i].replace("*",".");
        }
        
        
        boolean[] visited = new boolean[user_id.length];
        DFS(user_id, banned_id, visited, 0, new HashSet<>());
        
        
        return resultSet.size();
    }
    
    public static void DFS(String[] user_id, String[] banned_id, boolean[] visited, int depth, HashSet<String> currentSet){
        
        
        if(depth == banned_id.length){
            resultSet.add(new HashSet<>(currentSet));
            return;
        }
        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i] && user_id[i].matches(banned_id[depth])) {
                visited[i] = true;
                currentSet.add(user_id[i]); 
                DFS(user_id, banned_id, visited, depth + 1, currentSet); 
                visited[i] = false; 
                currentSet.remove(user_id[i]); 
            }
        }
        
        
        
    }
}