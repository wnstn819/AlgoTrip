import java.util.*; 

class Solution {
    public int[] solution(int[] fees, String[] records) {        
        Map<String,State> map = new HashMap<>();
        for(String str : records){
            String[] list = str.split(" ");
            String[] timer = list[0].split(":");
            int time = Integer.parseInt(timer[0])*60 + Integer.parseInt(timer[1]);
            int number = Integer.parseInt(list[1]);
            
            int check = list[2].equals("IN") ? 1 : 0;
            if(map.get(list[1]) == null){
                map.put(list[1],new State(time,check,0)); 
            }else{
                    State st = map.get(list[1]);
                if(check == 0){
                    
                
                    map.put(list[1],new State(time,check,st.sum + (time - st.time)));
                }else{
                    map.put(list[1],new State(time,check,st.sum));
                }
            }
        }
        List<String> keySet = new ArrayList<>(map.keySet());

        Collections.sort(keySet);

        int[] answer = new int[map.size()];
        int index =0;
        for(String i : keySet){
            if(map.get(i).check == 1){
                map.put(i,new State(map.get(i).time,map.get(i).check,map.get(i).sum + ((23*60+59) - map.get(i).time)));
            }
            State t = map.get(i);
            int sum =0;
            if((t.sum-fees[0])%fees[2]> 0){
                sum = fees[1] + (((t.sum-fees[0])/fees[2]+1) * fees[3]);
            }else{
                 sum = fees[1] + (((t.sum-fees[0])/fees[2]) * fees[3]);
            }
        
            answer[index] = sum;
            if(t.sum < fees[0]){
                answer[index] = fees[1];
            }
            index++;
            
        }

        return answer;
    }
}

class State{
    int time,check,sum;
    
    State(int time, int check,int sum){
        this.time = time;
        this.check = check;
        this.sum = sum;
    }
}