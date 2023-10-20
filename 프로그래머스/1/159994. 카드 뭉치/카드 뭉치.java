class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int number1 = 0;
        int number2 = 0;
        int number3 = 0;
        
        
        while(number3 < goal.length){
            if(number1 < cards1.length && cards1[number1].equals(goal[number3]) ){
                number1++;
                number3++;
                continue;
            }
            if(number2 < cards2.length && cards2[number2].equals(goal[number3])){
                number2++;
                number3++;
                continue;
            }
            
            answer = "No";
            break;
            
        
        }
        return answer;
    }
}