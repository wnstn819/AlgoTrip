class Solution {
    public static int answer;
    public static StringBuilder sb;
    public static boolean result = false;
    public int solution(String word) {
        sb = new StringBuilder();
        String[] arr = {"A","E","I","O","U"};
        answer = 0;
        if(sb.toString().equals(word)){
            System.out.println(sb);
        }
        DFS(arr,word);
        
        return answer-1;
    }
    
    public static void DFS(String[] arr, String word){
        answer ++;
        if(sb.toString().equals(word)){
            result = true;
            return;
        }
        
        if(sb.length() >= 5){
            return;
        }
        
        for(int i=0;i<5;i++){
            if(!result){
                     sb.append(arr[i]);
            DFS(arr, word);
            sb.deleteCharAt(sb.length()-1);     
            }
           
        }
        
    }
}