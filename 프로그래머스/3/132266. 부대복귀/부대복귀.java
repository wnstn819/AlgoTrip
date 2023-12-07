import java.util.*;
class Solution {
    
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int[] visited = new int[n+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        ArrayList<Integer>[] list = new ArrayList[n+1];
        
        for(int i =0;i<n+1;i++){
            list[i] = new ArrayList<Integer>();
        }
        
        for(int[] road : roads){
            int road1 = road[0];
            int road2 = road[1];
            list[road1].add(road2);
            list[road2].add(road1);
        }
        
        
        Queue<Road> que = new LinkedList<>();
        que.add(new Road(destination,0));
        visited[destination] = 0;
        while(!que.isEmpty()){
            Road a = que.poll();
            
            for(int i : list[a.x]){
                if(visited[i] == Integer.MAX_VALUE){
                    visited[i] = a.depth+1;
                    que.add(new Road(i,a.depth+1));
                }
            }
        }
        
        for(int i = 0;i<sources.length;i++){
            answer[i] = visited[sources[i]] == Integer.MAX_VALUE ? -1 : visited[sources[i]];
        }
        
        return answer;
    }
}

class Road{
    int x, depth;
    
    Road(int x, int depth){
        this.x = x;
        this.depth = depth;
    }
}