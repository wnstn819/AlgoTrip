import java.util.*;

class Solution {
        static int[] dx = {0,0,1,-1};
        static int[] dy = {1,-1,0,0};
    
    public ArrayList solution(String[][] places) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i =0;i<5;i++){
            String[] p = places[i];
            int num = 1;
            for(int j=0;j<5;j++){
                
                for(int k =0;k<5;k++){
                   
                    if(p[j].charAt(k) == 'P'){
                        num =BFS(j,k,p); 
                        if(num ==0){
                            break;
                        }
                    }
                    
                }
                if(num ==0){
                            break;
                        }
                
            }
             list.add(num);
        }
        return list;
    }
    
    public int BFS(int x, int y, String[] p){
        
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x,y,0});
        while(!que.isEmpty()){
            int[] arr = que.poll();
            
            for(int i =0;i<4;i++){
                int nx = arr[0]+dx[i];
                int ny = arr[1]+dy[i];
                int depth = arr[2];
               
                if(nx>=0 && nx < 5 && ny>=0 && ny<5 ){
                    if(nx == x && ny == y){
                        continue;
                    }
                    if(p[nx].charAt(ny) == 'O'){
                        if(depth < 1){
                            que.add(new int[]{nx,ny,depth+1});    
                        }
                        
                      
                    }else if(p[nx].charAt(ny) == 'P'){
                        return 0;
                    }else{
                        continue;
                    }
                    

                    
                                        
                }
            }
            System.out.println();
        }
        
        return 1;
    }
}