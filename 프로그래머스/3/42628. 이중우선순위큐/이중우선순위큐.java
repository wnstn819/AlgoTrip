import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> que = new PriorityQueue<>();
        PriorityQueue<Integer> que2 = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String str : operations){
            String[] arr = str.split(" ");
            int number = Integer.parseInt(arr[1]);
            if(arr[0].equals("I")){
                que.add(number);
                que2.add(number);
            }else if(arr[0].equals("D") && que.size() >0){
                if(str.charAt(2) == '1'){
                    que.remove(que2.poll());
                }else{
                    que2.remove(que.poll());
                }
            }
        }
        
        if(que.size() == 0){
            answer = new int[]{0,0};
        }else if(que.size() == 1){
            answer = new int[]{que.peek(),que.peek()};
        }
        
        else{
            answer = new int[]{que2.poll(),que.poll()};
        }
        
        
        return answer;
    }
}