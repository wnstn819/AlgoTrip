import java.util.*;
class Solution {
        public static Set<Integer> set = new HashSet<>();
    public int solution(int[] nums) {
        int answer = 0;
        
        for(int i : nums){
            set.add(i);
        }
        
       
        if(set.size() > nums.length/2){
            answer = nums.length/2;
        }else{
            answer = set.size();
        }
        return answer;
    }
}