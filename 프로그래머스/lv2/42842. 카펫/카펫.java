class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        int x = sum/3; int y = 3;
        
       
        while((x-2)*(y-2) != yellow){
            y++;
            x = sum/y;
        }

        
        System.out.println(x+" " + y);
        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }
}