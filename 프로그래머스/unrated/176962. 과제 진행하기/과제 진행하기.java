import java.util.*;

class Work{
    String name;
    int time;
    int extra;
    
    Work(String name ,String time, String extra){
        this.name = name;
        String[] timeSpl = time.split(":");
        int hour = Integer.parseInt(timeSpl[0]) * 60;
        int min = Integer.parseInt(timeSpl[1]);
        this.time = hour + min;
        this.extra = Integer.parseInt(extra);
        
    }
    
    public void cul(int extra2){
        this.extra -= extra2;
    }
    
    
    
}

class Solution {
    public String[] solution(String[][] plans) {
        int N = plans.length;
        String[] answer = new String[N];
        PriorityQueue<Work> pq = new PriorityQueue<>(new Comparator<Work>(){
            @Override
            public int compare(Work o1, Work o2){
                return o1.time > o2.time ? 1 : -1;
            }
        });
        for(String[] arr: plans){
            Work a = new Work(arr[0],arr[1],arr[2]);
            pq.add(a);
        }
        
        Stack<Work> stack = new Stack<>();
        int count =0;
        while(!pq.isEmpty()){
            Work cur = pq.poll();
            
            String curName = cur.name;
            int curStart = cur.time;
            int curPlaytime = cur.extra;
            
            int curTime = curStart;
            
            if(!pq.isEmpty()){
                Work next = pq.peek();
                
                if(curTime + curPlaytime < next.time) {
                    answer[count] = curName;
                    count++;
                    curTime += curPlaytime;
                    
                    while(!stack.isEmpty()) {
                        Work rem = stack.pop();
                        
                        if(curTime + rem.extra <= next.time) {
                            curTime += rem.extra;
                            answer[count] = rem.name;
                            count++;
                            continue;
                        } 
                        else {
                            rem.cul(next.time - curTime);    
                            stack.push(rem);
                            break;
                        }
                    }
                }  
                else if(curStart + curPlaytime == next.time) {
                    answer[count] = curName;
                    count++;
                    continue;
                }
                else {
                    cur.cul(next.time - curTime);
                    stack.push(cur);
                }
            } else {
                if(stack.isEmpty()) {
                    curTime += curPlaytime;
                    answer[count] = curName;
                    count++;
                }
                else {
                    answer[count] = curName; 
                    count++;
                    while(!stack.isEmpty()) {
                        Work rem = stack.pop();
                        answer[count] = rem.name;
                        count++;
                    }
                }
            }
        }
        
        
        return answer;
    }
}