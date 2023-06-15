import java.util.*;

class Job{
    int pro, spe;
    
    Job(int pro, int spe){
        this.pro = pro;
        this.spe = spe;
    }
}

class Solution {
    public ArrayList solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList();
        ArrayList<Integer> test = new ArrayList();
        Queue<Job> queue = new LinkedList();
        
        for(int i =0;i<progresses.length;i++){
            queue.add(new Job(progresses[i],speeds[i]));
        }
        
        int index =0;
        while(!queue.isEmpty()){
            
            Job temp = queue.poll();
            int i = (100-temp.pro)/temp.spe;
            int j = (100-temp.pro)%temp.spe;
            
            if(j>0){
                i++;
            }
            answer.add(i); 
            
        }
        int max = answer.get(0);
        int count = 1;
        for(int i=1;i<answer.size(); i++){
           if(answer.get(i) > max){
               test.add(count);
               count=1;
               max = answer.get(i);
           }else{
               count++;
           }
          
        }
        test.add(count);
         
        return test;
    }
    
}