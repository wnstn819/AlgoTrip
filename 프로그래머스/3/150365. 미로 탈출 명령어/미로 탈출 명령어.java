class Solution {
        static int[] dx = {1,0,0,-1};
        static int[] dy = {0,-1,1,0};
        static String[] direction = {"d","l","r","u"};
        static String result ="";
        static int N,M;
        static boolean fin = false;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        N = n;
        M = m;
        
        int diff = Math.abs((r-1)-(x-1)) + Math.abs((c-1)-(y-1));
        dfs(x-1,y-1,r-1,c-1, k, "",diff);
        answer = result.equals("") ? "impossible" : result;
        
        
        return answer;
    }
    
    public void dfs(int startX, int startY,int endX,int endY, int k , String str, int diff){
        if(k==0 && startX == endX && startY == endY){
            result = str;
            fin = true;
            return;
        }
        
        if(k==0 || fin){
            return;
        }
        for(int i =0;i<4;i++){
            int nx = startX + dx[i];
            int ny = startY + dy[i];
            if(0<= nx && nx<N && 0<= ny && ny<M && diff <=k){
                if((diff % 2 == 0 && k % 2 == 0) || (diff %2 == 1 && k %2 == 1)){
                dfs(nx,ny,endX,endY, k-1, str+direction[i],Math.abs(nx-endX) + Math.abs(ny-endY));
                }
            }
        }
        
    }
}