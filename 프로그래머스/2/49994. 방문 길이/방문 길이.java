class Solution {
        static int x=5,y=5,answer =0;
        static int[][][] arr;
        static int[] dx = {1,0,-1,0};
        static int[] dy = {0,1,0,-1};
    
    public int solution(String dirs) {
            
        arr = new int[11][11][4];
        
        for(char c : dirs.toCharArray()){
            int number = move(c);
            int nx = x+dx[number];
            int ny = y+dy[number];
           
            if(arr[x][y][number] != 1){
                if(nx >=0 && ny >= 0 && nx < 11 && ny < 11){
                    answer++;
                    arr[x][y][number] = 1;
                    arr[nx][ny][btn(number)] =1;
                    x = nx;
                    y = ny;
                }
           
            }else{
                x = nx;
                y = ny;
            }
        }
        
        
        return answer;
    }
    public static int move(char c){
        int num = -1;
        switch(c){
            case 'U':
                num = 0;
                break;
            case 'R':
                num = 1;
                break;
            case 'D':
                num = 2;
                break;
            case 'L':
                num = 3;
                break;
        }
        return num;
    }
    
    public static int btn(int n){
        switch(n){
            case 0 :
                return 2;
            case 1 :
                return 3;
            case 2:
                return 0;
            case 3:
                return 1;
        }
        return -1;
    }
    
    
}