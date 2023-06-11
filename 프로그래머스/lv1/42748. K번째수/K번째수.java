import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0;i<commands.length;i++){
            int start =commands[i][0];
            int end =commands[i][1];
            int number =commands[i][2];
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = start-1; j<end;j++){
                list.add(array[j]);
            }
            
            Collections.sort(list);
            
            answer[i] = list.get(number-1);
            
        }
        return answer;
    }
}