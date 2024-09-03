import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Integer[] arr = Arrays.stream(people).boxed().toArray(Integer[]::new);

        
        Arrays.sort(arr, (o1,o2)-> {
            return o2-o1;
        });
        
        int start =0;
        int end = people.length -1;
       
        while(start <= end){
            if(arr[start] + arr[end] > limit){
                answer++;
                start++;
            }else if(arr[start] + arr[end] <= limit){
                answer++;
                start++;
                end--;
            }
        }
       
        
        
        return answer;
    }
}