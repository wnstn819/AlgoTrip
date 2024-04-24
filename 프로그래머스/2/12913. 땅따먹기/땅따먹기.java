class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int[][] dp = new int[land.length][land[0].length];
        
        for(int i =0;i<land[0].length;i++){
            dp[0][i]  = land[0][i];
        }
        
        for(int i =1;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                dp[i][j] = land[i][j] + cal(i,j,dp);
            }
            
        }
        
       
        for(int i=0;i<land[0].length;i++){
            answer = Math.max(answer,dp[land.length-1][i]);
        }
        return answer;
    }
    public int cal(int k, int j,int[][] land){
        int result =0;
        for(int i=0;i<land[0].length;i++){
            if(i != j){
                result = Math.max(land[k-1][i],result);
            }
        }
        
        return result;
        
    }
}