class Solution {
        public static int[][] arr;
        
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int n = wallpaper.length-1;
        int m = wallpaper[0].length()-1;
        arr = new int[wallpaper.length][wallpaper[0].length()];
        
        for(int i = 0;i<wallpaper.length;i++){
            for(int j =0;j<wallpaper[i].toCharArray().length;j++){
                char c = wallpaper[i].toCharArray()[j];
                if(c == '#'){
                    arr[i][j] = 1;
                }
            }
        }
        
        int sx = n,sy = m,ex = 0,ey = 0 ;
        for(int i=0;i<arr.length;i++){
            for(int j =0;j<arr[i].length;j++){
                if(arr[i][j] == 1 ){
                    sx = Math.min(i,sx);
                    sy = Math.min(j,sy);
                    ex = Math.max(i+1,ex);
                    ey = Math.max(j+1,ey);
                    
                }
            }
             System.out.println();
        }
        answer[0] = sx;
        answer[1] = sy;
        answer[2] = ex;
        answer[3] = ey;
        
        return answer;
    }
}