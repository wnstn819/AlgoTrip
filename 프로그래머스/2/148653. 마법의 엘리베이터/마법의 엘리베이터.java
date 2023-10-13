class Solution {
    public int solution(int storey) {
        int answer = 0;
       
        while(storey > 0){
            int n = storey % 10;
            int count =0;
            if(n > 4){
                answer += 10-n;
                
                if(n != 5 || (storey / 10) % 10 >= 5){
                    count++;   
                }
                
            }else{
                answer += n;
            }
            storey /= 10;
            
            storey += count;
           
            
        }
        
        return answer;
    }
}

