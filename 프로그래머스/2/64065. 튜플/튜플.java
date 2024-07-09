import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2,s.length()-2).replace("},{","-");
        String str[] = s.split("-");
        
        Arrays.sort(str,(o1,o2) -> {
            return o1.length() - o2.length();
        });
        
        List<Integer> arr = new ArrayList<>();
        for(String st : str){
            String[] temp = st.split(",");
            
            for(String t : temp){
                int i = Integer.parseInt(t);
                
                if(!arr.contains(i)){
                    arr.add(i);
                }
            }
            
            
        }
    
        int[] answer = new int[arr.size()];
        for(int i=0;i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}