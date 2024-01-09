import java.util.*;

class Solution {
    public int solution(String s) {
        int length = s.length();
        int result = length;
        
        for(int i=1; i<(length/2)+1;i++){
            StringBuilder sb = new StringBuilder();
            int size = length;
            int count = 1;
            int start =0;
            int end = start+i;
            int num = length;
            for(int j =end;j<length-i+1;j += i){
                
                if(s.substring(start,end).equals(s.substring(j,j+i))){
                    count++;
                }else{
                    int c = 0;
                    int cc = count;
                while(cc > 0){
                    cc /= 10;
                    c++;
                    }
                    
                    num -= count != 1 ? ((count*i) - (i+c)) : 0;    
                    count =1;
                }
                
                start += i;
                end += i;
            
            }
            int t = 0;
            int tt = count;
            while(tt > 0){
                tt /= 10;
                t++;
            }
            num -= count != 1 ? ((count*i) - (i+t)) : 0;    
            result = Math.min(result, num);
            
        }
        return result;
    }
   
}