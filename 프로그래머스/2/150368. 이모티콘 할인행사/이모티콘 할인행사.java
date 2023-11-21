class Solution {
        static int[] discount ={10,20,30,40};
        static int userLength,emoticonLength,maxSub,maxCost;
        
        
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        userLength = users.length;
        emoticonLength = emoticons.length;
        int[] disDFS = new int[emoticonLength];
    
        backDFS(0,emoticonLength,users,emoticons,disDFS);
        return new int[]{maxSub,maxCost};
        
    }
    
    public void backDFS(int index, int emoticonLength, int[][] users, int[] emoticons, int[] disDFS)      { 
        if(index == emoticonLength){
            int sub = 0 ;
            int cos = 0 ;
            
            for(int[] user : users){
                
                int userPer = user[0];
                int userCos = user[1];
                
                int sum=0;
                
                for(int i =0;i<emoticonLength;i++){
                    if(disDFS[i]>=userPer){
                        sum += (emoticons[i] * (100- disDFS[i])) / 100;
                    }
                }
                if(sum >= userCos){
                    sub++;
                }else{
                    cos+=sum;
                }
                
            }
            if(maxSub<=sub){
                if(maxSub<sub){
                    maxCost = cos;
                }else{
                    maxCost=Math.max(maxCost,cos);
                }
                maxSub=sub;       
            }
            return;
            
        }else{
            for(int i=0;i<4;i++){
                disDFS[index] = discount[i];
                backDFS(index+1, emoticonLength, users,emoticons,disDFS);
            }
        }
    }
    
}