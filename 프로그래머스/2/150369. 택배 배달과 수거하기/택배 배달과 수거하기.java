
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int num = 0;
        for(int i =n-1;i>=0;i--){
            if(deliveries[i] > 0 || pickups[i] > 0){
                num = i;
                break;
            }
        }
        
        int d =0;
        int p =0;
        for(int i=num;i>=0;i--){
            d += deliveries[i];
            p += pickups[i];
            
            while(d > 0 || p > 0){
                d -= cap;
                p -= cap;
                answer += ((i+1)*2);
            }
        
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//         long answer = 0;
//         int deliver = 0, pickup = 0;
//         for(int i = n-1; i >= 0; i--){
//             deliver += deliveries[i];
//             pickup += pickups[i];
//             while (deliver > 0 || pickup > 0){
//                 deliver -= cap;
//                 pickup -= cap;
//                 answer += ((i+1) * 2);
//             }

//         }
        return answer;
    }
}