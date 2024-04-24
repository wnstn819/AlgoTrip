import java.util.*;

class Solution {
    static int min = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> arr;
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        arr = new ArrayList<>();
        
        for(int i =0;i<n;i++){
            arr.add(new ArrayList<>());
        }
        
        for(int i=0;i<wires.length;i++){
            arr.get(wires[i][0]-1).add(wires[i][1]-1);
            arr.get(wires[i][1]-1).add(wires[i][0]-1);
            
        }
        
        for(int i =0;i<wires.length;i++){
            BFS(wires[i][0]-1,wires[i][1]-1,n);
        }
        return min;
    }
    
    public void BFS(int start,int end ,int n){
        boolean[] visited = new boolean[n];
        visited[end] = true;
        int result =0;
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        result++;
        
        while(!que.isEmpty()){  
            int number = que.poll();    
            
            for(int i =0;i<arr.get(number).size();i++){
                int nx = arr.get(number).get(i);
                if(!visited[nx]){
                    que.add(nx);
                    result++;
                    visited[nx] = true;
                }
            }
        }
        int m = n - (result);
        int m2 = n - m;
        min = Math.min(Math.abs(m-m2), min);
        
        
    }
}