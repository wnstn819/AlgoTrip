import java.util.*;

class Solution {
        static int[] result;
        static HashMap<String, Integer> map;
        static HashMap<Integer,Integer> parent;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        map = new HashMap<>();
        parent = new HashMap<>();
        result = new int[enroll.length];
        
        //map에 번호 넣기
        for(int i=1;i<enroll.length+1;i++){
            map.put(enroll[i-1],i);
        }
        
        
        
        for(int i=1;i<enroll.length+1;i++){
            int num = map.get(referral[i-1]) == null ? 0 : map.get(referral[i-1]);
            parent.put(i,num);
        }
        
        
        for(int i =0;i<seller.length;i++){
            int num = map.get(seller[i]);
            cal(num, amount[i] * 100 );
            
        }
        return result;
    }
    
    public static void cal(int num, int money){
        if(money <= 0 || num == 0) return;
        
        int mine = money;
        int yours = 0;
        
        
        if(money >= 10){
            yours = money/10;
            mine = money - yours;
            
        }   
        result[num-1] += mine;
        
        
        if( parent.get(num) != 0 ){
            cal(parent.get(num),yours);     
        }
        
                
    }
}