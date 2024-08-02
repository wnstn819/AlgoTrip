class Solution {
    static int[] dx = {1,0,-1};
    static int[] dy = {0,1,-1};
    static int rot = 0;
    
    public int[] solution(int n) {
        int number = 0;
        for(int i =1;i<=n;i++){
            number+=i;
        }
        int[] answer = new int[number];
        
        int cur = 2;
        int startX = 0;
        int startY = 0;
        int[][] arr = new int[n][n];
        arr[0][0] = 1;
        int count =0;
        while(count < 3){
           
            int nx = startX + dx[rot];
            int ny = startY + dy[rot];
            
        
            if(nx >= n || nx < 0 || ny >= n || ny < 0 ) {
                button(rot);
                count++;
            }else{
                if(arr[nx][ny] != 0){
                    button(rot);
                    count++;
                }else{
                    arr[nx][ny] = cur;
                    startX = nx;
                    startY = ny;
                    cur++;
                    count =0;
                }
               
            }

        }
        int num = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                answer[num++] = arr[i][j];
            }
        }
        
        return answer;
    }
    
    public void button(int num){
        switch(num){
            case 0 :
                rot = 1;
                break;
            case 1 :
                rot = 2;
                break;
            case 2:
                rot = 0;
                break;
                
        }
        
    }
}