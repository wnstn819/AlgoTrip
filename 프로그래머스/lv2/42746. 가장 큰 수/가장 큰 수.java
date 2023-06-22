import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] num = new String[numbers.length];
       
        
        for(int i = 0; i < num.length; i++){
            num[i] = String.valueOf(numbers[i]);       
        }

        Arrays.sort(num, new Comparator<String>(){
           @Override
            public int compare(String n1, String n2) {
                return (n2+n1).compareTo(n1+n2);
            }
        });
        
        for(String i : num){
            answer += i;
        }
        
        if(answer.charAt(0) == '0'){
            answer = "0";
        }
        
        return answer;
    }
}