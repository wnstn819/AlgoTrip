import java.util.*;
class Solution {
    static int[][] map; 
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        
        
        map = new int[rows][columns];
        
        int num = 1;
        for(int i =0;i<rows;i++){
            for(int j=0;j<columns;j++){
                map[i][j] = num;
                num++;
            }
        }
        List<Integer> ar = new ArrayList<>();
        
        
        for(int i=0;i<queries.length;i++){
            int[] arr= queries[i];
            int number = lotation(arr[0]-1,arr[1]-1,arr[2]-1,arr[3]-1);
            ar.add(number);
            
        }
        
    
        answer = new int[ar.size()];
        
        for(int i=0;i<ar.size();i++){
            answer[i] = ar.get(i);
        }
        
        return answer;
        
    }
    
    public static int lotation(int x1, int y1, int x2, int y2){
    int head = 0;
    int fir = map[x1][y1];
    int minNum = fir;
    
    int cx = x1, cy = y1;

    while(true){
        int nx = cx + dx[head];
        int ny = cy + dy[head];
        
        if (nx < x1 || nx > x2 || ny < y1 || ny > y2) {
            head = switchHead(head);
            continue;
        }
        
        int temp = map[nx][ny];
        map[nx][ny] = fir;
        fir = temp;
        minNum = Math.min(minNum, fir);
        
        cx = nx;
        cy = ny;

       
        if (cx == x1 && cy == y1) {
            break;
            }
        }
        map[x1][y1 + 1] = fir;
    
        return minNum;
}

    
    public static int switchHead(int x){
        switch(x){
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 0;
        }
        return x;
        
    }
    
    
    
    
}