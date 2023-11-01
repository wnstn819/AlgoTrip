import java.util.*;

class Solution {
    public static boolean[] visited;
    public static Map<Integer,Integer> list;
    public static PriorityQueue<Integer> result;
    public int solution(int[] cards) {
        int answer = 0;
        list = new HashMap<>();
        visited = new boolean[cards.length+1];
        result = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<cards.length;i++){
            list.put(cards[i], i+1);
        }
        
        for(int cd : list.keySet()){
            if(!visited[cd]){
                DFS(cd,0);
            }
        }
        
        int a = 0;
        int b = 0;
        
        a = result.poll();
        b = result.isEmpty() ? 0 : result.poll();
        
        answer = a*b;
        return answer;
    }
    
    public static void DFS(int card, int depth){ 
        visited[card] = true;
        if(visited[list.get(card)]){
            result.add(depth+1);
            return;
        }
        DFS(list.get(card),depth+1);
        
    }
}
