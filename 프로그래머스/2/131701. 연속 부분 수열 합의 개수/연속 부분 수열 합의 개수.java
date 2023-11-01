import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int[] arr = new int[elements.length * 2];
        Set<Integer> list = new HashSet<>();
        for(int i=0;i<elements.length;i++){
            arr[i] = arr[i+elements.length] = elements[i];
        }
        
        for(int i=0;i<elements.length;i++){
            int sum =0;
            for(int j =i;j<i+elements.length;j++){
                sum += arr[j];
                list.add(sum);
            }
        }
        
        answer = list.size();
        
        return answer;
    }
}