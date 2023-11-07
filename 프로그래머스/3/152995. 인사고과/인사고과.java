import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        List<Score> list = new ArrayList<>();
        int wanX = scores[0][0];
        int wanY = scores[0][1];
        int result = wanX + wanY;
        

        for(int[] arr : scores){
            list.add(new Score(arr[0], arr[1]));
        }  
  
        Collections.sort(list, (o1,o2) -> {
            if(o2.x == o1.x){
                return o1.y - o2.y;
            }
            
            return o2.x - o1.x;
        });
    
        
        int maxY = 0;
        for(int i =0;i<list.size();i++){
            if(maxY > list.get(i).y){
                
                if(list.get(i).x == wanX && list.get(i).y == wanY){
                    return -1;
                }
            }else{
                maxY = Math.max(maxY,list.get(i).y);
                if(list.get(i).x + list.get(i).y > result){
                    answer++;
                }
            }
            
        }
        
        
        
        return answer+1;
    }
}

class Score{
    int x,y;
    Score(int x, int y){
        this.x= x;
        this.y= y;
    }
}