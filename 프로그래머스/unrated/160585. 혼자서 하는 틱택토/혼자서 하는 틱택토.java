class Solution {
    
        static char[][] list; 
    public int solution(String[] board) {
        int answer = 1;
        int ocnt = 0;
        int xcnt = 0;
        
        list = new char[3][3];
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                char c = board[i].charAt(j);
                list[i][j] = c;
                switch(c){
                    case 'O':
                        ocnt++;
                        break;
                    case 'X':
                        xcnt++;
                        break;
                }
                
            }
        }
        
        if(xcnt > ocnt || ocnt - xcnt > 1){
            return 0;
        }
        
        if(game('O') && game('X')){
            return 0;
        }
        
        if(game('O')){
           if(ocnt == xcnt){
                return 0;
           }
        }
        
        if(game('X')){
            if(ocnt > xcnt){
                return 0;
            }
        }
        return answer;
        
    }

    
    public boolean game(char c){
        boolean check =false;
        for(int i=0;i<3;i++){
            if(list[i][0] == c && list[i][1] == c && list[i][2] ==c){
                check = true;
            }
            
            if(list[0][i] == c && list[1][i] == c && list[2][i] ==c){
                check = true;
            }
            

        }
        
         if(list[0][0] == c && list[1][1] == c && list[2][2] ==c){
               check = true;
            }
         if(list[2][0] == c && list[1][1] == c && list[0][2] ==c){
                check = true;
            }
        return check;
    }
}