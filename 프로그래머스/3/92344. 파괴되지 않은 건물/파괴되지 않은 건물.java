class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][] list = new int[N+1][M+1];
        int[][] dp = new int[N+1][M+1];
        for(int i =0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                list[i][j] = board[i][j];
            }
        }
        
        for(int[] arr : skill){
            int r1 = arr[1];
            int c1 = arr[2];
            int r2 = arr[3];
            int c2 = arr[4];
            int degree =arr[5] * (arr[0] == 1 ? -1 : 1);
            
            dp[r1][c1] += degree;
            dp[r2+1][c1] += (degree * -1);
            dp[r1][c2+1] += (degree * -1);
            dp[r2+1][c2+1] += degree;
    
         
        }
        
        
       for(int i =0;i<=M;i++){
           for(int j=1;j<=N;j++){
                dp[j][i] = dp[j-1][i] + dp[j][i]; 
           }
       }
         
        
       for(int i =0;i<=N;i++){
           for(int j=1;j<=M;j++){
                dp[i][j] = dp[i][j-1] + dp[i][j]; 
           }
       }
    
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                board[i][j] += dp[i][j];
                if(board[i][j] >0){
                    answer++;
                }
            }
        }
        
        
        
        
        return answer;
    }
}