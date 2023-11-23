import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        
        Queue<Long> que1 = new LinkedList<>();
        Queue<Long> que2 = new LinkedList<>();
        long sum1=0,sum2=0;
        int count=0;
        int len = (queue1.length + queue2.length) * 2;
        for(int i : queue1){
            que1.add((long)i);
            sum1 += i;
        }
        
        for(int i : queue2){
            que2.add((long)i);
            sum2 += i;
        }
        
        long allSum = (sum1 +sum2)/2;
        while(!que1.isEmpty() && !que2.isEmpty() && len >=0 ){
            long num =0;
            if(sum1> allSum){
                num = que1.poll();
                sum1-=num;
                sum2+=num;
                que2.add(num);
            }else if(sum1 < allSum){
                num = que2.poll();
                sum1+=num;
                sum2-=num;
                que1.add(num);    
            }else{
                return count;
            }
            count++;
            len--;
        }
        
        
        
        return answer;
    }
}